package utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class WebDriverFactory {
    private static final Logger logger = LogManager.getLogger(WebDriverFactory.class);
    private static WebDriver webDriver;

    private WebDriverFactory() {
        try {
            webDriver = BrowserProperty.getBrowserProperty();
            webDriver.manage().window().maximize();
            logger.info("Browser launched maximized");
        } catch (Exception e) {
            logger.error("Error initializing WebDriver: " + e.getMessage());
            throw new RuntimeException("Error initializing WebDriver", e);
        }
    }

    public static WebDriver getWebDriver() {
        if (webDriver == null) {
            new WebDriverFactory();
            logger.info("new WebDriver");
        }
        return webDriver;
    }

    public static void closeBrowser() {
        webDriver.close();
        logger.info("Browser closed");
    }

    public static void tearDown() {
        if (webDriver != null) {
            webDriver.quit();
            webDriver = null;
            logger.info("Driver quit");
        }
    }
}
