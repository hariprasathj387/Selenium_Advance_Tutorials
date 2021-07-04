package Application;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class InputWithoutSendKeys {
	static WebDriver driver;

	public static void driverSetup(String name) {
		driver = new ChromeDriver();
		System.out.println();
		System.out.println();
		System.out.println("Broswer name is: " + name);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://ww.google.com");
	}

	public static WebElement sendKeys(WebDriver driver) {
		return driver.findElement(By.xpath("//*[@name='q']"));
	}

	public static void javascriptExecuter() {
		JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
		javascriptExecutor.executeScript("document.getElementsByName('q')[0].value='MynameisBilla'", "");
	}

	public static void javascriptExecuter1() {
		JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
		javascriptExecutor.executeScript("arguments[0].value='Thooki Sollu'", sendKeys(driver));
	}
	
	static void robot(WebDriver driver) {
		try {
			driver.switchTo().activeElement();
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_H);
			robot.keyRelease(KeyEvent.VK_H);
			robot.keyPress(KeyEvent.VK_A);
			robot.keyRelease(KeyEvent.VK_A);
			robot.keyPress(KeyEvent.VK_R);
			robot.keyRelease(KeyEvent.VK_R);
			robot.keyPress(KeyEvent.VK_I);
			robot.keyRelease(KeyEvent.VK_I);
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}


	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		driverSetup("Chrome");
		sendKeys(driver).sendKeys("I am Hari");
		Thread.sleep(2000);
		sendKeys(driver).clear();
		javascriptExecuter();
		Thread.sleep(1000);
		sendKeys(driver).clear();
		Thread.sleep(1000);
		javascriptExecuter1();
		Thread.sleep(1000);
		sendKeys(driver).clear();
		Thread.sleep(1000);
		robot(driver);
	}

	
}
