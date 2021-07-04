package Application;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.internal.thread.ThreadTimeoutException;

public class CheckBoxExample {
	static WebDriver driver;

	@BeforeSuite
	void driverSetup() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://leafground.com/pages/checkbox.html");
	}

	//@Test
	void checkBox() throws IOException {
		List<WebElement> checkBoxes = driver.findElements(By.xpath("//div[@class='example']//label//following::input"));
		File file= new File("F:\\hariprasath.txt");
		FileWriter fileWriter = new FileWriter(file,true);
		for(WebElement checkboxLists:checkBoxes) {
			checkboxLists.click();
		}
	WebElement chumaElement= driver.findElement(By.xpath("//*[@id=\"contentblock\"]/section/div[3]/label"));
	System.out.println(chumaElement.getText());
	
}
	@Test(priority = 0,timeOut = 2000,expectedExceptions =ThreadTimeoutException.class)
	void parentsPermission() throws InterruptedException {
		Thread.sleep(4000);
		System.out.println("Permission granted");
	}
	//@Test(priority = 1,dependsOnMethods ="parentsPermission",alwaysRun = true)
	void loveMarriage() throws InterruptedException {
		System.out.println(" Beitti tum saathi karo");
	}
	
	
	
}