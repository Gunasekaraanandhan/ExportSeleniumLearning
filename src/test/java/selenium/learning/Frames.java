package selenium.learning;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Frames {

	@Test
	public void singleFrame() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://demoqa.com/frames");
		driver.manage().window().maximize();
		
		//switching inside a frame
		driver.switchTo().frame("frame1");
		WebElement sampleText= driver.findElement(By.id("sampleHeading"));
		
		System.out.println("Sample Page Text : "+sampleText.getText());
		
		//printing the web page content so we need to back defaultcontent 
		driver.switchTo().defaultContent();	
		WebElement content = driver.findElement(By.xpath("//div[@id='framesWrapper']/div[1]"));
		
		System.out.println("Sample page Content : "+content.getText());
		
	}
	
	@Test
	public void nestedFrame() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/nestedframes");
		
		WebElement parentFrame = driver.findElement(By.id("frame1"));
		driver.switchTo().frame(parentFrame);
		WebElement parentText = driver.findElement(By.tagName("body"));
		System.out.println("Parent Frame Text : "+parentText.getText());
		
		int countOfFrame = driver.findElements(By.tagName("iframe")).size();
		System.out.println(countOfFrame);
		
		driver.switchTo().frame(0);
		
		WebElement childFrameText = driver.findElement(By.tagName("body"));
		System.out.println("Child Frame Text : "+childFrameText.getText());
		
		driver.switchTo().parentFrame();
		
		WebElement parentText1 = driver.findElement(By.tagName("body"));
		System.out.println("Parent Frame Text : "+parentText1.getText());
		
		driver.switchTo().defaultContent();
		
		WebElement text = driver.findElement(By.xpath("//div[@id='framesWrapper']/div[1]"));
		System.out.println("Content Text : "+text.getText());
 	}
}
