package selenium.learning;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumFirstLearning {

	@Test
	
	public void sel() {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.google.com");
		
	//    driver.findElement(By.name("q")).sendKeys("Java \n");	
	//line no:22 also same 24 & 26    
	    WebElement element =  driver.findElement(By.name("q"));
	    
	    element.sendKeys("Hello Motto \n");
	    
	    driver.findElement(By.linkText("Videos")).click();
	    
	    
	  
	}
	
	@Test
	public void myHTML() {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("file:///D:/ExportSeleniumLearning/src/test/java/selenium/learning/HTML%20Files/StudentRegistration.html");
		driver.findElement(By.name("fname")).sendKeys("Guna");
		driver.findElement(By.name("lname")).sendKeys("sekar");
		
		driver.findElement(By.id("vehicle1")).click();
		driver.findElement(By.id("vehicle2")).click();
		driver.findElement(By.id("vehicle3")).click();
		
		driver.findElement(By.id("html")).click();
		driver.findElement(By.id("age2")).click();
		
		
	}
	
	@Test
	
	public void sauceDemo() {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.saucedemo.com/");
		WebElement element = driver.findElement(By.id("user-name"));
		element.sendKeys("standard_user");
		element = driver.findElement(By.id("password"));
		element.sendKeys("secret_sauce");
		
		element = driver.findElement(By.id("login-button"));
		element.click();
		
		element = driver.findElement(By.linkText("Sauce Labs Bike Light"));
		element.click();
		
		element = driver.findElement(By.name("add-to-cart-sauce-labs-bike-light"));
		element.click();
		
		element = driver.findElement(By.className("shopping_cart_link"));
		element.click();
		
		driver.findElement(By.id("continue-shopping")).click();
		driver.findElement(By.linkText("Sauce Labs Bolt T-Shirt")).click();
		driver.findElement(By.name("add-to-cart-sauce-labs-bolt-t-shirt")).click();
		driver.findElement(By.className("shopping_cart_badge")).click();
		driver.findElement(By.id("checkout")).click();
		driver.findElement(By.id("first-name")).sendKeys("Guna");
		driver.findElement(By.id("last-name")).sendKeys("Sekar");
		driver.findElement(By.id("postal-code")).sendKeys("606303");
		driver.findElement(By.id("continue")).click();
		driver.findElement(By.id("finish")).click();
		
	}

}

