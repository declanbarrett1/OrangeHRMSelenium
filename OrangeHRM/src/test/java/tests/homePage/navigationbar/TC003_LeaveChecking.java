package tests.homePage.navigationbar;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.HomePage;
import testbase.SetupForAllTests;
import testbase.TestBase;
import utilities.ScreenShotting;

public class TC003_LeaveChecking {
    WebDriver driver;
    Logger logger;
    HomePage homePage;
    String className = this.getClass().getSimpleName();
    @BeforeTest
    public void setupTest(){
        driver = TestBase.setup();
        logger = TestBase.getLogger();
        homePage = new HomePage(driver);
        SetupForAllTests.loginSetup(driver);
        logger.info("Starting Test: " + className);
        homePage.clickingLeaveLink();
    }

    @Test
    public void testingAdminLink(){
        ScreenShotting.takeSnapShot(driver, className);
        String url = driver.getCurrentUrl();
        if(url.equals("https://opensource-demo.orangehrmlive.com/index.php/leave/viewLeaveList")){
            logger.info("Test Passed - On correct URL");
        }
        else{
            logger.info("Test Failed - PIM Link not correct or URL has changed");
        }
        Assert.assertEquals("https://opensource-demo.orangehrmlive.com/index.php/leave/viewLeaveList", url);
    }

    @AfterTest
    public void teardown(){
        driver.quit();
        logger.info("Finishing Test: " + className);
    }
}

