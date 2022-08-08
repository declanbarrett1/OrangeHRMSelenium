package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import net.bytebuddy.asm.Advice.This;

public class HomePage {
	WebDriver driver;
	public WebElement checkingExistance;

	@FindBy(id="welcome") WebElement welcomeLink;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public void checkingForLoginTest() {
		checkingExistance = welcomeLink;
	}
	
}
