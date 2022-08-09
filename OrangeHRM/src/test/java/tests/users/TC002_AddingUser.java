package tests.users;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.AddingUserPage;
import pages.HomePage;
import testbase.SetupForAllTests;
import testbase.TestBase;
import utilities.ScreenShotting;

public class TC002_AddingUser {
    WebDriver driver;
    AddingUserPage userPage;
    HomePage homePage;
    Logger logger;
    String className = this.getClass().getSimpleName();

    @BeforeTest
    public void setup(){
        driver = TestBase.setup();
        logger=TestBase.getLogger();
        logger.info("Starting Test: " +className);
        homePage = new HomePage(driver);
        userPage = new AddingUserPage(driver);
        SetupForAllTests.loginSetup(driver);
        homePage.addingUser();
        userPage.selectUserType("Admin", logger);
        userPage.enterEmployeeName("Admin A", logger);
        userPage.enterUsername("OliviaRodrigo", logger);
        userPage.selectStatus("Enabled", logger);
        userPage.enterPassword("password123", logger);
        userPage.enterConfirmPassword("password123", logger);
        userPage.clickSaveButton(logger);

    }
    @Test
    public void testingAddingUser(){
        ScreenShotting.takeSnapShot(driver,className );
        String url = "https://opensource-demo.orangehrmlive.com/index.php/admin/viewSystemUsers";
        Boolean exists = userPage.checkingNewUserExists("OliviaRodrigo");
        if(exists){
            logger.info("User added - Test Passed");
        }
        else{
            logger.info("No new user - Test failed");
        }
        Assert.assertEquals(exists, true);
        Assert.assertEquals(url, driver.getCurrentUrl());


    }

    @AfterTest
    public void tearDown(){
        driver.quit();
        logger.info("Test Finished: " +className);
    }
}
