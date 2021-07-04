package Application;

import java.time.Duration;
import java.util.Set;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import com.sun.org.apache.bcel.internal.generic.Select;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.*;
public class LaunchApplication {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.gecko.driver", "C:\\program Files\\Selinium\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("http://leafground.com/home.html");
		driver.findElement(By.linkText("Edit")).click();
		driver.navigate().back();
		driver.findElement(By.linkText("Edit")).click();
		WebElement email = driver.findElement(By.xpath("//*[@id=\"email\"]"));
		email.sendKeys("hari.777.a12@gmail.com");
		WebElement userName = driver.findElement(By.xpath("/html/body/div/div/div[3]/section/div[2]/div/div/input"));
		userName.sendKeys("HARIPRASATH");
		String printmessage = driver.findElement(By.name("username")).getAttribute("TestLeaf");
		System.out.println(printmessage);
		WebElement clear = driver.findElement(By.name("/html/body/div/div/div[3]/section/div[4]/div/div/input"));
		clear.clear();
		
		//FluentWait
		/*
		 * Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
		 * .withTimeout(Duration.ofSeconds(20)) .pollingEvery(Duration.ofSeconds(3))
		 * .ignoring(NoSuchElementException.class); WebElement profilElement
		 * =wait.until(new Function<WebDriver, WebElement>() { public WebElement
		 * apply(WebDriver driver) { return
		 * driver.findElement(By.xpath("//*[@id=\"email\"]")); } });
		 */
		
	}

}
