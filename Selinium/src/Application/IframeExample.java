package Application;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.sun.tools.javac.util.List;
//import  java.util.List;

public class IframeExample {
	WebDriver driver = new ChromeDriver();

	void iframe() {
		String url = "http://leafground.com/pages/frame.html";
		driver.get("http://leafground.com/pages/frame.html");
		driver.switchTo().frame(0);
		WebElement iframe = driver.findElement(By.id("Click"));
		iframe.click();
		String afterClcik = iframe.getText();
		System.out.println(afterClcik);
		driver.switchTo().defaultContent();
		driver.switchTo().frame(1);
		driver.switchTo().frame("frame2");
		WebElement iframe2 = driver.findElement(By.id("Click1"));
		iframe2.click();
		String afterClick1 = iframe2.getText();
		System.out.println(afterClick1);
		driver.switchTo().defaultContent();
		WebElement totalElementIframe1= driver.findElement(By.tagName("iframe"));
	//	int totalIframe = totalElementIframe1.Size();
		//System.out.println("The total iframe in the site : " + totalIframe);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C://program Files//Selinium//chromedriver.exe");
		IframeExample b = new IframeExample();
		b.iframe();
	}

}
