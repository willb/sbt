	import sbt._
	import Keys._
	import Status.{isSnapshot, publishStatus}
	import org.apache.ivy.util.url.CredentialsStore

object Release extends Build
{
	lazy val publishRelease = TaskKey[Unit]("publish-release")
	lazy val publishAllArtifacts = TaskKey[Unit]("publish-all-artifacts")
	lazy val launcherRemotePath = SettingKey[String]("launcher-remote-path")
	lazy val remoteBase = SettingKey[String]("remote-base")
	lazy val remoteID = SettingKey[String]("remote-id")
	lazy val publishLauncher = TaskKey[String]("publish-launcher")
	lazy val fullRelease = TaskKey[Unit]("full-release")
	lazy val prerelease = TaskKey[Unit]("prerelease")

	lazy val pushWiki = TaskKey[Unit]("push-wiki")
	lazy val pushMain = TaskKey[Unit]("push-main")

	val PublishRepoHost = "typesafe.artifactoryonline.com"

	def settings(nonRoots: => Seq[ProjectReference], launcher: ScopedTask[File]): Seq[Setting[_]] =
		if(CredentialsFile.exists)
			releaseSettings(nonRoots, launcher) /* ++ fullReleaseSettings */
		else
			Nil

	def releaseSettings(nonRoots: => Seq[ProjectReference], launcher: ScopedTask[File]): Seq[Setting[_]] = Seq(
		publishTo in ThisBuild <<= publishResolver,
		remoteID <<= publishStatus("typesafe-ivy-" + _),
		credentials in ThisBuild += Credentials(CredentialsFile),
		remoteBase <<= publishStatus( "https://" + PublishRepoHost + "/typesafe/ivy-" + _ ),
		publishAllArtifacts <<= Util.inAll(nonRoots, publish.task),
		publishLauncher <<= deployLauncher(launcher),
		publishRelease <<= Seq(publishLauncher, publishAllArtifacts).dependOn,
		launcherRemotePath <<= (organization, version) { (org, v) => List(org, LaunchJarName, v, LaunchJarName + ".jar").mkString("/") }
	)
	def fullReleaseSettings: Seq[Setting[_]] = Seq(
		pushMain <<= pushMain0,
		prerelease := println(Prerelease),
		fullRelease <<= fullRelease0
	)
	def deployLauncher(launcher: ScopedTask[File]) =
		(launcher, launcherRemotePath, credentials, remoteBase, streams) map { (launchJar, remotePath, creds, base, s) =>
		  "ok"
		}
	def getCredentials(cs: Seq[Credentials], log: Logger): (String, String) =
	{
		Credentials.forHost(cs, PublishRepoHost) match {
			case Some(creds) => (creds.userName, creds.passwd)
			case None => error("No credentials defined for " + PublishRepoHost)
		}
	}
	def snapshotPattern(version: String) = Resolver.localBasePattern.replaceAll("""\[revision\]""", version)
	def publishResolver: Project.Initialize[Option[Resolver]] = (remoteID, remoteBase) { (id, base) =>
		Some( Resolver.url("publish-" + id, url(base))(Resolver.ivyStylePatterns) )
	}

	def updatedRepo(repo: SettingKey[File], remote: SettingKey[String], branch: Option[String]) =
		(repo, remote, streams) map { (local, uri, s) => updated(remote = uri, cwd = local, branch = branch, log = s.log); local }

	def fullRelease0 = Seq(pushMain, publishRelease).dependOn
	def pushMain0 = (baseDirectory, version, streams) map { (repo, v, s) => commitAndPush(v, tag = Some("v" + v))(repo, s.log) }
	def commitAndPush(msg: String, tag: Option[String] = None)(repo: File, log: Logger)
	{
		git("add", ".")(repo, log)
		git("commit", "-m", msg, "--allow-empty")(repo, log)
		for(tagString <- tag) git("tag", tagString)(repo, log)
		push(repo, log)
	}
	def push(cwd: File, log: Logger) = git("push", "--tags", "-n")(cwd, log)
	def pull(cwd: File, log: Logger) = git("pull")(cwd, log)
	def updated(remote: String, branch: Option[String], cwd: File, log: Logger): Unit =
		if(cwd.exists)
			pull(cwd, log)
		else
			branch match {
				case None => git("clone", remote, ".")(cwd, log)
				case Some(b) => git("clone", "-b", b, remote, ".")(cwd, log)
			}

	def git(args: String*)(cwd: File, log: Logger): Unit =
	{
		IO.createDirectory(cwd)
		val full = "git" +: args
		log.info(cwd + "$ " + full.mkString(" "))
		val code = Process(full, cwd) ! log
		if(code != 0) error("Nonzero exit code for git " + args.take(1).mkString + ": " + code)
	}

	final val BinaryType = "binary/octet-stream"
	final val RemoteHost = "typesafe.artifactoryonline.com"
	final val RemoteRealm = "Artifactory Realm"
	final val LaunchJarName = "sbt-launch"
	lazy val CredentialsFile: File = Path.userHome / ".ivy2" / ".typesafe-credentials"

	def Prerelease = """
Before running full-release, the following should be done manually from the root 'xsbt' project:
1. Ensure all code is committed and the working directory is completely clean.  'git status' should show no untracked files.
2. 'test'
3. 'scripted'
4. Set the release version in README, build definition, and in src/main/conscript configurations.
5. Run 'show updated-wiki-repository'.  Update versions, documentation for release in displayed directory.
6. Add notes/<version>.markdown
7. 'preview-notes'
"""
}
