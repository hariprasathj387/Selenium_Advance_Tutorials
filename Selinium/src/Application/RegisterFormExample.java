package Application;

import java.io.File;
import java.util.logging.FileHandler;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RegisterFormExample {
	
	WebDriver driver = new ChromeDriver();
	
public RegisterFormExample() {
	// TODO Auto-generated constructor stub
	
}
	void registerForm() {
		
		String url = "http://demo.guru99.com/test/newtours/register.php";
		driver.get("http://demo.guru99.com/test/newtours/register.php");
		//for(int i =0;i<10;i++) {
		WebElement nameElement = driver.findElement(By.name("firstName"));
		WebElement lastElement = driver.findElement(By.name("lastName"));
		WebElement phonElement = driver.findElement(By.name("phone"));
		WebElement userElement = driver.findElement(By.id("username"));
		WebElement addressElement = driver.findElement(By.name("address1"));
		WebElement cityElement = driver.findElement(By.name("city"));
		WebElement statElement = driver.findElement(By.name("state"));
		WebElement postalElement = driver.findElement(By.name("postalCode"));
		WebElement countryElement = driver.findElement(By.name("country"));
		WebElement emailElement2 = driver.findElement(By.id("email"));
		WebElement passwordElement = driver.findElement(By.name("password"));
		WebElement confirmPasswordElement = driver.findElement(By.name("confirmPassword"));
		WebElement submitElement = driver.findElement(By.name("submit"));
		nameElement.sendKeys("Hari",Keys.TAB);
		lastElement.sendKeys("prasath J",Keys.TAB);
		phonElement.sendKeys("8825573590",Keys.TAB);
		userElement.sendKeys("@hari_prasath",Keys.TAB);
		addressElement.sendKeys("2/2,SelavanagarStreet,Puliyur,Karur(DT)",Keys.TAB);
		cityElement.sendKeys("Karur",Keys.TAB);
		statElement.sendKeys("Tamilnadu",Keys.TAB);
		postalElement.sendKeys("639114",Keys.TAB);
		countryElement.sendKeys("Indian",Keys.TAB);
		emailElement2.sendKeys("hariprasthj208@gmail.com",Keys.TAB);
		passwordElement.sendKeys("Car123456",Keys.TAB);
		confirmPasswordElement.sendKeys("Car123456",Keys.TAB);
		submitElement.submit();
		driver.quit();
		}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C://program Files//Selinium//chromedriver.exe");
		RegisterFormExample b = new RegisterFormExample();
		b.registerForm();
	}

}
