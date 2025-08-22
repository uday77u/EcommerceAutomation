package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utilities.WaitUtils;

public class SignInPage extends BasePage {

    public SignInPage(WebDriver driver) {
        super(driver);
    }
    //---------------------Web elements------------------------------------------
    @FindBy(xpath = "//button[contains(text(),'Shopper Login')]")
    private WebElement shopperLogin;

    @FindBy(xpath = "//button[contains(text(),'Merchant Login')]")
    private WebElement merchantLogin;

    @FindBy(xpath = "//button[contains(text(),'Admin Login')]")
    private WebElement adminLogin;

    @FindBy(xpath = "//span[text()='Login']")
    private WebElement loginBtn;

    @FindBy(xpath = "//span[text()='Create Account']")
    private WebElement createAccountBtn;

    @FindBy(xpath = "//a[text()='Forgot Password?']")
    private WebElement forgotPasswordLink;

    @FindBy(css = "#Email")
    private WebElement EmailTxtFld;
    
    @FindBy(css = "#Password")
    private WebElement PasswordTxtFld;
    
    @FindBy(xpath = "//span[text()='Create Account']")
    private WebElement CreateAccountBtn;
    
    
    
    
    
    
    
 // --- Toast / Error message ---
    @FindBy(xpath = "//div[contains(@class,'Toastify')]")
    private WebElement toastMessage;
    


    // Page checks
    public boolean isAtSignInPage() {
        return driver.getCurrentUrl().contains("signin");
    }

    public boolean isShopperLoginDisplayed() {
        return isDisplayed(shopperLogin, 10);
    }

    public boolean isAtSignUpPage() {
        return driver.getCurrentUrl().contains("signup");
    }
    public boolean isMerchantLoginDisplayed() {
        return isDisplayed(merchantLogin, 10);
    }

    public boolean isAdminLoginDisplayed() {
        return isDisplayed(adminLogin, 10);
    }

    public boolean isLoginBtnEnable() {
        return isEnabled(loginBtn, 10);
    }

    public boolean isCreateAccountBtnEnable() {
        return isEnabled(createAccountBtn, 10);
    }

    public boolean isForgotPasswordLinkEnable() {
        return isEnabled(forgotPasswordLink, 10);
    }
    
    public boolean isMessageSegmentExist(WebDriver driver,String messageSegment) {
		return driver.getPageSource().contains(messageSegment);
}

    // Actions
    public void clickMerchantLoginBtn() {
        click(merchantLogin, 10);
    }

    public void clickAdminLoginBtn() {
        click(adminLogin, 10);
    }
  
    public void clickLoginBtn() {
        click(loginBtn, 10);
    }
    
    public void enterEmailTxtFld(String email) {
    	EmailTxtFld.clear();
    	EmailTxtFld.sendKeys(email);
	}
    
    public void enterPasswordTxtFld(String password) {
    	PasswordTxtFld.clear();
    	PasswordTxtFld.sendKeys(password);
	}
    
    public void clickCreateAccountBtn() {
        click(CreateAccountBtn, 10);
    }
    
    
    
    
    
    
    
    
    // ✅ Error message check (contains)
    public boolean isErrorMessageContaining(String expectedText) {
        String msg = WaitUtils.waitForElementVisible(driver, toastMessage, 10).getText();
        return msg.contains(expectedText);
    }

    // ✅ Error message check (exact)
    public boolean isErrorMessageEquals(String expectedText) {
        String msg = WaitUtils.waitForElementVisible(driver, toastMessage, 10).getText();
        return msg.equals(expectedText);
    }
    
    
    
}
