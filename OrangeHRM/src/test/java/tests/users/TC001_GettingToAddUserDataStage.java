package tests.users;

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

public class TC001_GettingToAddUserDataStage {

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
        homePage.addingUser();
    }

    @Test
    public void testingAdminLink(){
        ScreenShotting.takeSnapShot(driver, className);
        String url = driver.getCurrentUrl();
        if(url.equals("https://opensource-demo.orangehrmlive.com/index.php/admin/saveSystemUser")){
            logger.info("Test Passed - On correct URL");
        }
        else{
            logger.info("Test Failed - addUser Link not correct or URL has changed");
        }
        Assert.assertEquals("https://opensource-demo.orangehrmlive.com/index.php/admin/saveSystemUser", url);
    }

    @AfterTest
    public void teardown(){
        driver.quit();
        logger.info("Finishing Test: " + className);
    }
}