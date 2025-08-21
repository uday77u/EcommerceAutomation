package uiTests;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import baseTest.BaseUITest;
import pageObjects.HomePage;
import pageObjects.SignInPage;
import utilities.VerifyPage;
import utilities.WaitUtils;

public class TC001_All_SmokeUITest extends BaseUITest {

	@Test
	public void shouldVerifyLoginPageElementsForAllUserTypes() {
	    HomePage homePage = new HomePage(driver);
	    SignInPage signInPage = new SignInPage(driver);

	    logger.info("*** Starting Admin Login Smoke Test ***");

	    logger.info("Step 1: Click on Login button");
	    homePage.clickLoginBtn();

	    logger.info("Step 2: Verify navigation to Login Page");
	    assertTrue(signInPage.isAtSignInPage(), "Unable to navigate to Login Page");

	    logger.info("Step 3: Verify Shopper, Merchant, and Admin login options are present");
	    SoftAssert softAssert = new SoftAssert();
	    softAssert.assertTrue(signInPage.isShopperLoginDisplayed(), "Shopper Login is missing");
	    softAssert.assertTrue(signInPage.isMerchantLoginDisplayed(), "Merchant Login is missing");
	    softAssert.assertTrue(signInPage.isAdminLoginDisplayed(), "Admin Login is missing");

	    logger.info("Step 4: Verify login page buttons and links are enabled");
	    softAssert.assertTrue(signInPage.isLoginBtnEnable(), "Login button is not enabled");
	    softAssert.assertTrue(signInPage.isCreateAccountBtnEnable(), "Create Account button is not enabled");
	    softAssert.assertTrue(signInPage.isForgotPasswordLinkEnable(), "Forgot password link is not enabled");

	    softAssert.assertAll();
	}


}
