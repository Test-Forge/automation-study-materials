import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginPage {

    private WebDriver driver;

    private static final String EMAIL_INPUT_XPATH = "//input[@id='email']";
    private static final String PASSWORD_INPUT_XPATH = "//input[@type='password']";
    private static final String LOGIN_BUTTON_XPATH = "//input[contains(@class, 'my-form__button')]";
    private static final String RESET_PASSWORD_LINK_XPATH = "//a[@title='Reset Password']";

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterEmail(String email) {
        WebElement emailInput = driver.findElement(By.xpath(EMAIL_INPUT_XPATH));
        emailInput.sendKeys(email);
    }

    public void enterPassword(String password) {
        WebElement passwordInput = driver.findElement(By.xpath(PASSWORD_INPUT_XPATH));
        passwordInput.sendKeys(password);
    }

    public void clickLoginButton() {
        WebElement loginButton = driver.findElement(By.xpath(LOGIN_BUTTON_XPATH));
        loginButton.click();
    }

    public void clickResetPasswordLink() {
        WebElement ResetPasswordLink = driver.findElement(By.xpath(RESET_PASSWORD_LINK_XPATH));
        resetPasswordLink.click();
    }


    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");

        WebDriver driver = new ChromeDriver();

        driver.get("https://librarius.md/ro/login");

        LoginPage loginPage = new LoginPage(driver);

        loginPage.enterEmail("your_email");
        loginPage.enterPassword("your_password");
        loginPage.clickLoginButton();

        loginPage.clickResetPasswordLink();

        driver.quit();
    }
}
