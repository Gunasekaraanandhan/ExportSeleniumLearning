package actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MouseOver {

	@Test
	public void miouseOvering() throws Exception {
		
	WebDriverManager.chromedriver().setup();
	WebDriver driver = new ChromeDriver();
    driver.get("https://rightstartmath.com/");
	driver.manage().window().maximize();
	
	WebElement ele = driver.findElement(By.xpath("//span[contains(text(),'Curriculum')]"));
	
	Actions a = new Actions(driver);
	
	a.moveToElement(ele).build().perform();
	
	Thread.sleep(3000);
	
	driver.findElement(By.xpath("//span[contains(text(),'Research')]")).click();
	}
}
