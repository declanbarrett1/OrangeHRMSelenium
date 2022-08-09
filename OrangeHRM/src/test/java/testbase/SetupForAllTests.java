package testbase;

import org.openqa.selenium.WebDriver;

import pages.LoginPage;

public class SetupForAllTests {
    static LoginPage loginPage;

    public static void loginSetup(WebDriver driver){
        loginPage = new LoginPage(driver);
        loginPage.typeUsername("Admin");
        loginPage.typePassword("admin123");
        loginPage.clickLoginButton();
        TestBase.sleep(2000);
    }
}
