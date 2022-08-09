package tests.loginPage;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.ForgottenPasswordPage;
import pages.LoginPage;
import testbase.TestBase;
import utilities.ScreenShotting;

public class TC002_ForgottenPasswordTest {

	WebDriver driver;
	LoginPage loginPage;
	ForgottenPasswordPage forgottenPasswordPage;
	String className = this.getClass().getSimpleName();
	Logger logger;
	
	@BeforeTest
	public void testSetup() {
		driver = TestBase.setup();
		logger = TestBase.getLogger();
		logger.info("Starting Test: " + className);
		loginPage = new LoginPage(driver);
		forgottenPasswordPage = new ForgottenPasswordPage(driver);
		loginPage.forgottonPasswordLink();
		TestBase.sleep(4000);
		
	}
	
	@Test
	public void testingForgottenPassword() {
		boolean correctUrl = forgottenPasswordPage.checkURL(logger);
		if(correctUrl) {
			forgottenPasswordPage.inputUsernameField("dec");
			forgottenPasswordPage.resetPasswordButton();
			ScreenShotting.takeSnapShot(driver, className);
			TestBase.sleep(4000);
			forgottenPasswordPage.cancelResetPassword();
			TestBase.sleep(3000);
			Assert.assertEquals("https://opensource-demo.orangehrmlive.com/index.php/auth/login", driver.getCurrentUrl());
			if(driver.getCurrentUrl().equals("https://opensource-demo.orangehrmlive.com/index.php/auth/login")) {
				logger.info("Cancelled the password reset and redirected to login page");
			}
			else {
				logger.info("Error in execution, couldnt cancel password reset");
			}
		}
		else {
			logger.info("Password Link Not clicked correctly, test failed");
			Assert.assertEquals("https://opensource-demo.orangehrmlive.com/index.php/auth/requestPasswordResetCode",driver.getCurrentUrl());
			
		}
	}
	@AfterTest
	public void tearDown() {
		driver.quit();
		logger.info("Ending Test: " +className);
	}
}
