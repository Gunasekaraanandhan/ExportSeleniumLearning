package testNGLearnNew;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestngAssertion {

	WebDriver driver;
	
	@BeforeMethod(alwaysRun=true)
	public void launchBrowser()
	{
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
	}
	
	
	@Test
	public void verifyTitleUsingAssertEquals()
	{
		
		driver.get("https://www.google.com");
		
		String expectedTitle="Google1";
		
		Assert.assertEquals(driver.getTitle(), expectedTitle);
		
		driver.findElement(By.name("q")).sendKeys("Guvi Learning \n");

	}
	
	@Test
	public void verifyTitleUsingAssertNotEquals()
	{
		
		driver.get("https://www.google.com");
		
		String expectedTitle="Google";
		
		Assert.assertNotEquals(driver.getTitle(), expectedTitle);
		
		driver.findElement(By.name("q")).sendKeys("Guvi Learning \n");
	}
	
	@Test
	public void verifyTitleUsingAssertTrue()
	{
		
		driver.get("https://www.google.com");
		
		String expectedTitle="Google";
		
	//	Assert.assertTrue(driver.getTitle().equalsIgnoreCase(expectedTitle));		
		Assert.assertTrue(driver.getTitle().equals(expectedTitle));
		driver.findElement(By.name("q")).sendKeys("Guvi Learning \n");
	}
	
	@Test
	public void verifyTitleUsingAssertFalse()
	{
		
		driver.get("https://www.google.com");
		
		String expectedTitle="Google";
		
		Assert.assertFalse(driver.getTitle().equalsIgnoreCase(expectedTitle));
		Assert.assertFalse(driver.getTitle().equals(expectedTitle));
		driver.findElement(By.name("q")).sendKeys("Guvi Learning \n");
	}
	
	
	@AfterMethod(alwaysRun=true)
	public void closeBrowser()
	{
		driver.quit();
	}
	
}

