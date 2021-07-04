package Application;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Window;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import com.sun.java.swing.plaf.windows.resources.windows;

public class DragDrop {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\program Files\\Selinium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/drop.html"); 
		Actions actions = new  Actions(driver);
		WebElement dragElement	= driver.findElement(By.id("draggable"));
		WebElement dropElement = driver.findElement(By.id("droppable"));
		actions.clickAndHold(dragElement).moveToElement(dropElement).release(dropElement).build().perform();
		driver.navigate().to("http://leafground.com/pages/drop.html");
		WebElement dragElement1	= driver.findElement(By.id("draggable"));
		WebElement dropElement2 = driver.findElement(By.id("droppable"));
		int x =	dragElement1.getLocation().getX();
		int y = dragElement1.getLocation().getY();
		System.out.println(x);
		System.out.println(y);
		
		//this method only drag not for the target
		driver.quit();
//		WebElement dragElement2	= driver.findElement(By.id("draggable"));
//		WebElement dropElement1 = driver.findElement(By.id("droppable"));
	}

}
