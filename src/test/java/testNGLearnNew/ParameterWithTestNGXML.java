package testNGLearnNew;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ParameterWithTestNGXML {

	WebDriver driver;
	
	@BeforeMethod
	public void launchBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}

	@Test
	@Parameters({"url","searchTerm"})
	public void search(String urlName, String searchText) throws InterruptedException {

		driver.get(urlName);
		
		driver.findElement(By.name("q")).sendKeys(searchText+"\n");
		
		Thread.sleep(3000);

	}
	@AfterMethod
	public void closeBrowser() {
		driver.quit();
	}
}
