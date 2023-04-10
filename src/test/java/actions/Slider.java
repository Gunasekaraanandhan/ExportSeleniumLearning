package actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Slider {
	
	@Test
	public void horizontalSlider() {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
        driver.get("https://jqueryui.com/slider/");
		driver.manage().window().maximize();
		driver.switchTo().frame(0);
	        
        WebElement slider =  driver.findElement(By.xpath("//div[@id='slider']/span"));
       
        Actions a = new Actions(driver);
        
        a.dragAndDropBy(slider, 200, 0).build().perform();
       
        
	}
	
	@Test
	public void verticalSlider() throws Exception {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
        driver.get("https://jqueryui.com/slider/#slider-vertical");
		driver.manage().window().maximize();
		driver.switchTo().frame(0);
		
		WebElement slider = driver.findElement(By.xpath("//div[@id='slider-vertical']/span"));
		 
		Actions a = new Actions(driver);
		Thread.sleep(3000);
		a.dragAndDropBy(slider, 0, 100).build().perform();
		
	}

}
