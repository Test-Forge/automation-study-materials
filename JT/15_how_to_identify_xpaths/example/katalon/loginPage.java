/*
Please note that Katalon Studio primarily uses Groovy for scripting. While it does support Java for certain purposes,
Groovy is the recommended scripting language.
 */

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

public class LoginPageTest {

    @Keyword
    public void loginTests() {
        WebUI.openBrowser('')

        // Navigate to the login page
        WebUI.navigateToUrl('https://example.com/login')

        // Example 1: Successful Login with good credentials
        WebUI.setText(findTestObject('LoginPage/UsernameInput'), 'valid_username')
        WebUI.setText(findTestObject('LoginPage/PasswordInput'), 'valid_password')
        WebUI.click(findTestObject('LoginPage/LoginButton'))
        WebUI.waitForUrl('https://example.com/dashboard', 10)

        // Example 2: Failed Login with invalid credentials
        WebUI.setText(findTestObject('LoginPage/UsernameInput'), 'invalid_username')
        WebUI.setText(findTestObject('LoginPage/PasswordInput'), 'invalid_password')
        WebUI.click(findTestObject('LoginPage/LoginButton'))
        WebUI.verifyElementVisible(findTestObject('LoginPage/ErrorMessage'), 10)

        // Example 3: Clicking the "Forgot Password" link with XPath
        WebUI.click(findTestObject('xpath=//a[text()="Forgot Password"]'))
        WebUI.waitForUrl('https://example.com/forgot-password', 10)

        // Example 4: Validate placeholder text with text selector
        String usernamePlaceholder = WebUI.getAttribute(findTestObject('LoginPage/UsernameInput'), 'placeholder')
        String passwordPlaceholder = WebUI.getAttribute(findTestObject('LoginPage/PasswordInput'), 'placeholder')
        System.out.println("Username Placeholder: " + usernamePlaceholder)
        System.out.println("Password Placeholder: " + passwordPlaceholder)

        WebUI.closeBrowser()
    }
}