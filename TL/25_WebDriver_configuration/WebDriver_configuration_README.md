# Selenium WebDriver

by Igor Chele
2024
***

## Contents

1. [What is Selenium WebDriver](#what-is-selenium-webdriver)
2. [Dependencies](#dependencies)
3. [Download Driver/s](#download-drivers)
4. [Basic configuration for a test](#basic-configuration-for-a-test)
5. [WebDriver methods](#webdriver-basic-commands)
6. [Conclusions](#conclusions)

---

## What is Selenium WebDriver

Selenium WebDriver is a powerful tool for automating web browsers. It provides a programming interface (API) for
interacting with web browsers and automating
web application testing. WebDriver allows you to write code in various programming
languages (such as **Java**, Python, C#, etc.) to control web browsers programmatically
and perform actions like clicking buttons, filling forms, navigating through pages,
and verifying web page contents.

WebDriver supports multiple web browsers such as Chrome,
Firefox, Safari, and Edge, allowing you to write tests that run
seamlessly across different browsers.

Integration with Testing Frameworks: WebDriver can be integrated with popular testing
frameworks like **Cucumber**, **JUnit** and TestNG, enabling the creation of structured and maintainable
test suites.

Support for Parallel Execution: WebDriver supports parallel test execution, allowing you
to run tests concurrently across multiple browsers or browser instances, thus reducing
test execution time. This is a more complex solution which is used with WebDriver Factory or WebDriver Manager.


***

## Dependencies

In order to run it , first we need to install Selenium library (add dependency to pom.xml file)
from [here](https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java) , otherwise, see an example below.

```xml

<dependency>
    <groupId>org.seleniumhq.selenium</groupId>
    <artifactId>selenium-java</artifactId>
    <version>4.13.0</version>
    <scope>test</scope>
</dependency>

```

***

## Download driver(s)

Next is to download the corresponding driver for our browser, here are some links:

[driver for Chrome - chromedriver](https://chromedriver.chromium.org/)

[driver for Firefox - geckodriver](https://github.com/mozilla/geckodriver)

[driver for Edge - msedgedriver](https://developer.microsoft.com/en-us/microsoft-edge/tools/webdriver/?form=MA13LH)

[driver for Opera - operadriver](https://github.com/operasoftware/operachromiumdriver/releases)

After unpacking , make sure to save the driver in the "resources" directory of the ATF.

***

### Basic configuration for a test

To open a URL link the most basic requirements are:

```java
package hackerRank;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicTest {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();

        driver.get("https://selenium.dev/documentation/");

        driver.quit();
    }
}
```

See attached a simple example "BasicConfiguration"(separately in JUnit and Cucumber) of a test with some additional
commands specific for WebDriver.

***

### WebDriver basic commands

#### Here are some examples you might use

- **driver.get(string arg0)** - this method _load_ a new web page in current browser window.
- **driver.navigate().to(string arg0)** - same operation as previous
- **driver.navigate().forward()** - same operation of a _forward button_ of any browser
- **driver.navigate().back()** - same as _back button_
- **driver.navigate().refresh()** - refresh the current page


- **driver.close()** - _close_ only the current browser window
- **driver.quit()** - _closes_ all browser windows and the driver itself
- **driver.manage().windows().maximized()** - maximize browser window
- **driver.getTitle()** - gets the title of the page, if available
- **driver.getCurrentUrl()** - gets the URL
- **driver.switchTo().newWindow(WindowType.TAB)** - opens a new tab and switches to it
- **driver.switchTo().newWindow(WindowType.WINDOW)** - opens a new browser window and switches to it

#### Some outdated commands

- **driver.wait()** - better use awaitility for wait operations
- **driver.findElement()** - POM (Page Object Model) recommended, but might have a special case to be used

```java
public class NavigationTest {

    @Test
    public void navigationTest() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.selenium.dev/documentation/webdriver/");
        driver.manage().window().maximize();

        WebElement btnBrowsers = driver.findElement(By.id("m-documentationwebdriverbrowsers"));
        btnBrowsers.click();

        String currentPage = driver.getCurrentUrl();
        Assert.assertEquals("https://www.selenium.dev/documentation/webdriver/browsers/", currentPage);

        driver.quit();
    }
}
```

___

## Conclusions

WebDriver can have a much more complex configuration to cover the needs of ATF tests execution.
There are various methods of configurations, but most recommended are to use Singleton pattern for browser initiation
and
to ensure that unused browser sessions to be closed.

See also attached an example of WebDriver configuration via WebDriverFactory with browser selection.(:It wasn't me!:)

N.B: Web Elements interaction is part of other chapter.