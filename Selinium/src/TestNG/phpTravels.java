package TestNG;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import jdk.jfr.internal.PrivateAccess;
import sun.security.pkcs11.wrapper.CK_SSL3_KEY_MAT_OUT;

public class phpTravels {
	WebDriver driver;
	String url = "https://phptravels.com/";
	String parentWindow;

	@BeforeSuite
	private void driverSetup() {
		System.setProperty("webdriver.chrome.driver", "C:\\program Files\\selenium\\chromedriver.exe");
		driver = new ChromeDriver();
		parentWindow = driver.getWindowHandle();
		System.out.println(parentWindow);

	}
	
	@Test(priority = 0)
	private void phptravelPage() {
		driver.get(url);
		System.out.println(driver.getCurrentUrl());

	}

	@Test(priority = 1)
	private void demo() {
		WebElement demoElement = driver.findElement(By.linkText("Demo"));
		demoElement.click();
	}

	@Test(priority = 2)
	private void mainPage() {
		WebElement mainElement = driver.findElement(
				By.xpath("//*[@id=\"Main\"]/section[1]/div/div/div[2]/div/div/div[2]/div/div/div[1]/div/a"));
		mainElement.click();
		Set<String> allWindows = driver.getWindowHandles();
		for (String manage : allWindows) {
			if (!parentWindow.equals(manage)) {
				if (manage.equals(manage)) {
					System.out.println(manage);
					driver.switchTo().window(manage);
				}
			}
		}
		System.out.println(allWindows);
	}

	@Test(priority = 4)
	private void hotels() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement destinationElement = driver.findElement(By.linkText("Buy Now"));
		destinationElement.click();
		Thread.sleep(5);
	}

	@AfterSuite
	private void CloseDriver() {
		driver.close();
	}
}
