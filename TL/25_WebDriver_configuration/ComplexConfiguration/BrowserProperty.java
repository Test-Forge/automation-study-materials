package utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

public class BrowserProperty {
    private static final Logger logger = LogManager.getLogger(BrowserProperty.class);
    private static WebDriver webDriver;
    private static String browser = PropertiesManager.getBrowser();


    public static WebDriver getBrowserProperty() {
        switch (browser) {
            case "chrome" -> {
                webDriver = new ChromeDriver();
            }
            case "firefox" -> {
                webDriver = new FirefoxDriver();
            }
            case "opera" -> {
                webDriver = new OperaDriver();
            }
            case "edge" -> {
                webDriver = new EdgeDriver();
            }
            default -> throw new IllegalArgumentException("Browser is not specified. Please set the browser.");
        }

        logger.info("Current browser is " + browser);

        return webDriver;
    }

    public static void setBrowserProperty() {
        browser = PropertiesManager.getBrowser();
    }
}
