package selenium.learning;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CssEX {
	
	WebDriver driver = null;

	@BeforeMethod
	public void launchBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}
	
	@Test
	public void cssSelectors()
	{
		/*
		Tag and ID---->	tag#id--->input#email
		Tag and Class--->	tag.class---->input.inputtext
		Tag and Attribute--->	tag[attribute=value]---->	css=input[name=lastName]
		Tag, Class, and Attribute---->	tag.class[attribute=value]---->	css=input.inputtext[tabindex=1]
		
		*/
		driver.get("https://www.facebook.com/");
		//tag and id this locator
		driver.findElement(By.cssSelector("input#email")).sendKeys("Test@gmail.com");
		//tag and attripute value this locator
		driver.findElement(By.cssSelector("input[name='pass']")).sendKeys("gfadghdhjsjhd");
	
		
	}
	
	
	
	
	@AfterMethod
	public void closeBrowser() {
		driver.quit();
	}


}
