package Application;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.sun.tools.javac.util.List;

public class WindowHandle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","C://program Files//Selinium//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/Window.html");
		String parent =driver.getWindowHandle();

		WebElement click =	driver.findElement(By.id("color"));
		click.click();
		Set<String> windowChangeSet = driver.getWindowHandles();
		windowChangeSet.size();
		for(String changeString : windowChangeSet) {
			if(!parent.equals(changeString)) {
			int x=	windowChangeSet.size();
			System.out.println(x);	
			driver.switchTo().window(changeString);
				driver.close();
			
			}
		}
 		
			
	
	
	
	
	
	
	
	}	

}
