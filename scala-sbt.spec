%global sbt_version 0.12.3
%global bootstrap_sbt_version %{sbt_version}
%global scala_version 2.9.2
%global with_bootstrap 1

Name:           scala-sbt
Version:        %{sbt_version}
Release:        1%{?dist}
Summary:        Simple Build Tool for Scala

License:        Revised BSD
URL:            http://www.scala-sbt.org
Source0:        https://github.com/sbt/sbt/archive/%{sbt_version}.tar.gz
%if 0%{?with_bootstrap}
Source1:	http://repo.typesafe.com/typesafe/ivy-releases/org.scala-sbt/sbt-launch/%{bootstrap_sbt_version}/sbt-launch.jar

%else  # not bootstrapping

BuildRequires:  scala-sbt = %{bootstrap_sbt_version}
%endif # bootstrapping
Patch0:		0001-Use-proguard-4.8-for-Fedora.patch

BuildRequires:  scala = %{scala_version}
BuildRequires:	java-devel
BuildRequires:	jpackage-utils
BuildRequires:  python-pygments
BuildRequires:  python-sphinx
Requires:       scala = %{scala_version}
Requires:	java
Requires:	jpackage-utils

%description
sbt is the Simple Build Tool for Scala and Java projects.


%prep
%setup -q -n sbt-%{sbt_version}
%patch0 -p 1

%build

%if 0%{?with_bootstrap}
curl http://repo.typesafe.com/typesafe/ivy-releases/org.scala-sbt/sbt-launch/%{bootstrap_sbt_version}/sbt-launch.jar > sbt-launch.jar
java -Xms512M -Xmx1536M -Xss1M -XX:+CMSClassUnloadingEnabled -XX:-UseGCOverheadLimit -jar sbt-launch.jar build-all
%else
sbt build-all
%endif

%install
rm -rf $RPM_BUILD_ROOT
%make_install


%files
%doc



%changelog
