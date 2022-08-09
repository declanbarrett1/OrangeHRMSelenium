package tests.users;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.AddingUserPage;
import pages.HomePage;
import testbase.SetupForAllTests;
import testbase.TestBase;
import utilities.ReadExcelFile;
import utilities.ScreenShotting;

public class TC003_AddingUserWithParams {
    WebDriver driver;
    AddingUserPage userPage;
    HomePage homePage;
    Logger logger;
    String className = this.getClass().getSimpleName();
    static ReadExcelFile readFile;

    @BeforeTest
    public void setup(){
        driver = TestBase.setup();
        logger=TestBase.getLogger();
        logger.info("Starting Test: " +className);
        homePage = new HomePage(driver);
        userPage = new AddingUserPage(driver);
        SetupForAllTests.loginSetup(driver);
        homePage.addingUser();


    }
    @Test(dataProvider="dataForTest")
    public void testingAddingUser(String userType, String employeeName, String userName, String status, String password
    , String confPassowrd)
    {
        userPage.selectUserType(userType, logger);
        userPage.enterEmployeeName(employeeName, logger);
        userPage.enterUsername(userName, logger);
        userPage.selectStatus(status, logger);
        userPage.enterPassword(password, logger);
        userPage.enterConfirmPassword(confPassowrd, logger);
        userPage.clickSaveButton(logger);
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

    @DataProvider(name="dataForTest")
    public static Object[][] getData() {
        readFile = new ReadExcelFile();
        int rowCount = readFile.getRowCount("dataForNewUser.xlsx", "Sheet1");
        System.out.println(rowCount);
        int colCount = readFile.getCellCount("dataForNewUser.xlsx", "Sheet1");
        String[][] data = new String[rowCount-1][colCount];

        for(int x = 1; x <= rowCount; x++) {
            for(int y = 0; y < colCount; y++) {
                data[x-1][y] = readFile.getCellData("dataForNewUser.xlsx", "Sheet1", x, y);
            }
        }

        return data;
    }
}
