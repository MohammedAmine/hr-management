#hr-management#

##Technologies Stack##

 - Java EE 6
 - JPA 2.1
 - H2
 - CDI
 - EJB 3.2
 - JAX-RS
 - Red Hat JBoss EAP 7.0
 - Maven (Red Had Jboss Developer Studio Integration)


##Star JBoss Server##

1. Open a command line and navigate to the root of the JBoss server directory.

```bash
JBOSS_HOME\bin> standalone.bat
```

You can start JBoss server directly from JBoss Developer Studio or Eclipse.

##Build & Deploy##

1. Clone the projet

```bash
...\anywhere> git clone https://github.com/MohammedAmine/hr-management.git
```

2. Type this command to build and deploy the archive into a running server instance.

```bash
 ...\anywhere\hr-management> mvn clean package jboss-as:deploy
 ```

This will deploy target/hr-management.war to the running instance of the JBoss server.
Now you can see the application running at http://localhost:8080/hr-management.

##Help##

If you need the full installation instructions for Java Runtime Environment, Red Had JBoss Server and Maven, please visit this repository : https://github.com/MohammedAmine/helloworld-rs
