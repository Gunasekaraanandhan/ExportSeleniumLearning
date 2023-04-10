package testng.learning;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PropertiesLearning {
	@Test
	public void propertiesLearning() throws IOException {
		
		System.out.println(System.getProperty("user.dir"));
		FileInputStream fp= new FileInputStream(System.getProperty("user.dir")+"//config.properties");
		
		
		//double  a = 10 ;
		//int b =(int) a;
		
		Properties prop = new Properties();
		prop.load(fp);
		
		String browser = (String) prop.get("browser");
		WebDriver driver;
		
		if(browser.contentEquals("chrome")) {
			WebDriverManager.chromedriver().setup();
		}
		else if(browser.contentEquals("firefox")) {
			// fire
		}
	
		
		
		
		
		
	}

}
