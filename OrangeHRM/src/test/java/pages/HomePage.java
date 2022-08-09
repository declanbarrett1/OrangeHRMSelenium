package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import testbase.TestBase;

public class HomePage {
	WebDriver driver;
	Actions action;
	public WebElement checkingExistance;

	@FindBy(id="welcome") WebElement welcomeLink;
	@FindBy(id="menu_admin_viewAdminModule") WebElement adminDropDown;
	@FindBy(id="menu_pim_viewPimModule") WebElement pimDropDown;
	@FindBy(id="menu_leave_viewLeaveModule") WebElement leaveDropDown;
	@FindBy(id="menu_time_viewTimeModule") WebElement timeDropDown;
	@FindBy(id="menu_recruitment_viewRecruitmentModule") WebElement recruitmentDropDown;
	@FindBy(id="menu_pim_viewMyDetails") WebElement myDetailsDropDown;
	@FindBy(id="menu__Performance") WebElement performanceDropDown;
	@FindBy(id="menu_dashboard_index") WebElement dashboardDropDown;
	@FindBy(id="menu_directory_viewDirectory") WebElement directoryDropDown;
	@FindBy(id="menu_maintenance_purgeEmployee") WebElement maintenanceDropDown;
	@FindBy(id="menu_buzz_viewBuzz") WebElement buzzDropDown;
	@FindBy(id="menu_admin_UserManagement") WebElement userManagement;
	@FindBy(id="menu_admin_viewSystemUsers") WebElement users;
	@FindBy(id="btnAdd") WebElement addUser;


	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		action = new Actions(driver);
	}
	
	
	public void checkingForLoginTest() {
		checkingExistance = welcomeLink;
	}

	public void clickingAdminLink(){
		adminDropDown.click();
		TestBase.sleep(2000);
	}

	public void clickingpimLink(){
		pimDropDown.click();
		TestBase.sleep(2000);
	}

	public void clickingLeaveLink(){
		leaveDropDown.click();
		TestBase.sleep(2000);
	}
	public void clickingTimeLink(){
		timeDropDown.click();
		TestBase.sleep(2000);
	}

	public void clickingRecruitmentLink(){
		recruitmentDropDown.click();
		TestBase.sleep(2000);
	}

	public void clickingDetailsLink(){
		myDetailsDropDown.click();
		TestBase.sleep(2000);
	}

	public void clickingPerfomanceLink(){
		performanceDropDown.click();
		TestBase.sleep(2000);
	}

	public void clickingDashBoardLink(){
		dashboardDropDown.click();
		TestBase.sleep(2000);
	}

	public void clickingDirectoryLink(){
		directoryDropDown.click();
		TestBase.sleep(2000);
	}

	public void clickingMaintenanceLink(){
		maintenanceDropDown.click();
		TestBase.sleep(2000);
	}

	public void clickingBuzzLink(){
		buzzDropDown.click();
		TestBase.sleep(2000);
	}
	public void addingUser(){
		action.moveToElement(adminDropDown).perform();
		action.moveToElement(userManagement).perform();
		action.moveToElement(users).click().perform();
		TestBase.sleep(2000);
		addUser.click();
		TestBase.sleep(2000);
	}

}
