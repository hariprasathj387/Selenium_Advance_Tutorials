package Application;

import java.awt.datatransfer.StringSelection;
import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.FileSystemException;

import javax.annotation.processing.FilerException;

import org.checkerframework.checker.lock.qual.GuardedByUnknown;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DownloadExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:program Files//selenium//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		String urlString = "http://leafground.com/";
		driver.get(urlString);
		WebElement LINK = driver.findElement(By.linkText("DownLoad Files"));
		LINK.click();
		WebElement downloaElement = driver.findElement(By.linkText("Download Excel"));
		downloaElement.click();
		File files = new File("C:\\Users\\hari7\\Downloads");
		File[] file = files.listFiles();
		for (File file1 : file) {
			if (file1.getName().equals("testleaf.xlsx")) {
				System.out.println("The file is downloaded");
				break;
			}else {
				System.out.println("The directory not in the download files");
			}
			
		}

	}
	
}
