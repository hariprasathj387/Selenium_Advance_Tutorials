package Application;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class DUMMY {

	static WebDriver driver;

	@BeforeSuite
	public void testClickJS() throws Exception {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("http://www.amazon.com/");
		WebElement searchTextBox = driver.findElement(By.id("twotabsearchtextbox"));
		searchTextBox.sendKeys("Mobiles \n");
		WebElement goButton = driver.findElement(By.cssSelector("input[value=Go]"));
		safeJavaScriptClick(goButton);
	}
	@Test
	public void safeJavaScriptClick(WebElement element) throws Exception {
		try {
			if (element.isEnabled() && element.isDisplayed()) {
				System.out.println("Clicking on element with using java script click");
				JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
				javascriptExecutor.executeScript("arguments[0].click();", element);
				System.out.println("sucessfully clicked ");
			} else {
				System.out.println("Unable to click on element");
			}
		} catch (StaleElementReferenceException e) {
			System.out.println("Element is not attached to the page document "+ e.getStackTrace());
		} catch (NoSuchElementException e) {
			System.out.println("Element was not found in DOM "+ e.getStackTrace());
		} catch (Exception e) {
			System.out.println("Unable to click on element "+ e.getStackTrace());
		}

}

}