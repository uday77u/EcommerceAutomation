package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(id = "loginBtn")
    private WebElement loginBtn;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void clickLoginBtn() {
        click(loginBtn, 15);
    }
}
