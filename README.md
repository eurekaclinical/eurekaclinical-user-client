# Eureka! Clinical User Client
[Atlanta Clinical and Translational Science Institute (ACTSI)](http://www.actsi.org), [Emory University](http://www.emory.edu), Atlanta, GA

## What does it do?
It is a library for accessing eurekaclinical-user-service RESTful APIs from Java applications. It provides two REST API clients for managing user profile information for deployments of Eureka! Clinical that use its built-in authentication and user profile microservices:
* EurekaClinicalUserClient.java: for web clients to manage user profile information via the eurekaclinical-user-webapp proxy.
* EurekaClinicalUserProxyClient.java: for Java applications to manage user profile information directly using eurekaclinical-user-service.

## Version 1.0 development series
Latest release: [![Latest release](https://maven-badges.herokuapp.com/maven-central/org.eurekaclinical/eurekaclinical-user-client/badge.svg)](https://maven-badges.herokuapp.com/maven-central/org.eurekaclinical/eurekaclinical-user-client)

## Version history
No final releases yet

## Build requirements
* [Oracle Java JDK 8](http://www.oracle.com/technetwork/java/javase/overview/index.html)
* [Maven 3.2.5 or greater](https://maven.apache.org)

## Runtime requirements
* [Oracle Java JRE 8](http://www.oracle.com/technetwork/java/javase/overview/index.html)
* [Tomcat 7](https://tomcat.apache.org)

## Building it
The project uses the maven build tool. Typically, you build it by invoking `mvn clean install` at the command line. For simple file changes, not additions or deletions, you can usually use `mvn install`. See https://github.com/eurekaclinical/dev-wiki/wiki/Building-Eureka!-Clinical-projects for more details.

## Maven dependency
```
<dependency>
    <groupId>org.eurekaclinical</groupId>
    <artifactId>eurekaclinical-user-client</artifactId>
    <version>version</version>
</dependency>
```

## Developer documentation
* [Javadoc for latest development release](http://javadoc.io/doc/org.eurekaclinical/eurekaclinical-user-client) [![Javadocs](http://javadoc.io/badge/org.eurekaclinical/eurekaclinical-user-client.svg)](http://javadoc.io/doc/org.eurekaclinical/eurekaclinical-user-client)

## Getting help
Feel free to contact us at help@eurekaclinical.org.

