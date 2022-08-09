package tests.homePage.navigationbar;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import testbase.SetupForAllTests;
import testbase.TestBase;
import utilities.ScreenShotting;

public class TC001_AdminChecking {
    WebDriver driver;
    HomePage homePage;
    String className = this.getClass().getSimpleName();
    Logger logger;

    @BeforeTest
    public void setupTest(){
        driver = TestBase.setup();
        logger = TestBase.getLogger();
        homePage = new HomePage(driver);
        SetupForAllTests.loginSetup(driver);
        logger.info("Starting Test: " + className);
        homePage.clickingAdminLink();
    }

    @Test
    public void testingAdminLink(){
        ScreenShotting.takeSnapShot(driver, className);
        String url = driver.getCurrentUrl();
        if(url.equals("https://opensource-demo.orangehrmlive.com/index.php/admin/viewSystemUsers")){
            logger.info("Test Passed - On correct URL");
        }
        else{
            logger.info("Test Failed - Admin Link not correct or URL has changed");
        }
        Assert.assertEquals("https://opensource-demo.orangehrmlive.com/index.php/admin/viewSystemUsers", url);
    }

    @AfterTest
    public void teardown(){
        driver.quit();
        logger.info("Finishing Test: " + className);
    }
}
