package Application;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler; 

public class ScreenShotExample {
	static WebDriver driver;

	static void driverSetup() {
		//System.setProperty("webdriver.chrome.driver", "C:program Files\\selenium\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.google.com");
		driver.manage().window().maximize();
	}

	static void screenShot() throws IOException {
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File source = screenshot.getScreenshotAs(OutputType.FILE);
		File destinationFile = new File("F:\\gooogle.png");
		FileHandler.copy(source, destinationFile);
	}

	static void javaUtilScreenShot() throws IOException {
		// interview question:-
		// FileUtils.copyFile(source, new File("*./Screenshots/facebook.png"));
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		FileHandler.copy(sourceFile, new File("F:\\google1.png"));
		WebElement googimgElement = driver.findElement(By.xpath("//img[@class='lnXdpd']"));
		File sourceFile1 = googimgElement.getScreenshotAs(OutputType.FILE);
		// takesScreenshot.getScreenshotAs(OutputType.FILE);
		FileHandler.copy(sourceFile1, new File("F:\\google5.png"));

	}

	static void usingFullScreenShot() throws AWTException, IOException {
		Robot robot = new Robot();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Rectangle rectangle = new Rectangle(screenSize);
		BufferedImage bufferdImage = robot.createScreenCapture(rectangle);
		ImageIO.write(bufferdImage, "png", new File("F:\\google2.png"));

	}

	public static void main(String[] args) throws IOException, AWTException {
		// TODO Auto-generated method stub
		driverSetup();
		screenShot();
		javaUtilScreenShot();
		usingFullScreenShot();
	}

}
