package Application;

import java.awt.desktop.SystemEventListener;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Window;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.sun.tools.javac.util.List;

public class SelectMethods {
	String urlString = "http://leafground.com/";
	
	 WebDriver driver = new ChromeDriver();
	 	
	void driverSetup(String url,String link) {
		driver.get(url);
		driver.manage().window().maximize();
		WebElement linkElement = driver.findElement(By.linkText(link));
		linkElement.click();
		}
	   public static String select(WebElement element){
		   
		   Select selectOptionSelect = new Select(element);
		   	WebElement selectedElement =	selectOptionSelect.getFirstSelectedOption();
		   String firstValueString = selectedElement.getText();
		  return firstValueString;
		   }
	   
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver","C:\\program Files\\Selinium\\chromedriver.exe");
		SelectMethods select = new SelectMethods();
		String urlString = "http://leafground.com/";
		String linkString = "Drop down";
		String selectString="v";
		select.driverSetup(urlString,linkString);
		select(totalSelectElement);
	}

}
