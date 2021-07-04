package Application;

import java.util.Collection;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.sun.tools.javac.util.List;

public class AutoCompleteExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		System.setProperty("webdriver.chrome.driver", "C:\\program Files\\Selinium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		String urlString = "http://leafground.com/pages/autoComplete.html";
		driver.get("http://leafground.com/pages/autoComplete.html");
		WebElement autoComplete  = driver.findElement(By.className("ui-autocomplete-input"));
		autoComplete.sendKeys("s");
		List<WebElement> selects= (List<WebElement>) driver.findElements(By.xpath("//*[@id=\"ui-id-1\"]/li"));
		for(WebElement find : selects) {
			if(find.getText().equals("Selinium")) {
				System.out.println("The selinium is clicked");
				find.click();
				break;
			}
		}
	}

}
