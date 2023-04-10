package testng.learning;



import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PropertiesLearningMySelf {
	
	
	@Test
	
	public void propertiesFileLearning() throws IOException {
		//project path
		System.out.println(System.getProperty("user.dir"));
		//property file path
		FileInputStream fp = new FileInputStream(System.getProperty("user.dir")+"//config.properties");
		
		Properties p = new Properties();
		p.load(fp);
		
		//String browser = (String) p.get("browser");
		String browser = p.getProperty("browser");
		WebDriver driver;
		if(browser.contentEquals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.get(p.getProperty("url"));
		//	above line also write like this
		//	String url = p.getProperty("url");
		//	driver.get(url);
		
		}
		else if(browser.contentEquals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver= new FirefoxDriver();
			driver.get(p.getProperty("url"));
			
		}
	
		//driver.get(p.getProperty("url"));
		
		
		
		
	}

}
