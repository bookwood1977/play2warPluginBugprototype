import sbt._
import Keys._
import play.Project._
import com.github.play2war.plugin._


// 
// Information zum Hinzufügen oder Ändern von Paketen in appDependencies:
// ----------------------------------------------------------------------
// Die Paketinformationen stammen von Maven. Man kann sie wie folgt suchen:
// "Maven + benötigter Klassenname". Z.B. auf www.mvnrepository.com
// 


object ApplicationBuild extends Build {

    val appName         = "bugdemo"
    val appVersion      = "0.9.9.9"

    val appDependencies = Seq(
      // Add your project dependencies here
      javaCore, 
      javaJdbc, 
      jdbc, 
      javaJpa, 
      filters,
      "postgresql" % "postgresql" % "8.4-702.jdbc4" withSources,
      "org.hibernate" % "hibernate-entitymanager" % "4.3.6.Final" withSources,
      "be.objectify" %% "deadbolt-java" % "2.2.1-RC2" withSources,
      "org.apache.httpcomponents" % "httpclient" % "4.3.5" withSources,
      "org.apache.httpcomponents" % "httpmime" % "4.3.5" withSources,
      "org.apache.httpcomponents" % "httpcore" % "4.3.2" withSources,
      "org.apache.poi" % "poi" % "3.10.1" withSources,
      "org.apache.poi" % "poi-ooxml" % "3.10.1" withSources,
      "commons-lang" % "commons-lang" % "2.5" withSources,
      "com.lowagie" % "itext" % "4.2.1" withSources,
      "net.sf.jasperreports" % "jasperreports" % "5.5.1" withSources,
      "net.sf.jxls" % "jxls-core" % "1.0.5" withSources,
      "net.sf.jxls" % "jxls-reader" % "1.0.5" withSources,
      "junit" % "junit" % "4.11",
      "com.fasterxml.jackson.core" % "jackson-core" % "2.4.3",
      "com.fasterxml.jackson.core" % "jackson-databind" % "2.4.3",
      "com.fasterxml.jackson.core" % "jackson-annotations" % "2.4.3"
    )

	val projectSettings = Play2WarPlugin.play2WarSettings ++ Seq(
	  Play2WarKeys.servletVersion := "3.0"  	// für Tomcat 7: "3.0", für Tomcat6: "2.5"
	)

    val main = play.Project(appName, appVersion, appDependencies).settings(
      // resolvers:
      resolvers += Resolver.url("Objectify Play Repository", url("http://schaloner.github.com/releases/"))(Resolver.ivyStylePatterns),
	  resolvers += Resolver.url("Objectify Play Snapshot Repository", url("http://schaloner.github.com/snapshots/"))(Resolver.ivyStylePatterns),
      
      // Add your own project settings here   
      ebeanEnabled := false,
      Keys.fork in (Test) := false
    ).settings(projectSettings: _*)

}
