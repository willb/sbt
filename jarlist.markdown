## commons-logging

    ./commons-logging/commons-logging/jars/commons-logging-1.0.4.jar
    ./commons-logging/commons-logging/jars/commons-logging-1.1.1.jar

Version 1.1.1 is in F18

## databinder stuff

    ./net.databinder/unfiltered-jetty_2.9.1/jars/unfiltered-jetty_2.9.1-0.6.0.jar
    ./net.databinder/unfiltered_2.9.1/jars/unfiltered_2.9.1-0.6.0.jar
    ./net.databinder/pamflet-knockoff_2.9.1/jars/pamflet-knockoff_2.9.1-0.4.1.jar
    ./net.databinder/dispatch-http_2.9.2/jars/dispatch-http_2.9.2-0.8.8.jar
    ./net.databinder/unfiltered-filter_2.9.1/jars/unfiltered-filter_2.9.1-0.6.0.jar
    ./net.databinder/pamflet-library_2.9.1/jars/pamflet-library_2.9.1-0.4.1.jar
    ./net.databinder/dispatch-core_2.9.2/jars/dispatch-core_2.9.2-0.8.8.jar
    ./net.databinder/dispatch-futures_2.9.2/jars/dispatch-futures_2.9.2-0.8.8.jar
    ./net.databinder/unfiltered-util_2.9.1/jars/unfiltered-util_2.9.1-0.6.0.jar

This is all Scala; none of it is in Fedora ATM.

## commons-codec

    ./commons-codec/commons-codec/jars/commons-codec-1.4.jar
    ./commons-codec/commons-codec/jars/commons-codec-1.2.jar

Version 1.6 is in F18.

## jline

    ./jline/jline/jars/jline-1.0.jar

Version 1.0 is in F18; version 2.5 is also available via the `jline2` package.

## ivy

    ./org.apache.ivy/ivy/jars/ivy-2.3.0-rc1.jar

Version 2.2 is in F18.

## commons-httpclient

    ./commons-httpclient/commons-httpclient/jars/commons-httpclient-3.1.jar

Version 3.1 is in F18.

## jsoup

    ./org.jsoup/jsoup/jars/jsoup-1.6.1.jar

Version 1.6.1 is in Fedora (the `sbt` 0.12.3 build actually calls for 1.7).

## scala-reflect

    ./org.scala-lang/scala-reflect/jars/scala-reflect-2.10.1.jar

This is part of Scala 2.10; need to figure out why it got pulled in to the sbt build.

## Scala testing tools

    ./org.scala-tools.testing/test-interface/jars/test-interface-0.5.jar
    ./org.scala-tools.testing/specs_2.9.1/jars/specs_2.9.1-1.6.9.jar
    ./org.scala-tools.testing/scalacheck_2.9.1/jars/scalacheck_2.9.1-1.9.jar

None of these are in Fedora.

## jgit

    ./org.eclipse.jgit/org.eclipse.jgit.pgm/jars/org.eclipse.jgit.pgm-1.1.0.201109151100-r.jar
    ./org.eclipse.jgit/org.eclipse.jgit/jars/org.eclipse.jgit-1.1.0.201109151100-r.jar
    ./org.eclipse.jgit/org.eclipse.jgit.ui/jars/org.eclipse.jgit.ui-1.1.0.201109151100-r.jar
    ./org.eclipse.jgit/org.eclipse.jgit.iplog/jars/org.eclipse.jgit.iplog-1.1.0.201109151100-r.jar

Version 2.2 is in Fedora.

## args4j

    ./args4j/args4j/jars/args4j-2.0.12.jar

Version 2.0.16 is in Fedora.

## stringtemplate

    ./org.antlr/stringtemplate/jars/stringtemplate-3.2.1.jar

Version 3.2.1 and 4 are both in F18.

## scala-tools stuff

    ./org.scala-tools.sbinary/sbinary_2.9.0/jars/sbinary_2.9.0-0.4.0.jar
    ./org.scala-tools.sxr/sxr_2.9.0/jars/sxr_2.9.0-0.2.7.jar

Not in Fedora.

## httpcomponents

    ./org.apache.httpcomponents/httpcore/jars/httpcore-4.1.4.jar
    ./org.apache.httpcomponents/httpclient/jars/httpclient-4.1.3.jar

Fedora 18 ships `httpcomponents-client` 4.2.1 and `httpcomponents-core` 4.2.2.

## servlet-api

    ./javax.servlet/servlet-api/jars/servlet-api-2.5.jar

In Fedora 18 (as `tomcat6-servlet-2.5-api.noarch`).

## antlr

    ./antlr/antlr/jars/antlr-2.7.7.jar

In Fedora 18.

## jsch

    ./com.jcraft/jsch/jars/jsch-0.1.46.jar
    ./com.jcraft/jsch/jars/jsch-0.1.44-1.jar

`jsch` 0.1.48 is in Fedora 18.

## sbt and plugins

    ./scala_2.9.2/sbt_0.12/com.typesafe.sbt/sbt-site/jars/sbt-site-0.6.0.jar
    ./scala_2.9.2/sbt_0.12/com.typesafe.sbt/sbt-git/jars/sbt-git-0.5.0.jar
    ./scala_2.9.2/sbt_0.12/com.typesafe.sbt/sbt-ghpages/jars/sbt-ghpages-0.5.0.jar
    ./org.scala-sbt/ivy/jars/ivy-0.12.2.jar
    ./org.scala-sbt/task-system/jars/task-system-0.12.2.jar
    ./org.scala-sbt/compiler-interface/jars/compiler-interface-bin-0.12.2.jar
    ./org.scala-sbt/compiler-interface/jars/compiler-interface-src-0.12.2.jar
    ./org.scala-sbt/testing/jars/testing-0.12.2.jar
    ./org.scala-sbt/command/jars/command-0.12.2.jar
    ./org.scala-sbt/test-agent/jars/test-agent-0.12.2.jar
    ./org.scala-sbt/launcher-interface/jars/launcher-interface-0.12.2.jar
    ./org.scala-sbt/run/jars/run-0.12.2.jar
    ./org.scala-sbt/precompiled-2_10_0/jars/compiler-interface-bin-0.12.2.jar
    ./org.scala-sbt/compiler-ivy-integration/jars/compiler-ivy-integration-0.12.2.jar
    ./org.scala-sbt/collections/jars/collections-0.12.2.jar
    ./org.scala-sbt/persist/jars/persist-0.12.2.jar
    ./org.scala-sbt/classfile/jars/classfile-0.12.2.jar
    ./org.scala-sbt/control/jars/control-0.12.2.jar
    ./org.scala-sbt/interface/jars/interface-0.12.2.jar
    ./org.scala-sbt/incremental-compiler/jars/incremental-compiler-0.12.2.jar
    ./org.scala-sbt/precompiled-2_8_2/jars/compiler-interface-bin-0.12.2.jar
    ./org.scala-sbt/cache/jars/cache-0.12.2.jar
    ./org.scala-sbt/compiler-integration/jars/compiler-integration-0.12.2.jar
    ./org.scala-sbt/api/jars/api-0.12.2.jar
    ./org.scala-sbt/main/jars/main-0.12.2.jar
    ./org.scala-sbt/classpath/jars/classpath-0.12.2.jar
    ./org.scala-sbt/logging/jars/logging-0.12.2.jar
    ./org.scala-sbt/compile/jars/compile-0.12.2.jar
    ./org.scala-sbt/process/jars/process-0.12.2.jar
    ./org.scala-sbt/actions/jars/actions-0.12.2.jar
    ./org.scala-sbt/tracking/jars/tracking-0.12.2.jar
    ./org.scala-sbt/tasks/jars/tasks-0.12.2.jar
    ./org.scala-sbt/completion/jars/completion-0.12.2.jar
    ./org.scala-sbt/io/jars/io-0.12.2.jar
    ./org.scala-sbt/sbt/jars/sbt-0.12.2.jar

Presumably these will be available either as bootstrap packages or once the initial package is built.

## jetty

    ./org.eclipse.jetty/jetty-continuation/jars/jetty-continuation-7.6.0.v20120127.jar
    ./org.eclipse.jetty/jetty-http/jars/jetty-http-7.6.0.v20120127.jar
    ./org.eclipse.jetty/jetty-io/jars/jetty-io-7.6.0.v20120127.jar
    ./org.eclipse.jetty/jetty-security/jars/jetty-security-7.6.0.v20120127.jar
    ./org.eclipse.jetty/jetty-server/jars/jetty-server-7.6.0.v20120127.jar
    ./org.eclipse.jetty/jetty-servlet/jars/jetty-servlet-7.6.0.v20120127.jar
    ./org.eclipse.jetty/jetty-webapp/jars/jetty-webapp-7.6.0.v20120127.jar
    ./org.eclipse.jetty/jetty-util/jars/jetty-util-7.6.0.v20120127.jar
    ./org.eclipse.jetty/jetty-xml/jars/jetty-xml-7.6.0.v20120127.jar

Version 8.1.5 of these packages is in Fedora 18.

## knockoff

    ./com.tristanhunt/knockoff_2.9.1/jars/knockoff_2.9.1-0.8.0-16.jar

Scala Markdown processor (not in Fedora).
