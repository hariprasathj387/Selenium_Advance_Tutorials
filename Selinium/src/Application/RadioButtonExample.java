package Application;

import java.awt.Point;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import jdk.javadoc.internal.doclets.formats.html.Navigation;

public class RadioButtonExample {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\program Files\\Selinium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/");
		WebElement radioButtonPage = driver.findElement(By.xpath("//*[@id=\"post-153\"]/div[2]/div/ul/li[6]/a"));
		radioButtonPage.click();
		WebElement yesElement = driver.findElement(By.id("yes"));
		yesElement.click();
		WebElement unCheckElement = driver
				.findElement(By.xpath("//*[@id=\"contentblock\"]/section/div[2]/div/div/label[2]/input"));
		boolean status1 = unCheckElement.isSelected();
		WebElement checkElement = driver
				.findElement(By.xpath("//*[@id=\"contentblock\"]/section/div[2]/div/div/label[3]/input"));
		// boolean status1 = checkElement.isSelected();
		boolean status2 = checkElement.isSelected();
		if (status2 == true) {
			System.out.println("The default selection Is uncheckElement : " + status2);
		} else {
			System.out.println("both are not selected");
		}
		WebElement ageElement = driver.findElement(By.name("age"));
		ageElement.click();
		Thread.sleep(3000);
		driver.navigate().back();
		WebElement checkBoxElement = driver.findElement(By.linkText("Checkbox"));
		checkBoxElement.click();
		WebElement languageElement = driver
				.findElement(By.xpath("//*[@id=\"contentblock\"]/section/div[1]/div[1]/input"));
		languageElement.click();
		WebElement languageElement1 = driver
				.findElement(By.xpath("//*[@id=\"contentblock\"]/section/div[1]/div[3]/input"));
		languageElement1.click();
		WebElement languageElement2 = driver
				.findElement(By.xpath("//*[@id=\"contentblock\"]/section/div[2]/div/input"));
		boolean isChecked = languageElement2.isSelected();
		if (isChecked == true) {
			System.out.println("Yes this field is Checked " + isChecked);
		}
		WebElement onlyCheckElement = driver
				.findElement(By.xpath("//*[@id=\"contentblock\"]/section/div[3]/div[1]/input"));

		WebElement onlyCheckElement1 = driver
				.findElement(By.xpath("//*[@id=\"contentblock\"]/section/div[3]/div[2]/input"));
		boolean isSelected = onlyCheckElement1.isSelected();
		if (isSelected == false) {
			System.out.println("This is field checked");
		} else {
			onlyCheckElement1.click();
			System.out.println("This filed is unchecked");
		}

		WebElement select1 = driver.findElement(By.xpath("//*[@id=\"contentblock\"]/section/div[4]/div[2]/input"));
		select1.click();

		WebElement select2 = driver.findElement(By.xpath("//*[@id=\"contentblock\"]/section/div[4]/div[1]/input"));
		select2.click();

		WebElement select3 = driver.findElement(By.xpath("//*[@id=\"contentblock\"]/section/div[4]/div[4]/input"));
		select3.click();

		WebElement select4 = driver.findElement(By.xpath("//*[@id=\"contentblock\"]/section/div[4]/div[5]/input"));
		select4.click();

		WebElement select5 = driver.findElement(By.xpath("//*[@id=\"contentblock\"]/section/div[4]/div[3]/input"));
		select5.click();
	}
}
