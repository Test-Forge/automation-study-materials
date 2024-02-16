package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class MyStepDefinitions {

    WebDriver driver;

    public MyStepDefinitions() {
        driver = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
    }

    @Given("User is on Home page")
    public void userIsOnHomePage() {
        driver.manage().window().maximize();
        driver.get("https://www.selenium.dev/documentation/webdriver/");
    }

    @When("User navigates to {string}")
    public void userNavigatesTo(String arg0) {
        WebElement btnBrowsers = driver.findElement(By.id("m-documentationwebdriverbrowsers"));
        btnBrowsers.click();
    }

    @Then("Supported Browsers list is displayed")
    public void supportedBrowsersListIsDisplayed() {
        String currentPage = driver.getCurrentUrl();
        Assert.assertEquals("https://www.selenium.dev/documentation/webdriver/browsers/", currentPage);
        System.out.println("Page title: " + driver.getTitle());

        driver.quit();
    }
}