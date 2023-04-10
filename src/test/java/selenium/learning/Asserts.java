package selenium.learning;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Asserts {

	
	@Test

	public void tc1() {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("file:///D:/ExportSeleniumLearning/src/test/java/selenium/learning/HTML%20Files/StudentRegistration.html");
		WebElement ele = driver.findElement(By.name("lname"));
		// Assert.assertTrue(ele.isDisplayed());
		Assert.assertTrue(ele.isEnabled());

	}

	@Test

	public void tc2() {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("file:///D:/ExportSeleniumLearning/src/test/java/selenium/learning/HTML%20Files/StudentRegistration.html");

		WebElement ele = driver.findElement(By.id("vehicle1"));
		Assert.assertTrue(ele.isEnabled());
		Assert.assertTrue(ele.isDisplayed());
		
		WebElement ele1 = driver.findElement(By.id("age1"));
		Assert.assertTrue(ele1.isEnabled());
		
	}
	@Test
	public void followingAndPreceding() {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("file:///D:/ExportSeleniumLearning/src/test/java/selenium/learning/HTML%20Files/StudentRegistration.html");
		WebElement ele = driver.findElement(By.xpath("//input[@id='fname']//following::input[1]"));
		ele.sendKeys("Sekar");
	    ele = driver.findElement(By.xpath("//input[@id='lname']//preceding::input[1]"));
		ele.sendKeys("Guna");
	}

}
