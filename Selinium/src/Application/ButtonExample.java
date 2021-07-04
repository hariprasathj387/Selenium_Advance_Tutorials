package Application;

import java.awt.Dimension;
import java.awt.Point;
//import org.openqa.selenium.Point;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ButtonExample {
	WebDriver driver = new ChromeDriver();

	void buttonLaunch() {
		driver.get("http://leafground.com/home.html");
		WebElement buttonOnClick = driver.findElement(By.linkText("Button"));
		buttonOnClick.click();
		WebElement getPosstionButton = driver.findElement(By.id("position"));
		org.openqa.selenium.Point xyValue = getPosstionButton.getLocation();
		double xValue = xyValue.getX();
		double yValue = xyValue.getY();
		System.out.println("X Coordinate is " + xValue + " Y Coordinate is " + yValue);
		WebElement colour = driver.findElement(By.id("color"));
		String buttonClour = colour.getCssValue("background-color");
		System.out.println("Button Colour is " + buttonClour);
		WebElement buttonSize = driver.findElement(By.id("size"));
		int buttonHeight = buttonSize.getSize().getHeight();
		int buttonWidth = buttonSize.getSize().getWidth();
		System.out.println("The button Width is : " + buttonWidth + " The button Height is : " + buttonHeight);
		}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\program Files\\selenium\\chromedriver.exe");
		ButtonExample a = new ButtonExample();
		a.buttonLaunch();
	}

}
