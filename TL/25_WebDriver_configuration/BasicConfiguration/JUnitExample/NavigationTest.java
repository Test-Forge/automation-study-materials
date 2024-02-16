import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigationTest {

    @Test
    public void navigationTest(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.selenium.dev/documentation/webdriver/");
        driver.manage().window().maximize();

        WebElement btnBrowsers = driver.findElement(By.id("m-documentationwebdriverbrowsers"));
        btnBrowsers.click();

        String currentPage = driver.getCurrentUrl();
        Assert.assertEquals("https://www.selenium.dev/documentation/webdriver/browsers/", currentPage);

        System.out.println("Page title: " + driver.getTitle());

        driver.quit();
    }
}
