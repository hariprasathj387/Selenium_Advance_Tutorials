package Application;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import com.sun.tools.javac.util.List;

public class SelectableExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\program Files\\selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/selectable.html");
		Actions actions = new  Actions(driver);
		List<WebElement> selectable = (List<WebElement>) driver.findElements(By.xpath("//*[@id='selectable']/li"));
		int x = selectable.size();
		System.out.println("x");
		actions.keyDown(Keys.CONTROL).click(selectable.get(0)).click(selectable.get(1)).click(selectable.get(2))
		.click(selectable.get(3)).click(selectable.get(4)).build().perform();
		
						//AnotherMethod
		
		driver.get("http://leafground.com/pages/selectable.html");
		Actions actions1 = new  Actions(driver);
		List<WebElement> selectable1 =(List<WebElement>) driver.findElements(By.xpath("//*[@id='selectable']/li"));
		int x = selectable.size();
		System.out.println("x");
		//actions.keyDown(Keys.CONTROL).click(selectablele.get(0)).click(selectable.get(1)).click(selectable.get(2))
		//.click(selectable.get(3)).click(selectable.get(4))
					actions.clickAndHold(selectable.get(0));
					actions.clickAndHold(selectable.get(1));
					actions.clickAndHold(selectable.get(2));
					actions.clickAndHold(selectable.get(3));
					actions.build().perform();
					
		
	
	}


}