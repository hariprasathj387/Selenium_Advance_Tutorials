package TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class login {
	
	@Test
	void loginCorrectPassword() {
		System.setProperty("webdriver.gecko.driver", "C:\\Program Files\\selenium\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		WebElement userElement = driver.findElement(By.xpath("//input[@id=\"txtUsername\"]"));
		userElement.sendKeys("qq");
		WebElement passwordElement = driver.findElement(By.xpath("//input[@type=\"password\"]"));
		passwordElement.sendKeys("qq");
		WebElement loginElement = driver.findElement(By.xpath("//input[@id=\"btnLogin\"]"));
		loginElement.click();
	}
}
