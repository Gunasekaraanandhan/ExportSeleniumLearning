package testNGLearnNew;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GroupsSocial {

	WebDriver driver;

	@BeforeMethod(alwaysRun = true)
	public void launchBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}

	@Test(groups = { "regression" })
	public void facebook() {

		driver.get("https://www.facebook.com/");

	}

	@Test(groups = { "regression", "sanity" })
	public void twitter() {
		driver.get("https://www.twitter.com/");
	}

	@AfterMethod(alwaysRun = true)
	public void closeBrowser() {
		driver.quit();
	}

}
