package Application;

//import java.sql.Driver;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

//import net.bytebuddy.description.annotation.AnnotationValue.ForAnnotationDescription.IncompatibleRuntimeType;

public class WindowHandleExample {
	
	WebDriver driver = new ChromeDriver();
   	String parentWindow = driver.getWindowHandle();
	
   	void windowHandle() throws InterruptedException {
		driver.get("http://leafground.com/home.html");
		WebElement windowPage = driver.findElement(By.xpath("//*[@id=\"post-153\"]/div[2]/div/ul/li[11]/a/h5"));
		windowPage.click();
		String url = driver.getCurrentUrl();
		System.out.println("The current url is: " + url);
		WebElement button1Element = driver.findElement(By.id("home"));
		button1Element.click();
		newWindow();
	}

	void newWindow() throws InterruptedException {
		//String parentWindow = driver.getWindowHandle();
		//driver.getWindowHandle();
		Set<String> tabSet = driver.getWindowHandles();
		for (String newWindow : tabSet) {
			if (!parentWindow.equals(newWindow)) {
			driver.switchTo().window(newWindow);
			}
		} 
		// driver.switchTo().window(parentWindow);
		WebElement edit = driver.findElement(By.linkText("Edit"));
		edit.click();
		WebElement email = driver.findElement(By.id("email"));
		email.sendKeys("hari.777.a12mail.com" + Keys.TAB);
		WebElement appendText = driver.findElement(By.xpath("//*[@id=\"contentblock\"]/section/div[2]/div/div/input"));
		String valueString = appendText.getAttribute("value");
		System.out.println("The value of the appendText: " + valueString);
		appendText.clear();
		appendText.sendKeys("Now I am Single", Keys.TAB);
		WebElement defaultText = driver.findElement(By.xpath("//*[@id=\"contentblock\"]/section/div[2]/div/div/input"));
		String valueString1 = defaultText.getAttribute("value");
		System.out.println("The default text is:" + valueString1);
		WebElement clearField = driver.findElement(By.xpath("//*[@id=\"contentblock\"]/section/div[4]/div/div/input"));
		String valueString3 = clearField.getAttribute("value");
		System.out.println("The clear text field is: " + valueString3);
		clearField.clear();
		WebElement defaultElement = driver
				.findElement(By.xpath("//*[@id=\"contentblock\"]/section/div[5]/div/div/input"));
		boolean isEnabled = defaultElement.isEnabled();
		System.out.println("The field type is disabled : " + isEnabled);

		if (isEnabled != false) {
			System.out.println("The field type is open");
		} else {
			System.out.println("The field type is disabled : " + isEnabled);
		}
		driver.close();
		
		windowCount();
	}
	void windowCount() throws InterruptedException {
		driver.switchTo().window(parentWindow);
		WebElement countTabs = driver.findElement(By.xpath("//*[@id=\"contentblock\"]/section/div[2]/div/div/button"));
		countTabs.click();
		Set<String> multiTab1 = driver.getWindowHandles();
		int x = multiTab1.size();
		System.out.println("The number of opening Tab :"+ x );
		WebElement multiWindoWebElement = driver.findElement(By.id("color"));
		multiWindoWebElement.click();
		Set<String> multiTab2 = driver.getWindowHandles();
		for(String close : multiTab2) {
		if (!parentWindow.equals(close)) {
			driver.switchTo().window(close);
			driver.close();
			}
		}
		driver.switchTo().window(parentWindow);
		WebElement after5sec =  driver.findElement(By.xpath("//*[@id=\"color\"]"));
		Thread.sleep(3000);
		after5sec.click();
		Set<String> multiTab3 = driver.getWindowHandles();
		for(String close : multiTab3) {
			if (!parentWindow.equals(close)) {
				driver.switchTo().window(close);
				driver.close();
				}
			}
		driver.quit();
	}

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C://program Files//Selinium//chromedriver.exe");
		WindowHandleExample b = new WindowHandleExample();
		b.windowHandle();
	}

}
