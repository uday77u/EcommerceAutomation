package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;

public class DriverFactory {
    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    // ✅ Get WebDriver instance (thread-safe)
    public static WebDriver getDriver() {
        return driver.get();
    }

    // ✅ Initialize driver based on param or config
    public static void initDriver(String browser) {
        if (browser == null || browser.isEmpty()) {
            // fallback: get from config, default = chrome
            browser = ConfigReader.getProperty("browser", "chrome");
        }

        WebDriver webDriver;
        switch (browser.toLowerCase()) {
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                webDriver = new FirefoxDriver();
                break;

            case "edge":
                WebDriverManager.edgedriver().setup();
                webDriver = new EdgeDriver();
                break;

            case "chrome":
            default:
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();

                if (Boolean.parseBoolean(ConfigReader.getProperty("headless", "false"))) {
                    options.addArguments("--headless", "--disable-gpu");
                }
                if (Boolean.parseBoolean(ConfigReader.getProperty("incognito", "false"))) {
                    options.addArguments("--incognito");
                }
                options.addArguments("--start-maximized");

                webDriver = new ChromeDriver(options);
                break;
        }

        // ✅ Apply implicit wait
        int implicitWait = Integer.parseInt(ConfigReader.getProperty("implicitWait", "0"));
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitWait));

        driver.set(webDriver);
    }

    // ✅ Quit and cleanup
    public static void quitDriver() {
        if (getDriver() != null) {
            getDriver().quit();
            driver.remove();
        }
    }
}
