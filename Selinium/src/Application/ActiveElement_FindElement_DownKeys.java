package Application;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import bsh.This;

public class ActiveElement_FindElement_DownKeys {

	// ActiveElement method
	// pageFactory element find Eethod
	// robot class
	static WebDriver driver;

	static void driverSetup() {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("http://www.Google.com");
	}

	
	public static WebElement activeElement(WebDriver driver) {
		return driver.switchTo().activeElement();
							//driver.switchTo().activeElement().sendKeys("hi");
	}
	
	//only find withot driver.findElement:-this method priority start only id and name
	public static WebElement q;
	
	public static WebElement RobotClass(WebDriver driver) throws AWTException, InterruptedException {
		driver.switchTo().activeElement().sendKeys("game of thrones");
		Robot robot  = new Robot();
		for(int i=0;i<4;i++) {
			Thread.sleep(2000);
		robot.keyPress(KeyEvent.VK_DOWN);
		}
		robot.keyRelease(KeyEvent.VK_DOWN);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		
		
	return driver.findElement(By.xpath("//div[normalize-space()='S08 E06 · The Iron Throne']")); 
	}

	
	public static void main(String[] args) throws AWTException, InterruptedException {
		// TODO Auto-generated method stub

			//   \n - is kind of Enter method
		//activeElement(driver).sendKeys("what is java \n");
		//PageFactory.initElements(driver, ActiveElement_FindElement_DownKeys.class);
		//q.sendKeys("Love me Like you do \n");
		driverSetup();
		String text = RobotClass(driver).getText();
		System.out.println("The text Field is: "+text);
		
		
	}

}
