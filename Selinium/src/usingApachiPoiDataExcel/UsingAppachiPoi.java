package usingApachiPoiDataExcel;

import java.util.List;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

//import com.google.common.collect.Table.Cell;

//HSSF=97-2003 excel using HSSF
//Horible Spreadheet Format
//XSSF = Latest ExcelWorkbook 

public class UsingAppachiPoi {
	// XML Spreadsheet Format
	static List<String> userNameList = new ArrayList<String>();
	static List<String> passwordList = new ArrayList<String>();

	void readExcel() throws IOException {
		// readFile:-
		FileInputStream file = new FileInputStream("F:\\Selenium dataProvider\\logindata1.xlsx");

		// this method using XSSF of WorkBook
		Workbook workbook = new XSSFWorkbook(file);

		// sheet method to get the excel
		Sheet sheet = workbook.getSheetAt(0);

		// using iterator function to get sheet of the excel all data
		// **Important** iterator is a row function of the selenium first get the row of
		// the cursor;
		Iterator<Row> row = sheet.iterator();

		// using has next() sheet of the excel data for the row
		while (row.hasNext()) {
			Row row1 = row.next();
			// important now i call row1 is change to cell(column);
			Iterator<Cell> column = row1.cellIterator();
			int i = 1;
			while (column.hasNext()) {
				if (i % 2 != 0) {
					userNameList.add(column.next().toString());
				} else {
					passwordList.add(column.next().toString());
				}
				i++;
			}
		}
		System.out.println("username : " + userNameList);
		System.out.println("username : " + passwordList);
	}

	void loginCorrectPassword(String userName, String pasword) {
		System.setProperty("webdriver.chrome.driver", "C:program Files\\selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		WebElement userElement = driver.findElement(By.xpath("//input[@id=\"txtUsername\"]"));
		userElement.sendKeys(userName);
		WebElement passwordElement = driver.findElement(By.xpath("//input[@type=\"password\"]"));
		passwordElement.sendKeys(pasword);
		WebElement loginElement = driver.findElement(By.xpath("//input[@id=\"btnLogin\"]"));
		loginElement.click();
		driver.close();
	}

	void Executor() {
		for (int i = 0; i < userNameList.size(); i++) {
			loginCorrectPassword(userNameList.get(i), passwordList.get(i));
		}

	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		UsingAppachiPoi poi = new UsingAppachiPoi();
		poi.readExcel();
		poi.Executor();

	}

}
