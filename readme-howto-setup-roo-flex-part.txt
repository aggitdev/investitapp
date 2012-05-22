* install flashbuilder into eclipse as a plugin (some webref how to do this...)

* it all start with roo (version  1.1.5) and mvn (version 3)

- note for Springsource STS IDE roo is in springsource28\spring-roo-1.1.5.RELEASE
- note for Springsource STS IDE roo is in springsource28\apache-maven-3.0.3
- note maven settings for STS was configured to be the settings.xml in C:\Documents and Settings\agroebbe\.m2

* installed flex addon for roo 1.0.0 (@ 2011-11-14)
   -- org.springframework.flex.roo.addon-1.0.0.BUILD-SNAPSHOT.jar in the OSGI bundle directory of roo (e.g. C:\roo\bundle)
      and clean the roo 'cache' directory
  -- fetch this from source using git (spring-flex-roo.git project) and install using maven to obtain the jar

* also install the flex addon for roo annotation library in maven so that this project has this dependency OK
  -- org.springframework.flex.roo.addon:org.springframework.flex.roo.annotations:jar:1.0.0.BUILD-SNAPSHOT

* note the project used script 'script.roo' (see below) and then developped further

* add to the roo generated .pom file the follwoing:
1) this helped a compile error:

<!-- http://java.dzone.com/news/roo-flex-add-alive -->
<repository>
  <id>spring-snapshot</id>
  <name>Spring Portfolio Snapshot Repository</name>
  <url>http://maven.springframework.org/snapshot</url>
  <releases>
    <enabled>false</enabled>
  </releases>
  <snapshots>
    <enabled>true</enabled>
  </snapshots>
</repository>
        


2) tomcat maven port:
                <artifactId>tomcat-maven-plugin</artifactId>
		...                
                <!-- AG: changed port (2011-11-14) -->
		<configuration>
			<port>8282</port>
		</configuration>      

* then to deploy:
- mvn clean
- mvn tomcat:run 
  --> note port will be 8282
- browser --> http://localhost:8282/rootunes/rootunes_scaffold.html
(rootunes_scaffold is the name of the html page & swf module that was generated)
(the server uses Java, JPA, Spring Flex Remoting (BlazeDS))


* OR for running it in Eclipse: install a tomcat server (e.g. also on port 8282) in eclipse
(new server & properties server -> bio-http-port 8282)
- import project into eclipse & maven update dependencies
(note will need to do pluginmanagement: ignore flexmojos compiler plugin --> quick fix on that problems will include pluginmanagement in .pom)
- add flex & actionscript natures ??
- deploy app to server
- you can then run the project on the server --> will deploy to the server
- run at "http://localhost:8282/rootunes/rootunes_scaffold.html" (note: /rootunes and / do not work here)
(note run as web app does not work, due to flashbuilder config not 100%, due to maven generated project config)


The Application
================
- note: install the 3rd party .jars in maven: see .bat file

- note: script here used is app-script.roo
- note: database is investitdb (hsql file db)
-- in database.properties we have set: 
     database.url=jdbc\:hsqldb\:file\:C:\\investitdb\\investitdb;shutdown\=true
-- so create that c:\investitdb directory
- note: in resources/META-INF/persistence.xml is the JPA config of HSQL & hibernate:
            <property name="hibernate.hbm2ddl.auto" value="create"/> -->  value="create" to build a new database on each run; 


Note: the application is on git:
for info see: http://help.github.com/win-set-up-git/
URL: https://github.com/aggitdev/investitapp




--------------------------


general roo flex testing scrip (can run using the 'script' command at roo)
======================================================

project --topLevelPackage org.example.rootunes
persistence setup --provider HIBERNATE --database H2_IN_MEMORY 
flex setup
entity --class ~.domain.Artist
field string --fieldName name --notNull
entity --class ~.domain.Album
field string --fieldName title --notNull 
field number --fieldName numberOfTracks --type java.lang.Integer --notNull --min 1
field date --fieldName releaseDate --type java.util.Date --notNull
field reference --fieldName artist --type ~.domain.Artist
flex remoting all --package ~.service
entity --class ~.domain.Song
field string --fieldName title --notNull 
field boolean --fieldName explicitLyrics
field number --fieldName runningLength --type java.lang.Float
flex remoting scaffold --name ~.service.SongService
field reference --fieldName album --type ~.domain.Album




