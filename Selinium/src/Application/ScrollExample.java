package Application;

import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScrollExample {

	static WebDriver driver;

	static void driverSetup() {
		driver = new ChromeDriver();
		driver.get("https://masstamilan.fm/");
	}

	static void downAndUp() throws InterruptedException {
		JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
		javascriptExecutor.executeScript("window.scroll(0,450)", "");
		Thread.sleep(3000);
		javascriptExecutor.executeScript("window.scroll(0,-450)", "");
	}

	static void bottomPage() throws InterruptedException {
		JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
		Thread.sleep(1000);
		javascriptExecutor.executeScript("window.scrollTo(0,document.body.scrollHeight)", "");
		Thread.sleep(1000);
		javascriptExecutor.executeScript("window.scroll(0,0)", "");

	}

	static void particularElement() {
		JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
		try {
			Thread.sleep(2000);
			WebElement telunguPage = driver.findElement(By.xpath("//a[@title=\"Browse Latest Telugu Movies\"]"));
			javascriptExecutor.executeScript("arguments[0].scrollIntoView(true)", telunguPage);

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	static void robotPageDown() {
		try {
			Thread.sleep(2000);
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_PAGE_DOWN);
			robot.keyPress(KeyEvent.VK_PAGE_DOWN);
			robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
			robot.keyRelease(KeyEvent.VK_PAGE_DOWN);

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("No such found Exception: " + e);
		}
	}


	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		driverSetup();
		downAndUp();
		bottomPage();
		particularElement();
		robotPageDown();
	}

}
