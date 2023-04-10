package selenium.learning;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SwithWindowLearning {

	@Test
	public void loginPage()  {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("file:///D:/ExportSeleniumLearning/src/test/java/selenium/learning/HTML%20Files/LoginPage.html");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
//		driver.findElement(By.name("uname")).sendKeys("Gunasekar");
//		driver.findElement(By.name("psw")).sendKeys("12345");
		
		String pWindow = driver.getWindowHandle();
		driver.findElement(By.xpath("//a[contains(text(),'Reset Password')]")).click();
		
		//getWindowHandle() > Address of the current open window
		//getWindowHandles() > set of all open window address
		
		Set<String> windowHandle = driver.getWindowHandles();
		
		for(String adr : windowHandle) {
			
			if(!(pWindow.contentEquals(adr))) {
				driver.switchTo().window(adr);
			}
			System.out.println(adr);
		}
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Guna");
		driver.findElement(By.name("psw")).sendKeys("67890");
		
		driver.close();
		driver.switchTo().window(pWindow);
		
		driver.findElement(By.name("uname")).sendKeys("Gunasekar");
		driver.findElement(By.name("psw")).sendKeys("12345");
		
		
		
	}
}
