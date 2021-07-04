package testNGSuiteXML;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputFilter.Config;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CorrectPassword {
	WebDriver driver;
	String browser;
	String location;
	String location1;
	String drivers;
	String driver1;

	@BeforeSuite
	void driverSetup() throws IOException {
		FileInputStream fileInputStream = new FileInputStream("F:\\Selinium\\src\\demoSite\\config.properties");
		Properties properties = new Properties();
		properties.load(fileInputStream);
		browser = properties.getProperty("Browser");
		location = properties.getProperty("Location");
		location1 = properties.getProperty("Location1");
		drivers = properties.getProperty("Driver");
		driver1 = properties.getProperty("Driver1");

		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty(drivers, location);
			this.driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty(driver1, location1);
			this.driver = new FirefoxDriver();
		}
		this.driver.get("https://opensource-demo.orangehrmlive.com/");
	}

	@Test
	@Parameters({ "username", "password" })
	void loginCorrectPassword(String usName, String pasword) {

		WebElement userElement = driver.findElement(By.xpath("//input[@id=\"txtUsername\"]"));
		userElement.sendKeys(usName);
		WebElement passwordElement = driver.findElement(By.xpath("//input[@type=\"password\"]"));
		passwordElement.sendKeys(pasword);
		WebElement loginElement = driver.findElement(By.xpath("//input[@id=\"btnLogin\"]"));
		loginElement.click();
		driver.close();
	}

}
