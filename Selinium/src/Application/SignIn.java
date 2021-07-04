package Application;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SignIn {
	WebDriver driver = new ChromeDriver();
	
	void login() {
		driver.get("https://www.google.com");
		//driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*input[@name=\"q\"]")).sendKeys("instagram");
		WebElement next=driver.findElement(By.xpath("//*[@id=\"identifierNext\"]/div/button/span"));
		next.click();
		WebElement password=driver.findElement(By.id("password"));
		password.clear();
		password.sendKeys("Car123456");
		WebElement button1=driver.findElement(By.xpath("//*[@id=\"passwordNext\"]/div/button/span"));
		button1.click();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.setProperties("webdriver.chrome.driver","C:\\\\program Files\\\\Selinium\\\\chromedriver.exe\");
		System.setProperty("webdriver.chrome.driver","C:\\program Files\\Selinium\\chromedriver.exe");
	
		SignIn b = new SignIn();
	     b.login();
		}

}
