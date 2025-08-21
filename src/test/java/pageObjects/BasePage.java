package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utilities.WaitUtils;

public class BasePage {

    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this); // initialize @FindBy elements
    }

    // --- Wait Wrappers ---
    protected WebElement waitForElementVisible(WebElement element, int timeout) {
        WaitUtils.waitForElementVisible(driver, element, timeout);
        return element;
    }

    protected WebElement waitForElementClickable(WebElement element, int timeout) {
        WaitUtils.waitForElementClickable(driver, element, timeout);
        return element;
    }

    // --- Common Actions ---
    protected void click(WebElement element, int timeout) {
        waitForElementClickable(element, timeout).click();
    }

    protected String getText(WebElement element, int timeout) {
        return waitForElementVisible(element, timeout).getText();
    }

    protected boolean isDisplayed(WebElement element, int timeout) {
        try {
            return waitForElementVisible(element, timeout).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    protected boolean isEnabled(WebElement element, int timeout) {
        try {
            return waitForElementVisible(element, timeout).isEnabled();
        } catch (Exception e) {
            return false;
        }
    }
}
