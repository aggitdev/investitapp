echo "Installing Roo Flex Annotations library for project"
mvn install:install-file -Dfile=.\roo-library-to-put-there\org.springframework.flex.roo.annotations-1.0.0.BUILD-SNAPSHOT.jar -DgroupId=org.springframework.flex.roo.addon -DartifactId=org.springframework.flex.roo.annotations -Dversion=1.0.0.BUILD-SNAPSHOT -Dpackaging=jar
echo "Installing BlazeDS 4.0 libraries for project"
echo "TODO"
pause
