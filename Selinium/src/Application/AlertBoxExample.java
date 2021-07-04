package Application;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertBoxExample {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\program Files\\Selinium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/");
		WebElement linkElement = driver.findElement(By.linkText("Alert"));
		linkElement.click();
		WebElement clickElement = driver
				.findElement(By.xpath("//*[@id=\"contentblock\"]/section/div[1]/div/div/button"));
		clickElement.click();
		Alert alert = driver.switchTo().alert();
		alert.accept();
		WebElement confirmBoxElement = driver
				.findElement(By.xpath("//*[@id=\"contentblock\"]/section/div[2]/div/div/button"));
		confirmBoxElement.click();
		Alert confirmAlert = driver.switchTo().alert();
		confirmAlert.accept();
		WebElement promElement = driver
				.findElement(By.xpath("//*[@id=\"contentblock\"]/section/div[3]/div/div/button"));
		promElement.click();
		Alert promotAlert = driver.switchTo().alert();
		Thread.sleep(3000);
		promotAlert.sendKeys("Testleaf");
		promotAlert.accept();
		WebElement lineBreakElement = driver
				.findElement(By.xpath("//*[@id=\"contentblock\"]/section/div[4]/div/div/button"));
		lineBreakElement.click();
		Alert lineBreakeAlert = driver.switchTo().alert();
		lineBreakeAlert.accept();
		WebElement sweetAlertElement = driver.findElement(By.xpath("//*[@id=\"btn\"]"));
		sweetAlertElement.click();
		Alert sweetAlert = driver.switchTo().alert();
		sweetAlert.accept();
		driver.close();

	}

}
