package Application;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.sun.org.apache.bcel.internal.generic.Select;
public class DropdownList {
	WebDriver driver = new ChromeDriver();

	void dropDownList()  {
		driver.get("http://leafground.com/");
		String tittle=driver.getTitle();
		System.out.println("The Website Tittle is "+tittle);
		String url=driver.getCurrentUrl();
		System.out.println("The Website url is "+url);
		WebElement Link1 = driver.findElement(By.linkText("Drop down"));
		Link1.click();
		
								//selectByValue
		
		WebElement dropDown1 = driver.findElement(By.id("dropdown1"));
		org.openqa.selenium.support.ui.Select select = new org.openqa.selenium.support.ui.Select(dropDown1);
		select.selectByValue("1");
		//Thread.sleep(1000);
		select.selectByValue("2");
		///Thread.sleep(1000);
		select.selectByValue("3");
		//Thread.sleep(1000);
		select.selectByValue("4");
		
								//selectByIndex
		
		WebElement dropDown2 = driver.findElement(By.name("dropdown2"));
		org.openqa.selenium.support.ui.Select select1 = new org.openqa.selenium.support.ui.Select(dropDown2);
		select1.selectByIndex(0);
		//Thread.sleep(1000);
		select1.selectByIndex(1);
		//Thread.sleep(1000);
		select1.selectByIndex(2);
		//Thread.sleep(1000);
		select1.selectByIndex(3);
		
									//selectByVisibleText
		
		WebElement dropdown3 = driver.findElement(By.name("dropdown3"));
		org.openqa.selenium.support.ui.Select select2 = new org.openqa.selenium.support.ui.Select(dropdown3);
		select2.selectByVisibleText("Selenium");
		//Thread.sleep(1000);
		select2.selectByVisibleText("Appium");
		//Thread.sleep(1000);
		select2.selectByVisibleText("UFT/QTP");
		//Thread.sleep(1000);
		select2.selectByVisibleText("Loadrunner");
		
		
		
							//find the total option 
		
		WebElement dropdown4 = driver.findElement(By.xpath("//*[@id=\'contentblock\']/section/div[4]/select"));
		org.openqa.selenium.support.ui.Select select4 = new org.openqa.selenium.support.ui.Select(dropdown4);
		List<WebElement> listOfOptions1 = select4.getOptions();
		int size1 = listOfOptions1.size();
		System.out.println("There are " + size1 + " options available here");
	
							//SendKeys to Select
		
		WebElement dropDown5 = driver.findElement(By.xpath("//*[@id=\"contentblock\"]/section/div[5]/select"));
		dropDown5.sendKeys("Appium");
		
		
							//MultiSelect DropdownList
		
		WebElement dropdown5 = driver.findElement(By.xpath("//*[@id=\"contentblock\"]/section/div[6]/select"));
	    org.openqa.selenium.support.ui.Select select5 = new org.openqa.selenium.support.ui.Select(dropdown5);
	    select5.selectByIndex(0);
	    select5.selectByIndex(1);
	    select5.selectByIndex(2);
	    select5.selectByIndex(3);
		
		//org.openqa.selenium.support.ui.Select select7 = new org.openqa.selenium.support.ui.Select("dropdown5");
		
	}

	public static void main(String[] args){
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\program Files\\Selinium\\chromedriver.exe");
		DropdownList b = new DropdownList();
		b.dropDownList(); 
	}

}
