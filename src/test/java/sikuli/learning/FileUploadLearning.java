package sikuli.learning;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FileUploadLearning {

	WebDriver driver = null;

	@BeforeMethod
	public void launchBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

	}

	@Test
	public void fileUploadingOperation() {
		try {

			driver.get("https://the-internet.herokuapp.com/upload ");

			String sourcePath = "D:\\ExportSeleniumLearning\\sikuliimages\\";

			Screen screen = new Screen();

			Pattern p1 = new Pattern(sourcePath + "choosefile.png");
			screen.find(p1);
			screen.click(p1);
			Thread.sleep(2000);
			
			Pattern p2 = new Pattern(sourcePath+"download.png");
			screen.find(p2);
			screen.doubleClick(p2);
			Thread.sleep(2000);
			
			Pattern p3 = new Pattern(sourcePath + "logfile.png");
			screen.find(p3);
			screen.click(p3);
			Thread.sleep(2000);

			
			Pattern p4 = new Pattern(sourcePath+"open.png");
			screen.find(p4);
			screen.click(p4);
			Thread.sleep(2000);

			
			Pattern p5 = new Pattern(sourcePath+"upload.png");
			screen.find(p5);
			screen.click(p5);
			Thread.sleep(2000);

			

		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	@AfterMethod
	public void closeBrowser() {
		 driver.quit();
	}
}
