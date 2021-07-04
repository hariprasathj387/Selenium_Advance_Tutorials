package Application;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

public class Css {

	public WebDriver driver;
	private By bySearchButton = By.name("btnK");

	@BeforeSuite
	public void setUp() {
		driver = new FirefoxDriver();
		driver.get("http://www.google.com");
		getCssValue_ButtonColor();
	}

	public void getCssValue_ButtonColor() {
		WebElement googleSearchBtn = driver.findElement(bySearchButton);
		System.out.println("Color of a button before mouse hover: " + googleSearchBtn.getCssValue("color"));
		Actions action = new Actions(driver);
		action.moveToElement(googleSearchBtn).perform();
		System.out.println("Color of a button after mouse hover : " + googleSearchBtn.getCssValue("color"));
		getCssValue_ButtonFontSize();
	}

	public void getCssValue_ButtonFontSize() {
		WebElement googleSearchBtn = driver.findElement(bySearchButton);
		System.out.println("Font Size of a button " + googleSearchBtn.getCssValue("font-size"));
		getCssValue_ButtonFontWeight();
	}

	public void getCssValue_ButtonFontWeight() {
		WebElement googleSearchBtn = driver.findElement(bySearchButton);
		System.out.println("Font Weight of a button " + getFontWeight(googleSearchBtn));
		getFontWeight(googleSearchBtn);
	}

	public String getFontWeight(WebElement element) {
		// Output will return as 400 for font-weight : normal, and 700 for font-weight :
		// bold
		return element.getCssValue("font-weight");
	}

	@AfterSuite
	public void tearDown() {
		driver.quit();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\program Files\\Selinium\\chromedriver.exe");

	}
}
