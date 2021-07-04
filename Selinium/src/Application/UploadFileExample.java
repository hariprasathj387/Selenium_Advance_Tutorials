package Application;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.event.KeyEvent;
import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class UploadFileExample {

	
	
	public static void main(String[] args) throws AWTException {
		// TODO Auto-generated method stub
		
	System.setProperty("webdriver.chrome.driver", "C:program Files//Selinium//chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.get("http://leafground.com/");
	WebElement link =driver.findElement(By.linkText("Upload Files"));
	link.click();
	WebElement choosElement = driver.findElement(By.xpath("//*[@id=\"mydiv\"]/input"));
	choosElement.click();
	File files = new File("F:\\java\\Bubble Short,Short,Max & Min.pdf");
	Toolkit.getDefaultToolkit().getSystemClipboard().setContents((Transferable) files, null);
	Robot robot = new Robot();
	robot.keyPress(KeyEvent.VK_CONTROL);
	robot.keyPress(KeyEvent.VK_V);
	robot.keyRelease(KeyEvent.VK_V);
	robot.keyRelease(KeyEvent.VK_CONTROL);
	robot.keyPress(KeyEvent.VK_ENTER);
	
		
		}

}
