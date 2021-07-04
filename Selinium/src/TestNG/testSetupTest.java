package TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.sun.tools.javac.code.Source;

public class testSetupTest {
	WebDriver driver;

	@BeforeSuite
	public void driverSetup() {
		//System.setProperty("webdriver.chrome.driver", "C:\\program Files\\Selinium\\chromedriver.exe");
		driver = new ChromeDriver();
	}

	@Test(priority = 0)
	public void webPageSetup() {
		driver.get("http://leafground.com/home.html");
		String pageName = driver.getCurrentUrl();
		System.out.println("The page name is: " + pageName);
		WebElement imageElement = driver.findElement(By.xpath("//*[@id=\"post-153\"]/div[2]/div/ul/li[4]/a"));
		imageElement.click();

	}

	@Test(priority = 1)
	void imageClick() throws InterruptedException {
		WebElement imageLinkCLick = driver
				.findElement(By.xpath("//*[@id=\"contentblock\"]/section/div[1]/div/div/img"));
		String imageWidth = imageLinkCLick.getAttribute("naturalWidth");
		int imageWidthConvert = Integer.parseInt(imageWidth);
		System.out.println(imageWidthConvert);
		if (imageWidthConvert == 0) {
			System.out.println("This is a broken image link");
		} else {
			imageLinkCLick.click();
			System.out.println("The Website is Succesfully Clicked!");
		}
		Thread.sleep(3);
		WebElement imageElement = driver.findElement(By.xpath("//*[@id=\"post-153\"]/div[2]/div/ul/li[4]/a"));
		imageElement.click();
		WebElement brokenImageElement = driver
				.findElement(By.xpath("//*[@id=\"contentblock\"]/section/div[2]/div/div/img"));
		String widthString = brokenImageElement.getAttribute("naturalWidth");
		System.out.println("The broken image width is: " + widthString);
		int converWidth = Integer.parseInt(widthString);
		if (converWidth == 0) {
			System.out.println("This is a broken image link");
		}
	}
	@AfterSuite
	void driverClose() {
		driver.close();
		System.out.println("chrome browser is succesfully closed");
	}
}
