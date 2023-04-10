package testng.learning;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GoogleAssessment {
	WebDriver driver;
	
  @BeforeMethod
  public void start() {
	  WebDriverManager.chromedriver().setup();
	    driver = new ChromeDriver();
	    driver.manage().window().maximize();
		driver.get("https://www.google.com/");
	    WebElement ele = driver.findElement(By.name("q"));
	    ele.sendKeys("Selenium \n");
  }

  @AfterMethod
  public void close() {
	  
	  driver.close();
	 // driver.quit();
  }

  @Test
  public void testCase1() {
	  
	  driver.findElement(By.xpath("//h3[text()='Selenium']")).click();
	  
  }
  
  @Test
  public void testCase2() {
	  
	  driver.findElement(By.linkText("Images")).click();
	 
  }
  
  @Test
  public void testCase3() {
	  
	  driver.findElement(By.linkText("News")).click();
	  
  }
}
