package uiTests;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import baseTest.BaseUITest;
import pageObjects.HomePage;
import pageObjects.SignInPage;

public class TC007_Shopper_LoginWithActualCredentials extends BaseUITest{

	@Test
	public void testShopper_LoginWithActualCredentials() {
		try {
			
		HomePage homePage=new HomePage(driver);
		SignInPage signInPage=new SignInPage(driver);
		
		//logger.info(null);
		logger.info("start logging ***testShopper_LoginWithActualCredentials***");
		
		logger.info("Step 1: Clicking on the 'Login' button in HomePage");
		homePage.clickLoginBtn();
		
		logger.info("Step 2: Verify signin Page is displayed");
		assertTrue(signInPage.isAtSignInPage(), "Unable to navigate SignIn Page");
		
		logger.info("Step 3: Clicking on the 'Admin Login'");
		signInPage.clickAdminLoginBtn();
		
		logger.info("Step 4: Enter Email field");
		signInPage.enterEmailTxtFld("asdf@gmail");
		
		logger.info("Step 5: Enter Password field");
		signInPage.enterPasswordTxtFld("WrongPassword");
		
		logger.info("Step 6: Click on the 'Login' button");
		signInPage.clickLoginBtn();
		
		logger.info("Step 7: Verify the User Name");
		 // ✅ Now check toast using @FindBy
	    assertTrue(signInPage.isErrorMessageContaining("wrong"),
	            "❌ Error message containing 'wrong' was not displayed.");

	    assertTrue(signInPage.isErrorMessageEquals("Given user ID or password is wrong"),
	            "❌ Exact error message did not match.");	
	}
	catch (AssertionError ae) {
        logger.error("❌ Assertion failed in testShopper_LoginWithActualCredentials: " + ae.getMessage(), ae);
        throw ae; // rethrow so TestNG marks test as failed
    } catch (Exception e) {
        logger.error("❌ Unexpected exception in testShopper_LoginWithActualCredentials: " + e.getMessage(), e);
        throw e; // rethrow so TestNG marks test as failed
    }
}
}
