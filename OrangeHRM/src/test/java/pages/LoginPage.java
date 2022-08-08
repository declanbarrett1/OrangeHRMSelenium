package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;
	
// Locating WebElements on LoginPage
	@FindBy(id="txtUsername") WebElement username;
	@FindBy(id="txtPassword") WebElement password;
	@FindBy(id="btnLogin") WebElement loginButton;
	@FindBy(linkText="Forgot your password?") WebElement forgotPassword;
	
	
// Constructor to initialise driver for the class and to create PageFactory element
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}



// Methods

	public void typeUsername(String user) {
		username.sendKeys(user);
	}
	
	public void typePassword(String pass) {
		password.sendKeys(pass);
	}
	
	public void clickLoginButton() {
		loginButton.click();
	}
	
	public void forgottonPasswordLink() {
		forgotPassword.click();
	}
	


}