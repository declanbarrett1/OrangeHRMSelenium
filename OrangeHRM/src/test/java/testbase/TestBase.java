package testbase;

import java.time.Duration;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;

public class TestBase {
	static WebDriver driver;
	static Logger logger;
	
	
	public static WebDriver setup() {
		logger = Logger.getLogger("OrangeHRM");
		PropertyConfigurator.configure("src/test/resources/Properties/log4j.properties");
		logger.setLevel(Level.DEBUG);
		logger.info("Creating Logger");
		driver = new SafariDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/dashboard");
		
		
		return driver;
	}
	
	public static Logger getLogger() {
		return logger;
	}
	
	
	public static void sleep(int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
