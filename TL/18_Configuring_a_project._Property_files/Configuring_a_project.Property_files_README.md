# Configuring a project. Property files

---

## Contents

1. [Property file - Do we need it?](#property-file---do-we-need-it)
2. [.properties](#properties-type-file)
3. [.yml/.yaml](#ymlyaml-type-file)
4. [.json](#json-type-file)
5. [Property file readers](#property-file-readers)

---

## Property file - Do we need it?

Property file provide a convenient way to externalize configuration data from your application code, making it easier
to manage and modify settings without needing to recompile or redeploy your application.

While in simple projects this is recommended, the more complex project gets, the more difficult it is to manage
changes, so it becomes mandatory. That's the main reason to implement it at the start of the project and just add more
properties
as the project grows.

In a properties file, you typically store configuration data in the form of key-value pairs. The data stored in a
properties file can vary based on the specific requirements of your application, but it commonly includes configuration
settings such as:

- *Connection Setting*: Properties files are often used to store connection settings for databases, servers, APIs, etc.
  This includes information such as database URLs, usernames, passwords, server hostnames, ports, etc.

- *Application Settings*: Configuration options related to the behavior or appearance of the application, such as
  language
  settings, theme settings, logging levels, etc.

- *Environment-specific Settings*: Properties files may contain environment-specific settings, allowing you to configure
  different behavior for development, testing, staging, and production environments.

- *Third-party Integrations*: Settings related to third-party services or integrations, such as API keys, authentication
  tokens, endpoints, etc.

- *Feature Flags*: Properties files can be used to manage feature flags or toggles, controlling the availability of
  certain features within the application.

- *Resource Locations*: Paths or URLs to resources used by the application, such as file paths, URLs for images, CSS
  files, JavaScript files, etc.

- *Localization*: Properties files are commonly used for localization and internationalization purposes, storing
  translated messages, labels, and other text resources for different languages.

- *System Properties*: Properties related to system configuration, such as system paths, system settings, etc.

- *Custom Configuration*: Any custom configuration options specific to your application's requirements can also be
  stored
  in properties files

***

### Most common types are : .properties, .yml/.yaml and . json

## .properties type file

*.properties* files use a simple key-value pair format where each line represents a property with the format key=value.
They are usually plain text files with ASCII encoding.
Here's a simple example of a .properties type file which has basic data such as : browser used, Url's, login data for
UI/API
tests, DB connection settings.

```properties
homeUrl=https://parabank.parasoft.com/parabank/index.htm
registerUrl=https://parabank.parasoft.com/parabank/register.htm
overviewUrl=https://parabank.parasoft.com/parabank/overview.htm
browser=firefox
implicitWait=5
# Valid Login form
parabankUsername=v.pupkin
parabankPassword=vpupkin
# Invalid Login form
parabankWrongUsername=wrong
parabankWrongPassword=failed
# API Login Data
baseUrl=https://thinking-tester-contact-list.herokuapp.com
email=ichele.test@gmail.com
password=M@rius1981
# MySQL DB properties
jdbc.driver=com.mysql.jdbc.Driver
jdbc.url=jdbc:mysql://localhost:3306/MyDbName
jdbc.username=root
jdbc.password=admin1
```

***

## .yml/.yaml type file

*.yaml* files support more complex data structures and provide better readability for hierarchical configurations. They
can represent nested configurations and are often used for more advanced configuration needs.

In order to use a .yaml file type you need additional dependencies in pom.xml file, as:

- [snakeyaml](https://mvnrepository.com/artifact/org.yaml/snakeyaml)
- [Jackson Dataformat](https://mvnrepository.com/artifact/com.fasterxml.jackson.dataformat/jackson-dataformat-yaml)

OR

- [Spring Boot Starter](https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter)

Here's a part of a more complex yaml properties file example (beneficence of the nested configuration)

```yaml

customer:
  email: some_mail@mail.com
  password: No0ne@me
shippingAddress:
  firstName: Johanna
  lastName: Gilmore
  addressLine1: 251 Road Street
  addressLine2: Imperial Heights
  city: New York
  zipCode: '15015'
  country: United States
  state: New York
  isdCode: '+1'
  phoneNumber: '5524188596'
  deliveryOptionType: STANDARD
  searchAddrCode: 12
paymentOptions:
  creditCards:
    VISA:
      cardNumber: '1422 6852 41552 9852'
      expiryMonth: 03
      expiryYear: 28
      cvv: 844
      nameOnCard: Gilmore Johanna
    AMEX:
      cardNumber: '8500 2256 4125 65233'
      expiryMonth: 05
      expiryYear: 26
      cvv: 390
      nameOnCard: Gilmore Johanna

```

***

## .json type file

*.json* file type also is a readable format, for human and machine, which is used also in other programming languages.
It can store arrays or lists into a complex, yet scalable data structure.

Major difference is that JSON does not support comments.

For better visibility , here's a real part of a properties file (all sensitive data was deleted):

```json
{
  "Web": {
    "Browser": "Chrome",
    "Headless": false,
    "UrlWeb": "",
    "WaitSeconds": 20,
    "VariableTimeout": 2
  },
  "UserAccounts": {
    "SupplierAdmin": {
      "UserName": "",
      "Password": "Testing123!"
    },
    "SupplierUser": {
      "UserName": "",
      "Password": "Testing123!"
    },
    "SupplierReadOnly": {
      "UserName": "",
      "Password": "Testing123!"
    },
    "BuyerAdmin": {
      "UserName": "",
      "Password": "Testing123!c"
    },
    "BuyerUser": {
      "UserName": "",
      "Password": "Testing123!c"
    },
    "BuyerReadOnly": {
      "UserName": "",
      "Password": "Testing123!c"
    }
  }
}

```

## Property file readers

In Java, there are several ways to read properties from property files. Some common types of property file readers
include:

1. *Properties Class*: Java's built-in Properties class can be used to read properties from a .properties file.
   You can load properties from a file using methods like load(InputStream) or load(Reader).

2. *ResourceBundle Class*: The ResourceBundle class can also be used to read properties from a .properties file.
   It provides a way to access locale-specific resources in a flexible way.

3. *FileReader Class*: You can use the FileReader class along with other input stream classes like BufferedReader
   to read properties from a file.

4. *Scanner Class*: The Scanner class can be used to parse input from various sources, including files.
   You can use it to read properties from a file line by line.

5. *Apache Commons Configuration*: Apache Commons Configuration library provides a powerful and flexible way
   to read and write configuration data from various sources, including properties files.

6. *Spring's PropertySource*: If you are using the Spring framework, you can use the @PropertySource annotation
   along with Environment to read properties from property files.

***

### Properties Class load() method

```java
package utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesManager {
    private static final Logger logger = LogManager.getLogger(PropertiesManager.class);
    private static String browser;
    public static String homeUrl;
    public static String registerUrl;
    public static String overviewUrl;
    public static String baseUrl;
    private static Properties properties = new Properties();

    private PropertiesManager() {
        try (FileInputStream input = new FileInputStream("src/main/resources/config.properties")) {
            properties.load(input);

            browser = properties.getProperty("browser");
            homeUrl = properties.getProperty("homeUrl");
            registerUrl = properties.getProperty("registerUrl");
            overviewUrl = properties.getProperty("overviewUrl");
            baseUrl = properties.getProperty("baseUrl");

        } catch (IOException e) {
            logger.error("Error loading properties file: " + e.getMessage());
        }
    }

    public static String getBrowserType() {
        if (browser == null) {
            new PropertiesManager();
            logger.info("browser retrieved");
        }
        return browser;
    }

    public static void setBrowserType(String browser) {
        PropertiesManager.browser = browser;
    }

}
```