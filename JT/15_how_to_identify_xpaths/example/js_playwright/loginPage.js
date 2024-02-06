/*
Playwright encourages the use of more robust selectors like text, id, name, etc., and typically doesn't promote the use of XPath
as a best practice. However, for cases where other selectors may not be sufficient, Playwright does provide support for XPath selectors.
*/

const { chromium } = require('playwright');

(async () => {
    // Launch a new browser instance
    const browser = await chromium.launch();

    // Create a new browser context
    const context = await browser.newContext();

    // Create a new page within the context
    const page = await context.newPage();

    // Navigate to the login page
    await page.goto('https://example.com/login');

    // Example 1: Login with text selectors
    await page.type('input[name="username"]', 'your_username');
    await page.type('input[name="password"]', 'your_password');
    await page.click('button[type="submit"]');

    // Example 2: Failed login with text selectors
    await page.fill('input[name="username"]', 'invalid_username');
    await page.fill('input[name="password"]', 'invalid_password');
    await page.click('button[type="submit"]');

    // Example 3: Clicking the "Forgot Password" link with XPath
    await page.click('//a[text()="Forgot Password"]');

    // Example 4: Validate placeholder text with text selector
    const usernamePlaceholder = await page.getAttribute('input[name="username"]', 'placeholder');
    const passwordPlaceholder = await page.getAttribute('input[name="password"]', 'placeholder');
    console.log(`Username Placeholder: ${usernamePlaceholder}`);
    console.log(`Password Placeholder: ${passwordPlaceholder}`);

    // Close the browser
    await browser.close();
})();

/*
In this example:
   - Playwright text selectors like input[name="username"], input[name="password"], and button[type="submit"] are used for
     interacting with the login page elements.
   - XPath is used sparingly, for example, when clicking the "Forgot Password" link.
   - The use of Playwright's built-in selectors enhances readability and maintains a clear structure for the test.
*/