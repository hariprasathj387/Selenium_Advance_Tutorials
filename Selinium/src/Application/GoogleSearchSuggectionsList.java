package Application;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class GoogleSearchSuggectionsList {
	static WebDriver driver;

	static void driverSetup() {
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--start-maximized");
		driver = new ChromeDriver(chromeOptions);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
	}

	static void googleSearch() {
		driver.get("https://www.google.com/webhp?hl=en&sa=X&ved=0ahUKEwjCptbZkrbxAhWNA3IKHR1TDlsQPAgI");
		WebElement searchToolKitElement = driver.findElement(By.xpath("//input[@class=\"gLFyf gsfi\"]"));
		searchToolKitElement.sendKeys("gameofthrones");
		
	}

	static void suggectionListPrint() {
		java.util.List<WebElement> listOfElementLists = (java.util.List<WebElement>) driver
				.findElements(By.xpath("//ul[@role=\"listbox\"]//following::li"));
		try {
			Thread.sleep(2000);
			for (WebElement lists : listOfElementLists) {
				System.out.println(lists.getText());
				// System.out.println("finished"); 
				 
			}

		
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
				System.out.println("finished");
		try {
			Thread.sleep(5000);
			driver.quit();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		driverSetup();
		googleSearch();
		suggectionListPrint();
	}

}
