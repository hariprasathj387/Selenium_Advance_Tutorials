package TestNG;

import java.awt.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Calender {

	WebDriver driver;
	float time;
	String Url = "http://leafground.com/home.html";

	@BeforeSuite
	void driver() {
		System.setProperty("webdriver.chrome.driver", "C:\\program Files\\selenium\\chromedriver.exe");
		driver = new ChromeDriver();
	}

	@Test(priority = 0)
	void siteSetup() {
		driver.get("http://leafground.com/home.html");
		String urName = driver.getCurrentUrl();
		System.out.println(urName);
		WebElement tablePagElement = driver.findElement(By.linkText("Calendar"));
		tablePagElement.click();
	}
	@Test(priority = 1)
	void claender() throws InterruptedException {
		WebElement  calenderElement=driver.findElement(By.id("datepicker"));
		calenderElement.click();
		calenderElement.sendKeys("20/08/1999");
		Thread.sleep(4);
		
	}
}
