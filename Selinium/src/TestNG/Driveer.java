package TestNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Driveer {
	WebDriver driver;
	@Test
	public void driverSetup() {
		System.setProperty("webdriver.chrome.driver", "C:program Files\\selenium\\chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.get("https://www.phptravels.net/login");
		
		///LoginObject.username(driver).sendKeys("user@phptravels.com",Keys.TAB);
	}
}
