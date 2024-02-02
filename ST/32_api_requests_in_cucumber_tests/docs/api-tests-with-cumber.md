# API Tests with Cucumber BDD Framework
## Table of Contents
1. [ Overview](#1-overview)
2. [ Technology and frameworks](#2-technology-and-frameworks)
3. [ Framework setup](#3-framework-setup)
4. [ Framework structure](#4-framework-structure)
5. [API testing](#5-api-testing)

### 1. Overview
This document is a guide to testing APIs services using the Java [Cucumber](cucumber.md) with REST Assured Maven Test Automation Framework.
You will learn how to utilize the power of Java and Maven as a build tool, along with the simplicity of Cucumber, to
create a flexible and reliable testing framework.
The document covers key features of the framework, such as test context management.
You will also learn about the implementation of the BDD methodology, using REST-Assured for API testing.

### 2. Technology and frameworks
1. **Cucumber**
    <details>
   Cucumber is a testing tool that uses a behavior-driven development (BDD) approach.
   It allows for easy collaboration between business stakeholders, developers, and testers by providing a common language that everyone can understand. 
   Cucumber enables the creation of executable specifications which are written in plain English and can serve as living documentation.
    </details>
2. **REST Assured**
   <details>
   The REST-Assured library provides a powerful and flexible API testing library that is used to make HTTP requests and verify the responses.
   We use the RequestSpecification class of rest assured for a one-time setup of the content headers, and other common items used while making a new request.
   </details>
3. **JUnit**
    <details>
    A JUnit Runner is any class that extends the main “Runner” class of JUnit4 – an abstract JUnit class that is responsible for running our JUnit tests.
    The “Cucumber JUnit Runner (Cucumber)” is one of such custom extension subclasses of the “Runner” class and is created to modify the default JUnit test execution process for Cucumber. 
    It notifies JUnit of its progress while running the executable specifications (once per run). This “Cucumber JUnit Runner (Cucumber)” which is used to run these executable specifications can be set using the JUnit “@RunWith” annotation in any class </details>
    </details>

**Conclusion - Key Features**
The Java Cucumber Maven Test Automation Framework offers several key features that enhance the efficiency and effectiveness of API testing. 
The framework maintains the test context between steps, ensuring seamless sharing of test data. It leverages REST-Assured for API testing, providing a flexible and powerful API testing library.
Additionally, the framework generates clear and concise Cucumber reports for test results, making it easy for stakeholders to understand the outcomes. The implementation of the BDD methodology reduce boilerplate code and improve code maintainability.
### 3. Framework setup
To begin using the Test Automation Framework for REST API testing, follow the steps outlined below:
* Add Cucumber Dependencies to the Project
* Write a test in a Feature File
* Create a Test Runner
* Write test code to Step file
* Run test as JUnit test & Maven Command Line
* View Test Results
The Step-by-step instruction [Framework setup](<framework_setup>)

### 4. Framework structure:
The framework is structured into several key components:
1. Service under test **'src/main/java/org/apitests'**
   This directory contains various important elements of the framework, including:
  - **Abstract classes:** These classes serve as the foundation for other classes within the framework and provide reusable methods and functionalities.
  - **Test context:** Test context is a crucial aspect of any Cucumber framework. It allows the sharing of test data between different steps in a thread-safe manner. In this framework, the TestContext enum is implemented using the Enum-based singleton pattern.
      It enables sharing payload, request, and response objects among different Cucumber BDD steps.
  -  **Utilities:** Utility classes contain common helper methods that assist in performing tasks such as data manipulation, logging, and error handling.
  -  **Models**: Models represent the data structures used within the framework, including JSON objects, request/response bodies, and data transfer objects.
  -  **Constants**: Constants store commonly used values or configurations that are required across multiple parts of the framework.
  -  **Config reader:** The config reader class enables reading and loading configuration files, such as property files or YAML files, to provide dynamic test configurations.
2. API testing framework **'src/test/java/org/apitests'**
   This directory contains the step definitions and test runners required for test execution and reporting. Step definitions correspond to the Gherkin steps defined in the feature files and contain the actual implementation of the test logic. 
3. Cucumber JUnit runner  [example](framework_setup.md)
  * Test runners orchestrate the execution of feature files and bind them to the corresponding step definitions.
4. The readme files with detailed descriptions **'src/docs'** [example](framework_setup.md)
  * A README file is a text file that describes and launches a project. It comprises information that is frequently needed to grasp the scope of the project.
5.  Resources  **'src/test/resources'** 
  * This directory holds the feature files and test data required for test execution. Feature files are written in Gherkin syntax and define the behavior or scenarios to be tested.  
   Test data, such as sample payloads or data sets, can be stored here for reference or data-driven testing.
6. The pom.xml file is the Maven Project Object Model (POM) file. **'src/pom.xml'**
  * It contains the project configuration, dependencies, and build settings required for building, running, and managing the project. Here, you can define the required dependencies for the framework, such as Cucumber, REST-assured, logging libraries, or any other necessary libraries or plugins.

Overall, the framework structure ensures a clear separation of concerns, promotes reusable and maintainable code, and allows for efficient collaboration among team members working on the test automation project.
By following this structure, testers and developers can easily understand and enhance the framework to support API testing with Java, Cucumber, REST-assured and Maven.

### 5. API testing
**Introduction**
> API testing is a crucial aspect of software testing, especially in the context of web applications.
It involves sending requests to an application programming interface (API) and validating the responses received.
API testing using the REST-Assured library is essential for making robust and reliable HTTP requests and verifying the responses.
The RequestSpecification class of rest assured simplifies the setup process and improves efficiency in creating new requests.

**REST-Assured Library Overview**
> REST-Assured is a Java-based library that simplifies API testing by allowing developers to easily make HTTP requests and verify the responses.
It provides a simple and intuitive syntax that makes writing API tests straightforward and efficient. With REST-Assured, you can test RESTful APIs using various HTTP methods such as GET, POST, PUT, and DELETE.

**Setting Up Request Specifications**
> Before making API requests, it is common to set up certain specifications or headers that are required for each request.
REST-Assured uses the RequestSpecification class to define these specifications. By utilizing the RequestSpecification class, we can avoid repetitive code and ensure consistency in our API tests.
The RequestSpecification class allows us to set up headers, cookies, query parameters, and other common items used while making requests. This one-time setup ensures that the same specifications apply to all API requests made throughout the test.
>  [Steps with Rest-Assured example.](../example/Steps.java)
> 
**Making API Requests**
> Once the request specifications are set up, we can utilize REST-Assured to send API requests.
REST-Assured provides numerous methods for different HTTP request types. For example:

* **get()** - sends an HTTP GET request to the API
* **post()** - sends an HTTP POST request to the API
* **put()** - sends an HTTP PUT request to the API
* **delete()** - sends an HTTP DELETE request to the API
> We can specify the request URL, headers, query parameters, and request body (if applicable) while making API requests.
Additionally, we can chain methods to further customize the API requests and validate the responses received.

**Validating API Response**
> After sending an API request, it is essential to validate the response received from the API.
REST-Assured provides various methods to assert and verify the response details. Some commonly used methods for response validation include:

* **statusCode()** - verifies the HTTP status code of the response
* **body()** - validates the response body against specific criteria
* **header()** - checks the values of specific headers in the response
* **responseTime()** - ensures that the response is received within a specified time frame
 >By utilizing these methods and other available options, we can validate the correctness and integrity of the API responses received during testing.



