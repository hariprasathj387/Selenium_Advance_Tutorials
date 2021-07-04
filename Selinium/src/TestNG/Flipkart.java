package TestNG;

//import java.awt.List;

//import org.checkerframework.checker.lock.qual.GuardedByUnknown;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.sun.org.apache.xerces.internal.impl.xpath.XPath;
import com.sun.tools.javac.util.List;

public class Flipkart {
	// driver in enitire class
	WebDriver driver;
	String url = "https://www.google.com/webhp?hl=en&sa=X&ved=0ahUKEwj779fFtqDxAhX8yzgGHSmCD9IQPAgI";
	
	@BeforeSuite
	void driverSetup() {
		System.setProperty("webdriver.chrome.driver", "C:program Files\\selenium\\chromedriver.exe");
		driver = new ChromeDriver();
		//driver.manage().window().maximize();
	}

	@Test(priority = 0)
	void webSiteSetup() {
		driver.get(url);
		String urlString = driver.getCurrentUrl();
		System.out.println(urlString);
		WebElement searchBox = driver.findElement(By.name("q"));
		searchBox.sendKeys("flipkart", Keys.ENTER);
		WebElement flipkartpagElement = driver
				.findElement(By.xpath("//*[@id=\"rso\"]/div[1]/div/div/div/div/div/div/div[1]/a/h3"));
		flipkartpagElement.click();
	}

	@Test(priority = 1)
	void loginpage() {
		Actions sendEsc = new Actions(driver);
		Actions closeActions = sendEsc.sendKeys(Keys.ESCAPE);
		closeActions.build().perform();
	}

	@Test(priority = 2)
	void flipkartPage() {
		WebElement searchElement = driver.findElement(By.name("q"));
		searchElement.sendKeys("pocom2", Keys.ENTER);
		Actions page = new Actions(driver);
		for (int i = 0; i < 2; i++) {
			page.sendKeys(Keys.PAGE_DOWN).build().perform();
		}
	}

	@Test(priority = 3)
	void comparrison() {
		java.util.List<WebElement> products = driver.findElements(By.xpath("//div[@class=\"_1YokD2 _3Mn1Gg\"][2]"));
		System.out.println(products.size());
		for(WebElement names:products) {
	
		}
	}

	@AfterSuite
	void driverClose() {
		// driver.close();
	
	}
}
