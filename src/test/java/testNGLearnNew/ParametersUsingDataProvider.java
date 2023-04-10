package testNGLearnNew;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ParametersUsingDataProvider {

	WebDriver driver;

	@BeforeMethod
	public void launchBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}

	// @Test (dataProvider="fechTestData")
	public void searchInGoogle(String urlName, String searchText) throws InterruptedException {
		driver.get(urlName);

		driver.findElement(By.name("q")).sendKeys(searchText + "\n");

		Thread.sleep(3000);
	}

	@Test(dataProvider = "newTestData")
	public void searchInGoogle(String searchText) throws InterruptedException {
		driver.get("https://www.google.com");

		driver.findElement(By.name("q")).sendKeys(searchText + "\n");

		Thread.sleep(3000);
	}

	@DataProvider(name = "fechTestData")
	public Object[][] testData() {
		// classname object = new classname;
		Object[][] data = null;

		data = new Object[][] { { "https://www.google.com", "Selenium Learning" },
				{ "https://www.google.com", "Appium Learning" },
				{ "https://www.google.com", "Selenium Learning in Guvi" }

		};

		return data;
	}

	@DataProvider
	public Object[][] newTestData() {

		Object[][] newData = null;

		newData = new Object[][] {

				{ "Selenium Learning" }, { "Rest Assured Learning" } };

		return newData;
	}

	@AfterMethod
	public void closeBrowser() {
		driver.quit();
	}

}
