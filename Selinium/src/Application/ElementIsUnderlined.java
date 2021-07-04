package Application;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class ElementIsUnderlined {
	
	//Assert VS Verify
	//Assert is called HardAsseet==>method:-Assert.aseertEquals(True,true) and Assert.true()
	//Verify is called SoftAssert==>is not a method..this only class:-SoftAssert
	
	@Test(priority = 0)
	public void test1() {
		//HardAssert
		System.out.println("Before decoration: ");
		Assert.fail();
		System.out.println("After decoration: ");
		
	}

	
	
	@Test(priority = 1)
	public void test2() {
		//SoftAssert
		SoftAssert softAssert = new SoftAssert();
		System.out.println("Before decoration: ");
		softAssert.fail();
		System.out.println("After decoration: ");
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com");
		WebElement tamilElement = driver.findElement(By.xpath("//a[text()='தமிழ்']"));
		String beforeHover = tamilElement.getCssValue("text-decoration");
		System.out.println("Before decoration: " + beforeHover);
		Actions actions = new Actions(driver);
		actions.moveToElement(tamilElement);
		actions.build();
		actions.perform();
		String afteHover = tamilElement.getCssValue("text-decoration");
		System.out.println("After decoration: " + afteHover);
		

	}

}
