package Application;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingAuthenticationPopup {
	static WebDriver driver;
	static void driverSetup() {
		driver = new ChromeDriver();
		driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		driverSetup();
	}

}
