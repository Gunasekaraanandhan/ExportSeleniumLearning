package actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DragAndDrop {
	@Test
	public void drag() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://jqueryui.com/");
		driver.manage().window().maximize();
        driver.findElement(By.xpath("//a[contains(text(),'Droppable')]")).click();
        
        driver.switchTo().frame(0);
        
        WebElement source = driver.findElement(By.xpath("//div[@id='draggable']"));
        
        WebElement dest = driver.findElement(By.xpath("//div[@id='droppable']"));
        
        Actions a = new Actions(driver);
        
        a.dragAndDrop(source, dest).build().perform();
        
        
	}

}
