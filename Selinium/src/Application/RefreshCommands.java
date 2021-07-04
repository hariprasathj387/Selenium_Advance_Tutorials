package Application;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

//import com.cedarsoftware.util.ByteUtilities;


public class RefreshCommands {

	/*
	 * Different ways to refresh a browser:
	 * -------------------------------------------------------- 
	 * 1. Refresh command
	 * 2. driver.getCurrentUrl() 
	 * 3. Javascript Executor: location.reload() or history.go(0) 
	 * 4. Robot class f5
	 */	
	WebDriver driver;
	@BeforeSuite
	void driverSetup()  {
		System.setProperty("webdriver.chrome.driver", "C:program Files\\selenium\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.google.com");
		driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/input")).sendKeys("HAriprasath");
		driver.get(driver.getCurrentUrl());
	}
	
	@Test(priority = 1)
	void navigateRefresh() {
		driver.navigate().to("https://www.google.com");
		driver.navigate().refresh();
	}
	
	@Test(priority = 2)
	void javaExecuterrefresh() {
		JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
		javascriptExecutor.executeScript("location.reload");//(or)history.go(0)
		driver.get("https://www.google.com");
		driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/input")).sendKeys("hari");
	}
	
	@Test(priority = 3)
	void robotRefresh() throws Exception {
		Robot robot  = new Robot();
		robot.keyPress(KeyEvent.VK_F5);
		robot.keyRelease(KeyEvent.VK_F5);
	}
	@Test(priority =  4)
	void sendKeysRefresh() throws InterruptedException {
		driver.get("https://www.google.com");
		Thread.sleep(3000);
		driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/input")).sendKeys(Keys.F5);
		
	}
	
}
