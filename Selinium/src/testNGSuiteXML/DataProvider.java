package testNGSuiteXML;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class DataProvider {
	String[][] Data = { { "hariprasath", "12345" }, { "hariprasath", "12345678" }, { "Admin", "admin123" },
			{ "ssss", "ww33eeeddsaa" } };
	
	@org.testng.annotations.DataProvider(name = "loginData")
	String[][]  loginDataProvider() {
		return Data;
	}

	@Test(dataProvider = "loginData")

	void loginCorrectPassword(String userName, String pasword) {
		System.setProperty("webdriver.gecko.driver", "C:program Files\\selenium\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
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
