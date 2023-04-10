package selenium.learning;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Alerts {

	@Test
	public void infoAlertHandling() throws Exception {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("file:///D:/ExportSeleniumLearning/src/test/java/selenium/learning/HTML%20Files/Alerts.html");

		driver.findElement(By.xpath("//button[@onclick='alertFunction()']")).click();
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
		driver.quit();
	}

	@Test
	public void decisionMakingAlerts() throws Exception {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("file:///D:/ExportSeleniumLearning/src/test/java/selenium/learning/HTML%20Files/Alerts.html");

		driver.findElement(By.xpath("//button[@onclick='confirmFunction()']")).click();
		Thread.sleep(3000);
		String text = driver.switchTo().alert().getText();
				
		System.out.println("Alert Text is : "+text);
		driver.switchTo().alert().accept();//ok 
		//driver.switchTo().alert().dismiss();//cancel
		String actualResult = driver.findElement(By.xpath("//p[@id='confirmdemo']")).getText();
		System.out.println("The Actual Result is : "+actualResult);
		String expectedResult =  "You Clicked on OK5!";
		
/*		if(actualResult.equals(exceptedResult)) {
			System.out.println("The Testcase is Passed : "+expectedResult);
		}
		else
			System.out.println("The Testcase is Failed Because : "+expectedResult);
*/
		Assert.assertEquals(expectedResult, actualResult);
		driver.quit();
		
	}
	
	@Test
	
	public void  decisionHandling() throws Exception {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("file:///D:/ExportSeleniumLearning/src/test/java/selenium/learning/HTML%20Files/Alerts.html");

		driver.findElement(By.xpath("//button[@onclick='promptFunction()']")).click();
		Thread.sleep(3000);
		String text = driver.switchTo().alert().getText();
		System.out.println("Alert Text is : "+text);
		Thread.sleep(3000);
		driver.switchTo().alert().sendKeys("Guna");
		driver.switchTo().alert().accept();
		
		String actualResult = driver.findElement(By.xpath("//p[@id='promptdemo']")).getText();
		System.out.println("The Actual Result is : "+actualResult);
		String expectedResult = "Hello Guna! Welcome to Excel ITac..5";
		
/*		if(actualResult.equals(expectedResult)) {
			System.out.println("The Testcase is Passed : "+expectedResult);
		}
		else
			System.out.println("The Testcase is Failed Because : "+expectedResult);
*/
		Assert.assertEquals(expectedResult, actualResult);
		driver.quit();
	}
	
}
