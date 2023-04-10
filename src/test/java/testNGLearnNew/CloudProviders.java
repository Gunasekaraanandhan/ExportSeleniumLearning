package testNGLearnNew;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CloudProviders {
	WebDriver driver;

	@BeforeMethod(alwaysRun = true)
	public void launchBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}

	@Test(invocationCount=4, threadPoolSize=4)
	public void browserStack() {
		driver.get("https://www.browserstack.com/");
	}

	@Test
	public void lambdaTest() {
		driver.get("https://www.lambdatest.com/");
	}

	@AfterMethod(alwaysRun = true)
	public void closeBrowser() {
		driver.quit();
	}

}
