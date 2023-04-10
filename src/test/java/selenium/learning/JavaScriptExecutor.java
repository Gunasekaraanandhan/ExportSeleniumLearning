package selenium.learning;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JavaScriptExecutor {
	
	WebDriver driver = null;

	@BeforeMethod
	public void launchBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}
	
	@Test
	public void javascriptExecutor() {
		
		try {
			driver.get("https://www.google.com");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			
			JavascriptExecutor js = (JavascriptExecutor)driver;
			
			//passing text to text field without using sendkeys()
			WebElement ele = driver.findElement(By.name("q"));
			js.executeScript("arguments[0].value='Selenium Learning';", ele);
			
			//reload a page
			js.executeScript("location.reload()");
			
			WebElement ele1 = driver.findElement(By.name("q"));
			js.executeScript("arguments[0].value='Guvi';", ele1);
			
			//click on gmail link
			WebElement gmail = driver.findElement(By.linkText("Gmail"));
			
			js.executeScript("arguments[0].click()", gmail);
			
			//printing a tittle
			System.out.println(js.executeScript("return document.title").toString());
			
			//vertival scroll--scroll down
			js.executeScript("window.scrollBy(0,600)");
			
			Thread.sleep(3000);
			
			//scroll up
			js.executeScript("window.scrollBy(0,-400)");
			
			Thread.sleep(3000);
			
			//horizontal scroll
			//js.executeScript("window.scrollBy(300,0)");
			
			//Scroll into view of web element
			WebElement helpCentre = driver.findElement(By.linkText("Help Center"));
			js.executeScript("arguments[0].scrollIntoView(true);", helpCentre);
			Thread.sleep(2000);
			//helpCentre.click();
			js.executeScript("arguments[0].click()",helpCentre);
			
			Thread.sleep(3000);
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}
	
	
	@AfterMethod
	public void closeBrowser() {
		driver.quit();
	}

}
