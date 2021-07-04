package Application;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class MaximizeBrowser {

	//Different ways to maximize a browser window
	//-------------------------------------------------------------------------
	//1. Maximize() in selenium
	//2. Use of Dimension (selenium) and window.setSize() method
	//3. ChromeOptions - "--start-maximized"

	static WebDriver driver;

	static void ChromeMaximize() {
		System.setProperty("webdriver.chrome.driver", "C:program Files\\selenium\\chromedriver.exe");
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--start-maximized");
		driver = new ChromeDriver(chromeOptions);
		driver.get("https://www.google.com");
		driver.quit();
	}

	static void browserMaximize() {
		System.setProperty("webdriver.chrome.driver", "C:program Files\\selenium\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com");
		driver.quit();
	}

	static void browserMaximize1() {
		System.setProperty("webdriver.chrome.driver", "C:program Files\\selenium\\chromedriver.exe");
		driver = new ChromeDriver();
		Dimension dimension = new Dimension(1287, 870);
		driver.manage().window().setSize(dimension);
		driver.get("https://www.google.com");
		driver.quit();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChromeMaximize();
		browserMaximize();
		browserMaximize1();
	}

}
