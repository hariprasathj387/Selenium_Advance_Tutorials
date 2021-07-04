package Application;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class Links {
	static WebDriver driver;
	
	static void driveSetup() {
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--start-maximized");
		driver = new ChromeDriver(chromeOptions);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.google.com");
		System.out.println("Succesfully Googlepage opened");
		System.out.println(
				"-------------------------------------------------------------------------------------------------");
		System.out.println(
				"-------------------------------------------------------------------------------------------------");

	}

	static void search() {
		WebElement searchElement = driver.findElement(By.name("q"));
		searchElement.sendKeys("instagram hastags");
		WebElement searchButton = driver
				.findElement(By.xpath("//div[@class=\"FPdoLc lJ9FBc\"]//input[@name=\"btnK\"]"));
		searchButton.submit();
		System.out.println("Succesfully SendKeys Sented && Submited");
		System.out.println(
				"-------------------------------------------------------------------------------------------------");
		System.out.println(
				"-------------------------------------------------------------------------------------------------");

	}

	static void listAllLinks() {

		List<WebElement> listOfLinks = driver.findElements(By.xpath("//a"));
		for (WebElement linkNames : listOfLinks) {
			String ahref = linkNames.getAttribute("href");
			System.out.println(ahref);
			} 
		System.out.println(
				"-------------------------------------------------------------------------------------------------");
		System.out.println(
				"-------------------------------------------------------------------------------------------------");

	}
	static void highLightedLink() throws InterruptedException {
		//Thread.sleep(1000);
		List<WebElement> listOfLinks = driver.findElements(By.xpath("//div[@id=\"search\"]//following::h3//following::div//cite"));
		//Thread.sleep(5000);
		for (WebElement linkNames : listOfLinks) {
		System.out.println(linkNames.getText());
			//Thread.sleep(500);
			
			  //int x=ahref.lastIndexOf(">"); 
			 // String filteredList=ahref.substring(0,x+1);
			  //System.out.println(filteredList); 
			  //System.out.println(ahref);
			 } 
		}
		
	static void driverQuit() {
		driver.quit();
	}

	public static void main(String[] args) throws InterruptedException{
		// TODO Auto-generated method stub
		
		 driveSetup(); search(); listAllLinks(); highLightedLink(); Thread.sleep(3000); driverQuit();
		 
	
	}

}
