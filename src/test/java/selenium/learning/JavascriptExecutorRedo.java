package selenium.learning;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JavascriptExecutorRedo {

	WebDriver driver = null;

	@BeforeMethod
	public void launchBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}

	@Test
	public void jsExeceutor() {

		try {
			driver.get("https://www.google.com");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.manage().window().maximize();

			JavascriptExecutor js = (JavascriptExecutor) driver;

			// Add value to the TextBox
			WebElement search = driver.findElement(By.name("q"));

			js.executeScript("arguments[0].value='javasriptexecutor';", search);

			// reload a page
			js.executeScript("location.reload()");

			// print tittle
			System.out.println(js.executeScript("return document.title").toString());

			// click
			WebElement gmail = driver.findElement(By.linkText("Gmail"));
			js.executeScript("arguments[0].click()", gmail);

			// scroll down(Vertical scroll)
			js.executeScript("window.scrollBy(0,800)");

			// scroll up(Vertical scroll)
			js.executeScript("window.scrollBy(0,-400)");

			// Scroll into view of web element
			WebElement work = driver.findElement(By.linkText("For work"));
			js.executeScript("arguments[0].scrollIntoView(true);", work);

			// print tittle
			System.out.println(js.executeScript("return document.title").toString());
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}

	}

	@AfterMethod
	public void closeBrowser() {
		driver.quit();
	}

}
