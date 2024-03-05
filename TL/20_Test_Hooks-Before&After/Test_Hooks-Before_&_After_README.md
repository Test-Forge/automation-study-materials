# Test Hooks. Before & After

by Igor Chele
2024

***

## Contents

1. [HOOKS - General info](#hooks)
2. [Examples](#examples)
3. [Conclusions](#conclusions)

## HOOKS

In Cucumber for Java, hooks are blocks of code that run before or after scenarios,
allowing you to set up and tear down the test environment, perform setup and cleanup tasks,
and handle scenarios at various stages of execution. Hooks provide a way to execute common
code across multiple scenarios, improving code re-usability and maintainability. Although Hooks can
be written in step definition file, more common practice is to have them in a separate class.

Cucumber Java supports several types of hooks, including:

1. Before Hooks: These hooks run before each scenario and are typically used to set up the
   test environment or perform preconditions necessary for the scenario to execute.
   For example, you might use a before hook to open a web browser, initialize test data,
   or authenticate users. Tags can be used to separate conditions required for special tests.
   Also, several @Before can be present with different methods - in this case an order number is used
   and hooks are executed according that order number in *ascending* order >> order 1, order 2,order 3...


2. After Hooks: These hooks run after each scenario and are used to clean up the test environment
   or perform post-execution tasks. After hooks are commonly used to close resources, log results,
   or capture screenshots after the scenario has completed. In case of multiple @After with specified order number
   the execution is according order number in *descending* order >> ... order 3, order 2, order 1.


3. BeforeStep and AfterStep Hooks: These hooks run before and after each step within a scenario,
   allowing you to execute setup and cleanup tasks at a finer granularity. They are useful for
   scenarios where you need to perform actions before or after each step, such as logging step
   execution or taking screenshots.


4. Around Hooks: Cucumber Java also supports around hooks, which wrap the execution of each
   scenario and allow you to perform custom actions before and after scenario execution.
   Around hooks are more flexible than before and after hooks because they can control the entire
   scenario execution flow.


5. BeforeAll and AfterAll hooks are used for same purposes as Before and After in case there is a separation of
   preconditions required for specific tests divided by some tags (as : UI, API, Regression, Production,
   Sanity and others), still some general preconditions are required in order to start any test pack.

### Examples

For better understanding, lets visualize some examples:

- simple hooks configuration as a separate class. If Hooks are implemented in a separate class it is
  recommended to use same package as for step definitions, either to insert the path in the runner class.

```java
package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Hooks {
    public static WebDriver driver;

    @Before
    public void launchBrowser() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @After
    public void tearDown() {
        driver.close();
        driver.quit();
    }
}
```

- TestRunner class with "hooks" package in glue (path to Hooks class)

```java
package runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"stepDefinitions", "hooks"},
        monochrome = true,
        plugin = {"pretty"}
)

public class TestRunner {
}
```

***

Let's analyze a more complex example of the Hooks class:

- In this case we have a specific separation of UI and API tests with tags "@UI"/"@API"
- BeforeAll and AfterAll hooks are used for both test types.
- AfterStep hook is used to save a screenshot for a detailed UI test evidence
- Every hook has some information logged, recommended to add scenario name to Before hook.

```java
package stepDefinitions;

import api.Authorization;
import io.cucumber.java.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import utils.ScenarioContext;
import utils.WebDriverFactory;

public class Hooks {
    private static final Logger logger = LogManager.getLogger(Hooks.class);

    @BeforeAll
    public static void launchTests() {
        ScenarioContext.getScenarioInstance().clearContext();
        logger.info("Test/s started");
    }

    @Before("@API")
    public static void setUpAPI(Scenario scenario) {
        logger.info(System.lineSeparator() + "Starting API test: " + scenario.getName());
        Authorization.authorization();
    }

    @Before("@UI")
    public static void launchBrowser(Scenario scenario) {
        logger.info(System.lineSeparator() + "Starting UI test: " + scenario.getName());
        WebDriverFactory.getWebDriver();
        WebDriverFactory.openNewBrowser();
    }

    @After("@UI")
    public static void afterScenario(Scenario scenario) {
        WebDriverFactory.takeScreenshot(scenario);
        WebDriverFactory.closeBrowserWindow();
        logger.info("Scenario " + scenario.getName() + " finished");
    }

    @AfterStep("@UI")
    public static void detailedTestEvidence(Scenario scenario) {
        WebDriverFactory.takeScreenshot(scenario);
        logger.info("Test evidence saved as screenshot");
    }

    @AfterAll
    public static void closeTests() {
        WebDriverFactory.tearDown();
        ScenarioContext.getScenarioInstance().clearContext();
        logger.info("Test/s finished");
    }
}
```

EXPLANATION:

- @BeforeAll hook is used for cleaning any saved values from previous runs
- @Before("@API") has a specific method for authentication (to extract the token which is requested for POST/GET
  requests later)
- @Before("@UI") has method which gets the browser type, opens it and maximize it, additional can be added other
  method which opens a new browser tab/window
- @After("@UI") has 2 methods : one to take and save a screenshot of test evidence and other to close the browser window
- @AfterStep - makes a screenshot of every-step
- @AfterAll - includes a method which close all browser windows(webDriver also) and other that clears all temporary
  saved data in Scenario Context

***

### Conclusions

Hooks helps us prepare specific conditions for testing, especially useful in complex projects with several test
environments (Production, UAT, Dev, PreProd), UI/API tests, several specific test packs (like Regression, Sanity, Smoke,
other)

Here's what our "friend" ChatGPT think about using Hooks:

Hooks in Cucumber are incredibly useful for various reasons:

*Code Re-usability*: Hooks allow you to define setup and teardown actions once and apply them to multiple scenarios.
This promotes code re-usability and reduces duplication of code.

*Consistent Setup*: Hooks ensure that each scenario starts with a consistent setup. This is important for maintaining
the integrity of the tests and ensuring they run reliably.

*Resource Management*: Hooks help manage resources such as database connections, browser sessions, or test data
initialization. They ensure that resources are properly initialized before tests run and cleaned up afterward.

*Logging and Reporting*: Hooks can be used to log important information or capture screenshots before and after each
scenario. This aids in debugging and troubleshooting test failures.

*Test Environment Configuration*: Hooks can set up the test environment before executing scenarios. This includes
tasks such as starting servers, deploying applications, or configuring test-specific settings.

*Test Data Preparation*: Hooks can be used to prepare test data before scenarios execute. This ensures that scenarios
have the necessary data to execute successfully.

*Cleanup Activities*: Hooks are valuable for performing cleanup activities after scenarios execute. This includes tasks
such as closing browser windows, deleting temporary files, or releasing resources.