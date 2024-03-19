package hooks;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import enums.Context;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import scenario_context.ScenarioContext;

public class Hooks {
    WebDriver driver;
    ScenarioContext scenarioContext = ScenarioContext.getInstance();

    @Before
    public void startBrowser() {
        System.setProperty("webdriver.gecko.driver", pathToFirefoxDriver);
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        scenarioContext.setContext(Context.WEB_DRIVER, driver);
    }

    @After
    public void closeBrowser() {
        driver = (WebDriver) scenarioContext.getContext(Context.WEB_DRIVER);
        driver.close();
    }
}