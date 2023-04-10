package selenium.learning;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AlertsHandling {
	
	@Test
	
	public void alertsHandling() {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("file:///D:/ExportSeleniumLearning/src/test/java/selenium/learning/HTML%20Files/Alerts.html");
		
		
		
	}

}
