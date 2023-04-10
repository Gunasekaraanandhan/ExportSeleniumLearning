package testNGLearnNew;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExcelDataprovider {
	
	WebDriver driver;

	@DataProvider(name = "excelData")
	public Object[][] getExcelData() throws IOException {

		Object[][] data = excelReading(System.getProperty("user.dir") + "/excel/Learningtitles.xlsx", "learning");

		return data;

	}

	private Object[][] excelReading(String excelPath, String sheetName) throws IOException {

		Object[][] excelData = null;
		XSSFWorkbook workbook=null;
		try {

			workbook = new XSSFWorkbook(excelPath);
			XSSFSheet worksheet = workbook.getSheet(sheetName);
			XSSFRow row = worksheet.getRow(0);

			// It will return the no. of physical rows in the sheet
			int noOfRows = worksheet.getPhysicalNumberOfRows();

			// to fetch the no. of columns
			int noOfColumns = row.getPhysicalNumberOfCells();
			
			//To create an Object array with row and column size
			excelData= new Object[noOfRows-1][noOfColumns];

			for (int i = 1; i < noOfRows; i++) {
				for (int j = 0; j < noOfColumns; j++) {
					String topic = worksheet.getRow(i).getCell(j).getStringCellValue();
					excelData[i - 1][j]= topic;
					// excelData[0][0]= selenium
					// excelData[0][1]=guvi
					// excelData[1][0]=Appium
					// excelData[1][1]=javaTpoint
					// excelData[2][0]=Java
					// excelData[2][1]=guru99
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		finally
		{
			workbook.close();
		}
		return excelData;
	}
	
	
	@BeforeMethod
	public void launchBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}
	
	
	@Test (dataProvider="excelData")
	public void verifyTitle(String topic, String website) {
		
		driver.get("https://www.google.com");
		String expectedTitle="Google";
		Assert.assertEquals(driver.getTitle(), expectedTitle);
		
		driver.findElement(By.name("q")).sendKeys(topic+" "+website+ "\n");
		
	}
	
	
	
	
	@AfterMethod
	public void closeBrowser() {
		driver.quit();
		
	}

}
