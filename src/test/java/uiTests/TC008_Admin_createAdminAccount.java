package uiTests;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import baseTest.BaseUITest;
import pageObjects.HomePage;
import pageObjects.SignInPage;
import pageObjects.SignUpPage;

public class TC008_Admin_createAdminAccount extends BaseUITest {
	@Test	
	public void testAdmin_createAdminAccount() {
		try {
			
			HomePage homePage=new HomePage(driver);
			SignInPage signInPage=new SignInPage(driver);
			SignUpPage signUpPage=new SignUpPage(driver);
			
			//logger.info(null);
			logger.info("start logging ***testAdmin_createAdminAccount***");
			
			logger.info("Step 1: Clicking on the 'Login' button in HomePage");
			homePage.clickLoginBtn();
			
			logger.info("Step 2: Verify signin Page is displayed");
			assertTrue(signInPage.isAtSignInPage(), "Unable to navigate SignIn Page");
			
			logger.info("Step 3: Clicking on the 'Admin Login'");
			signInPage.clickAdminLoginBtn();
			
			logger.info("Step 4: Click on 'Create Account' button. ");
			signInPage.clickCreateAccountBtn();
			
			logger.info(" Verifying signup Page is displayed");
			assertTrue(signInPage.isAtSignUpPage(), "Unable to navigate Signup Page.");
			
			logger.info("Step 5: Enter 'First Name' and 'Last Name' fields.");
			signUpPage.enterFirstNameTxtFld("myFirstName");
			signUpPage.enterLastNameTxtFld("myLastName");
			
			logger.info("Step 6: Click on the 'Male' radio button");
			signUpPage.clickMaleRadioBtn();
			
			logger.info("Step 7: Enter 'Phone Number' and 'Email Address' fields");
			signUpPage.enterPhoneNumberTxtFld("7896541230"); 
			signUpPage.enterEmailAddressTxtFld(AdminEmail);
			
			logger.info("Step 8: Enter 'Password' and 'Confirm Password' fields");
			signUpPage.enterpasswordTxtFld(AdminPassword);
			signUpPage.enterConfirmPasswordTxtFld(AdminPassword);
			
			logger.info("Step 9: Select 'Country' 'State' and 'City' in dropdowns");
			signUpPage.selectCountryDropDown("India");
			signUpPage.selectStateDropDown("Punjab");
			signUpPage.selectCityDropDown("Amritsar");
			
			logger.info("Step 10: Click on 'Register' button");
			signUpPage.clickRegisterBtn();
			
			logger.info("Step 11: Verify the User Name");
			 // ✅ Now check toast using @FindBy
		    assertTrue(signInPage.isErrorMessageContaining("Register"),
		            "❌ Error message containing 'wrong' was not displayed.");

		    assertTrue(signInPage.isErrorMessageEquals("Successfull Register"),
		            "❌ Exact error message did not match.");	
		    
			
		}catch (AssertionError ae) {
			logger.error("❌ Assertion failed in testAdmin_createAdminAccount: " + ae.getMessage(), ae);
	        throw ae; // rethrow so TestNG marks test as failed
		}
		catch (Exception e) {
			logger.error("❌ Unexpected exception in testAdmin_createAdminAccount: " + e.getMessage(), e);
	        throw e; // rethrow so TestNG marks test as failed
		}
	}
}
