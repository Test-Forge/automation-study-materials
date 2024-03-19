package page_objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    private WebDriver driver;

    @FindBy(id = "login-button")
    private WebElement loginButton;

    @FindBy(id = "user-name")
    private WebElement usenameInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterUsername(String username) {
        usenameInput.sendKeys(username);
    }

    public void enterPassword(String pwd) {
        passwordInput.sendKeys(pwd);
    }

    public void clickLogin() {
        loginButton.click();
    }
}
