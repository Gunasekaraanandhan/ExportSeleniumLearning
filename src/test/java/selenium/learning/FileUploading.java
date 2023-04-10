package selenium.learning;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FileUploading {

	WebDriver driver = null;

	@BeforeMethod
	public void launchBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}

	@Test
	public void fileUpload() {

		try {
			driver.get("https://the-internet.herokuapp.com/upload");

			// we can use double backward slash (\\) or single forward slash (/) to find
			// path
			driver.findElement(By.id("file-upload")).sendKeys("C:\\Users\\pc\\Downloads\\SikuliXSetupLog.txt");

			driver.findElement(By.id("file-submit")).click();

			if (driver.getPageSource().contains("File Uploaded")) {
				System.out.println("File Uploaded successfully");
			} else {
				System.out.println("Problem  in uploading File");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	@Test
	public void fileUploadEx() {
		try {
			driver.get("https://the-internet.herokuapp.com/upload");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			driver.findElement(By.id("file-upload")).sendKeys("C:\\Users\\pc\\Downloads\\M3.jpg");

			driver.findElement(By.id("file-submit")).click();

			if (driver.getPageSource().contains("File Uploaded")) {
				System.out.println("File Upload Successfully ");
			} else
				System.out.println("Problem in Uploading File ");
		}

		catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@AfterMethod
	public void closeBrowser() {
		driver.quit();
	}

}
