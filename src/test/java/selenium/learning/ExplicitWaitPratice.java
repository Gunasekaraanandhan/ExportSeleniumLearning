package selenium.learning;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExplicitWaitPratice {
	
	WebDriver driver = null;

	@BeforeMethod
	public void launchBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}
	
	@Test
	public void explicitWait() {
		
		driver.get("https://www.google.com");
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.name("q")));
		
		driver.findElement(By.name("q")).sendKeys("Selenium Learning");
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@value='Google Search'])[2]")));
		
		driver.findElement(By.xpath("(//input[@value='Google Search'])[2]")).click();
		
	}
	
	
	
	@AfterMethod
	public void closeBrowser() {
		driver.quit();
	}

}
