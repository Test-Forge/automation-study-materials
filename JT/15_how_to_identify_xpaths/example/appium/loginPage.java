/*
Automating a mobile app, so it will use Appium's AndroidDriver.
 */

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class AppiumXPathExamples {

    private static AndroidDriver<AndroidElement> driver;

    private static final String LOGIN_BUTTON_XPATH = "//android.widget.Button[@text='Login']";
    private static final String USERNAME_INPUT_XPATH = "//android.widget.EditText[@resource-id='username']";
    private static final String SETTINGS_MENU_XPATH = "//android.widget.ImageView[@content-desc='Settings']";
    private static final String NOTIFICATION_TITLE_XPATH = "//android.widget.TextView[contains(@text, 'Notification')]";

    public static void main(String[] args) throws MalformedURLException {
        // Set the Appium server URL
        URL appiumServerURL = new URL("http://127.0.0.1:4723/wd/hub");

        // Set the desired capabilities
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9.0");
        capabilities.setCapability(MobileCapabilityType.UDID, "your_device_udid");
        capabilities.setCapability(MobileCapabilityType.APP, "path/to/your/app.apk");

        // Initialize the AndroidDriver
        driver = new AndroidDriver<>(appiumServerURL, capabilities);

        // Instantiate the AppiumXPathExamples class
        AppiumXPathExamples xpathExamples = new AppiumXPathExamples();

        //Locating a button by text
        xpathExamples.clickLoginButton();

        //Locating an input field by resource-id
        xpathExamples.enterUsername("your_username");

        //Locating an image view by content-description
        xpathExamples.openSettingsMenu();

        //Locating a text view by partial text
        xpathExamples.verifyNotificationTitle();

        driver.quit();
    }

    public void clickLoginButton() {
        driver.findElement(MobileBy.xpath(LOGIN_BUTTON_XPATH)).click();
    }

    public void enterUsername(String username) {
        driver.findElement(MobileBy.xpath(USERNAME_INPUT_XPATH)).sendKeys(username);
    }

    public void openSettingsMenu() {
        driver.findElement(MobileBy.xpath(SETTINGS_MENU_XPATH)).click();
    }

    public void verifyNotificationTitle() {
        String title = driver.findElement(MobileBy.xpath(NOTIFICATION_TITLE_XPATH)).getText();
        System.out.println("Notification Title: " + title);
    }
}