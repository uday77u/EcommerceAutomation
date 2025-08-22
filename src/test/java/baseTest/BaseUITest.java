package baseTest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import utilities.ConfigReader;
import utilities.DriverFactory;

public abstract class BaseUITest implements FrameWorkConstant{

    protected WebDriver driver;
    protected Logger logger;

    @BeforeClass
    @Parameters({"browser"})
    public void setUp(@Optional("chrome") String browser) {
        // Load config file
        ConfigReader.loadProperties("config.properties");
        logger = LogManager.getLogger(this.getClass());

        // Init driver
        DriverFactory.initDriver(browser);
        driver = DriverFactory.getDriver();

        // Navigate to base URL
        String baseUrl = ConfigReader.getProperty("uiBaseUrl");
        logger.info("🌐 Launching [{}] and navigating to: {}", browser, baseUrl);
        driver.get(baseUrl);
        
    }

    @AfterClass
    public void tearDown() {
        DriverFactory.quitDriver();
        logger.info("🛑 Browser closed successfully");
    }
}
