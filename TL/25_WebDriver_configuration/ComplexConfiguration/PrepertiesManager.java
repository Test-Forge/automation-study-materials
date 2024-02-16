package utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesManager {
    private static final Logger logger = LogManager.getLogger(PropertiesManager.class);
    public static String browser;
    public static String homeUrl;
    public static String registerUrl;
    public static String overviewUrl;
    public static String baseUrl;
    private static Properties properties = new Properties();

    public PropertiesManager() {
        try (FileInputStream input = new FileInputStream("src/main/resources/config.properties")) {
            properties.load(input);

            browser = properties.getProperty("browser");
            homeUrl = properties.getProperty("homeUrl");
            registerUrl = properties.getProperty("registerUrl");
            overviewUrl = properties.getProperty("overviewUrl");
            baseUrl = properties.getProperty("baseUrl");

        } catch (IOException e) {
            logger.error("Error loading properties file: " + e.getMessage());
        }
    }

    public static String getBrowser() {
        if (browser == null) {
            new PropertiesManager();
            logger.info("browser retrieved");
        }
        return browser;
    }

    public static void setBrowser(String browser) {
        PropertiesManager.browser = browser;
    }

}
