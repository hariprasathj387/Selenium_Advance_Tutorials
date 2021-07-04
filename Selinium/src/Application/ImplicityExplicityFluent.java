package Application;

//import java.sql.Driver;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeSuite;

public class ImplicityExplicityFluent {
	// private static final Class<? extends Throwable> NoSuchElementException.class
	// = null;
	WebDriver driver;

	@BeforeSuite
	void driverSetup() {

		driver = new ChromeDriver();

		// Implicity:-

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		// explicity

		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement profElement = wait.until(ExpectedConditions.elementToBeClickable(By.id("q")));
		profElement.click();

		// FluentWait
		Wait<WebDriver> wait2 = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(20))
				.pollingEvery(Duration.ofSeconds(3))
				.ignoring(NoSuchElementException.class);
		wait2.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				return driver.findElement(By.xpath("//div[@class='dddd']"));
			}
		});

	}

}
