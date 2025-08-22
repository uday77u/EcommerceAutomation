package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class SignUpPage extends BasePage {

	public SignUpPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	//--------------------Locators--------------------------------
	@FindBy(xpath = "//input[@id='First Name']") 
	private WebElement FirstNameTxtFld;
	
	@FindBy(xpath = "//input[@id='Last Name']") 
	private WebElement LastNameTxtFld;
	
	@FindBy(xpath = "//input[@id='Male']") 
	private WebElement MaleRadioBtn;
	
	@FindBy(xpath = "//input[@id='Phone Number']") 
	private WebElement PhoneNumberTxtFld;
	
	@FindBy(xpath = "//input[@id='Email Address']") 
	private WebElement EmailAddressTxtFld;
	
	@FindBy(xpath = "//input[@type='password']") 
	private WebElement passwordTxtFld;
	
	@FindBy(xpath = "//input[@id='Confirm Password' and @name='Confirm Password']") 
	private WebElement ConfirmPasswordTxtFld;
	
	@FindBy(xpath = "//input[@id='Terms and Conditions']") 
	private WebElement TermsAndConditionsCheckbox;
	
	@FindBy(xpath = "//select[@id='Country']")
	private WebElement CountryDropDown;
	
	@FindBy(xpath = "//select[@id='State']")
	private WebElement StateDropDown;
	
	@FindBy(xpath = "//select[@id='City']")
	private WebElement CityDropDown;
	
	@FindBy(xpath = "//button[text()='Register']") 
	private WebElement RegisterBtn;
	

	
	
	//--------------------Actions-------------------------------
	public void enterFirstNameTxtFld(String name) {
		FirstNameTxtFld.sendKeys(name);
	}
	
	public void enterLastNameTxtFld(String name) {
		LastNameTxtFld.sendKeys(name);
	}
	
	public void clickMaleRadioBtn() {
		MaleRadioBtn.click();
	}
	
	public void enterPhoneNumberTxtFld(String number) {
		PhoneNumberTxtFld.sendKeys(number);
	}
	
	public void enterEmailAddressTxtFld(String email) {
		EmailAddressTxtFld.sendKeys(email);
	}
	
	public void enterpasswordTxtFld(String password) {
		passwordTxtFld.sendKeys(password);
	}
	
	public void enterConfirmPasswordTxtFld(String password) {
		ConfirmPasswordTxtFld.sendKeys(password);
	}
	
	public void selectCountryDropDown(String Country) {
		Select sel=new Select(CountryDropDown);
		sel.selectByContainsVisibleText(Country);
	}
	
	public void selectStateDropDown(String State) {
		Select sel=new Select(StateDropDown);
		sel.selectByContainsVisibleText(State);
	}
	
	public void selectCityDropDown(String City) {
		Select sel=new Select(CityDropDown);
		sel.selectByContainsVisibleText(City);
	}
	
	public void clickRegisterBtn() {
		RegisterBtn.click();
	}
}
