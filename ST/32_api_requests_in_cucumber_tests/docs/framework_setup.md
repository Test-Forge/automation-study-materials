# Framework setup

## Prerequisites: 
1. Java Setup
2. IDE Setup
3. Maven Setup
4. Create a maven java project

In the result you will have  basic project with the following pom file :
```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
   <modelVersion>4.0.0</modelVersion>

   <groupId>org.apitest</groupId>
   <artifactId>33_api_requests_in_cucumber_tests</artifactId>
   <version>1.0-SNAPSHOT</version>

   <properties>
      <maven.compiler.source>21</maven.compiler.source>
      <maven.compiler.target>21</maven.compiler.target>
      <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
   </properties>
   </poject>
```
## Setup RestAssured API Tests using the Cucumber BDD Style Test
### Step 1: Add Cucumber Dependencies to the Project
Firstly, include the following dependency in your project to execute tests in Cucumber:
* cucumber-java
* cucumber-jvm-deps
* cucumber-JUnit

As we are developing the framework in Maven, add the following dependencies into the project POM XML.

First add the dependency tag within the dependencies tag, like below.
```xml
<dependencies>
   <dependency>*You Project Dependency*</dependency>
</dependencies>
```
To add the required dependencies, go to [Maven Repository](https://mvnrepository.com/).

**cucumber-java**: The location of the dependency details is at the [Maven Repository](https://mvnrepository.com/artifact/io.cucumber/cucumber-junit).
```xml 
<dependencies>
<dependency>
    <groupId>io.cucumber</groupId>
    <artifactId>cucumber-java</artifactId>
    <version>7.14.0</version>
</dependency>
</dependencies>
```
Note: As of Jan’2024, the latest stable cucumber-java version is 7.145.0.

**cucumber-jvm-deps**: The location of the dependency details is at the [Maven Repository](https://mvnrepository.com/artifact/io.cucumber/cucumber-jvm-deps)
```xml
<dependency>
    <groupId>io.cucumber</groupId>
    <artifactId>cucumber-jvm-deps</artifactId>
    <version>1.0.6</version>
    <scope>provided</scope>
</dependency>
```
**Note**: As of Jan’2024, the latest cucumber-jvm-deps version is 1.0.6

**cucumber-junit**: The location of the dependency details is at the [Maven Repository](https://mvnrepository.com/artifact/io.cucumber/cucumber-junit)
```xml
<dependency>
    <groupId>io.cucumber</groupId>
    <artifactId>cucumber-junit</artifactId>
    <version>7.14.0</version>
    <scope>test</scope>
</dependency>
```
Note: As of Jan’2024, the latest stable cucumber-junit version is 7.14.0

### Step 2: Add Rest Assured dependency to the Project
We will add Rest Assured Dependencies to our project through the pom.xml file.
To add the required dependencies, go to Rest Assured Maven Repository.
**rest-assured**: The location of the dependency details is at the [Maven Repository](https://mvnrepository.com/artifact/io.rest-assured/rest-assured)

```xml
<dependency>
    <groupId>io.rest-assured</groupId>
    <artifactId>rest-assured</artifactId>
    <version>5.4.0</version>
    <scope>test</scope>
</dependency>
```
Note: As of Jan’2024, the latest stable cucumber-junit version is 5.4.0

### Step 3: Add JUnit dependency to the Project
We will add JUnit dependency to our project through the pom.xml file.
To add the required dependencies, go to Rest Assured Maven Repository.
**rest-assured**: The location of the dependency details is at the [Maven Repository](https://mvnrepository.com/artifact/io.rest-assured/rest-assured)

```xml
  <dependency>
    <groupId>io.cucumber</groupId>
    <artifactId>cucumber-junit</artifactId>
    <version>5.4.0</version>
    <scope>test</scope>
</dependency>
```
Note: As of Jan’2024, the latest stable cucumber-junit version is 5.4.0
### Step 4: Add Apache Maven Compiler Plugin to the Project
The Compiler Plugin is used to compile the sources of your project.
We will add **maven-compiler-pluin**: The location of the dependency details is at the [Maven Repository](https://mvnrepository.com/artifact/org.apache.maven.plugins/maven-compiler-plugin)

```xml
<build>
   <plugins>
      <plugin>
         <groupId>org.apache.maven.plugins</groupId>
         <artifactId>maven-compiler-plugin</artifactId>
         <version>3.7.0</version>
         <configuration>
            <source>1.8</source>
            <target>1.8</target>
            <encoding>UTF-8</encoding>
         </configuration>
      </plugin>
   </plugins>
</build>
```
  