/*
Groovy is the default scripting language supported by Katalon Studio. It's a dynamic language for the Java Virtual Machine (JVM)
that integrates smoothly with Java and is well-suited for scripting in the context of test automation.
 */

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

// Open the browser and navigate to the login page
WebUI.openBrowser('')

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

// Example 3: Clicking the "Forgot Password" link
WebUI.click(findTestObject('LoginPage/ForgotPasswordLink'))
WebUI.waitForUrl('https://example.com/forgot-password', 10)

// Example 4: Validate placeholder text
def usernamePlaceholder = WebUI.getAttribute(findTestObject('LoginPage/UsernameInput'), 'placeholder')
def passwordPlaceholder = WebUI.getAttribute(findTestObject('LoginPage/PasswordInput'), 'placeholder')
println("Username Placeholder: ${usernamePlaceholder}")
println("Password Placeholder: ${passwordPlaceholder}")

// Close the browser
WebUI.closeBrowser()
