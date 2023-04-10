package sikuli.learning;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SikuliPratice {
	
	WebDriver driver = null;

	@BeforeMethod
	public void launchBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

	}
	@Test
	public void sikuliPratice() {
		
		try {
		driver.get("https://www.guvi.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		String sourcePath = "D:\\ExportSeleniumLearning\\sikuliimages\\";
		Screen screen = new Screen();
		
		Pattern p1 = new Pattern(sourcePath + "login.png");
		//screen.click(p1);
		
		screen.rightClick(p1);
		Thread.sleep(2000);

		/*
		Pattern p2 = new Pattern(sourcePath + "email.png");
		screen.find(p2);
		screen.click(p2);
		screen.type(p2, "testing@gmail.com");
		
		Pattern p3 = new Pattern(sourcePath+"password.png");
		screen.find(p3);
		screen.click(p3);
		screen.type(p3, "123456");
		
		Pattern p4 = new Pattern(sourcePath+"login1.png");
		screen.click(p4);
		*/
		
		
			
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		
	}
	
	@AfterMethod
	public void closeBrowser() {
		// driver.quit();
	}

}
