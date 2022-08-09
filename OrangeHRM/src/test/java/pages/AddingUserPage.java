package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import testbase.TestBase;

public class AddingUserPage {

    @FindBy(id="systemUser_userType") WebElement typeOfUser;
    @FindBy(id="systemUser_employeeName_empName") WebElement employeeName;
    @FindBy(id="systemUser_userName") WebElement username;
    @FindBy(id="systemUser_status") WebElement status;
    @FindBy(id="systemUser_password") WebElement password;
    @FindBy(id="systemUser_confirmPassword") WebElement confirmPassword;
    @FindBy(id="btnSave") WebElement saveButton;
    @FindBy(id="btnCancel") WebElement cancelButton;


    WebDriver driver;

    public AddingUserPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void selectUserType(String type, Logger logger){
        Select typeOfUserSelect =new Select(typeOfUser);
        typeOfUserSelect.selectByVisibleText(type);
        TestBase.sleep(1000);
        logger.info("User type Selected");

    }
    public void enterEmployeeName(String empName, Logger logger){
        employeeName.sendKeys(empName);
        TestBase.sleep(1000);
        logger.info("Employees name entered");
    }
    public void enterUsername(String userName, Logger logger){
        username.sendKeys(userName);
        TestBase.sleep(1000);
        logger.info("username entered");
    }
    public void selectStatus(String statusText, Logger logger){
        Select statusSelect = new Select(status);
        statusSelect.selectByVisibleText(statusText);
        TestBase.sleep(1000);
        logger.info("select status");
    }
    public void enterPassword(String pass, Logger logger){
        password.sendKeys(pass);
        TestBase.sleep(1000);
        logger.info("entered password");
    }
    public void enterConfirmPassword(String confPass, Logger logger){
        confirmPassword.sendKeys(confPass);
        TestBase.sleep(1000);
        logger.info("Entered confirm password");
    }
    public void clickSaveButton(Logger logger){
        saveButton.click();
        TestBase.sleep(2000);
        logger.info("save button clicked");
    }
    public void clickCancelButton(){
        cancelButton.click();
        TestBase.sleep(2000);
    }

    public boolean checkingNewUserExists(String userName){
        WebElement newUser = driver.findElement(By.linkText(userName));
        if(newUser.isDisplayed()){
            return true;
        }
        else{
            return false;
        }
    }
}
