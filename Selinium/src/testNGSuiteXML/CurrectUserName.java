package testNGSuiteXML;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CurrectUserName {

	@Test
	@Parameters({"username","password"})
	void loginCorrectPassword(String userName,String pasword) {
		System.setProperty("webdriver.chrome.driver", "C:program Files\\selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		WebElement userElement = driver.findElement(By.xpath("//input[@id=\"txtUsername\"]"));
		userElement.sendKeys(userName);
		WebElement passwordElement = driver.findElement(By.xpath("//input[@type=\"password\"]"));
		passwordElement.sendKeys(pasword);
		WebElement loginElement = driver.findElement(By.xpath("//input[@id=\"btnLogin\"]"));
		loginElement.click();
		driver.close();
	}
}