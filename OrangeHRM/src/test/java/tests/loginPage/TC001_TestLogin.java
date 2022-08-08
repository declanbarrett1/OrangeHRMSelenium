package tests.loginPage;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import testbase.TestBase;
import utilities.ScreenShotting;

public class TC001_TestLogin {
	
	//Defining global variables used in class
	WebDriver driver;
	LoginPage loginPage;
	HomePage homePage;
	Logger logger;
	String className = this.getClass().getSimpleName();

	// Setting up test -> Creating page objects and creating driver with correct URL as seen in testBase
	// Then typing in the username and password and logging in
	@BeforeTest
	public void setupTest(){

		driver = TestBase.setup();
		logger = TestBase.getLogger();
		logger.info("Starting test: " + className);
		loginPage = new LoginPage(driver);
		loginPage.typeUsername("Admin");
		loginPage.typePassword("admin123");
		loginPage.clickLoginButton();
		TestBase.sleep(2000);
		homePage = new HomePage(driver);
	}
	
	@Test
	public void testingLogin() {
		Boolean testPass = false;
		String title = driver.getTitle();
		Assert.assertEquals(title, "OrangeHRM");
		if(title.equals("OrangeHRM")) {
			logger.info("URL Title is correct");
		}
		else {
			logger.info("URL Title is incorrect");
		}
		homePage.checkingForLoginTest();
		if(homePage.checkingExistance.isDisplayed()) {
			testPass = true;
			logger.info("Element is Displayed");
		}
		else {
			logger.info("Element is not displayed");
		}
		Assert.assertEquals(true, testPass);
		
		ScreenShotting.takeSnapShot(driver, className);
		
	}
	
	@AfterTest
	public void teardown() {
		driver.close();
		logger.info("Finishing Test: " + className);
	}
	
}
