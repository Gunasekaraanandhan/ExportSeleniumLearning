package selenium.learning;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScreenShotLearning {
	
	WebDriver driver = null;
	
	@BeforeMethod
	public void launchBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}
	
	@Test
	public void screenshotLearn() {
		
		driver.get("https://www.google.com");
		
		//take screenshot and return as a file
		File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		//destination path for the file to get store
		File dest = new File("C:\\Users\\pc\\OneDrive\\Desktop\\screenshot\\google.png");
		
		//copying the file from source to destination
		try {
			FileUtils.copyFile(source, dest);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void screenshot1() {
		driver.get("https://www.google.com");
		driver.findElement(By.name("q")).sendKeys("Selenium Learning \n");
		
		File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		File dest = new File ("./photo/google.png");
		
		try {
			FileUtils.copyFile(source, dest);
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		
	}
	
	@AfterMethod
	public void closeBrowser() {
		driver.quit();
	}

}
