package selenium.learning;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDownHandling {

	@Test

	public void dropDownHandling() throws Exception {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("file:///D:/ExportSeleniumLearning/src/test/java/selenium/learning/HTML%20Files/DropDown.html");
		WebElement element = driver.findElement(By.id("cars"));
		Select dd = new Select(element);
		Thread.sleep(3000);
		// dd.selectByIndex(1);
		dd.selectByVisibleText("Audi");
		Thread.sleep(3000);
		// dd.selectByIndex(3);
		dd.selectByValue("maruthi");
		
		List<WebElement> list = dd.getOptions();	
		
		for(WebElement options : list) {
		
			System.out.println(options.getText()+"="+options.isSelected());
			
		}

		Thread.sleep(3000);
		driver.close();
	}
	@Test
	public void multiSelectDropDownHandling() throws Exception  {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("file:///D:/ExportSeleniumLearning/src/test/java/selenium/learning/HTML%20Files/DropDown.html");
		WebElement element = driver.findElement(By.name("carss"));
		Select dd = new Select(element);
		Thread.sleep(3000);
    
		dd.selectByIndex(1);
		dd.selectByVisibleText("Audi");
		Thread.sleep(3000);
	    dd.selectByIndex(2);
		dd.selectByValue("maruthi");
		
		List<WebElement> list = dd.getOptions();	
		
		for(WebElement options : list) {
		
  			System.out.println(options.getText()+"="+options.isSelected());
			
		}

		Thread.sleep(3000);
		driver.close();
		
	}

}
