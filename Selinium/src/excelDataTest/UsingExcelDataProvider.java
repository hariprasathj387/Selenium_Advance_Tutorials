package excelDataTest;

import java.io.FileInputStream;
import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class UsingExcelDataProvider {
	WebDriver driver;
	String[][] data = null;

//	String pathString = "F:\\Selenium dataProvider\\logindata.xls\";
	@BeforeSuite
	void driverSetup() {
		System.setProperty("webdriver.chrome.driver", "C:program Files\\selenium\\chromedriver.exe");
		driver = new ChromeDriver();
	}

	@DataProvider(name = "loginData")
	String[][] data() throws BiffException, IOException {
		data = excelData();
		return data;
	}

	String[][] excelData() throws IOException, BiffException {
		FileInputStream file = new FileInputStream("F:\\Selenium dataProvider\\logindata.xls");
		Workbook workbook = Workbook.getWorkbook(file);
		Sheet sheet = workbook.getSheet(0);
		int column = sheet.getColumns();
		int row = sheet.getRows();
		System.out.println(column);
		System.out.println(row);
		String[][] testData = new String[row - 1][column];
		for (int i = 1; i < row; i++) {
			for (int j = 0; j < column; j++) {
				testData[i - 1][j] = sheet.getCell(j, i).getContents();
			}
		}
		return testData;
	}

	@AfterSuite
	void driverClose() {
		driver.close();
	}

	@Test(dataProvider = "loginData")
	void loginPage(String userName, String password) {
		driver.get("https://opensource-demo.orangehrmlive.com/");
		WebElement userElement = driver.findElement(By.xpath("//input[@id=\"txtUsername\"]"));
		userElement.sendKeys(userName);
		WebElement passwordElement = driver.findElement(By.xpath("//input[@type=\"password\"]"));
		passwordElement.sendKeys(password);
		WebElement loginElement = driver.findElement(By.xpath("//input[@id=\"btnLogin\"]"));
		loginElement.click();
	}
}
