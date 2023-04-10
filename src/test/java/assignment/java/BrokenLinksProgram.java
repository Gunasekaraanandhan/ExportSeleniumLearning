package assignment.java;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrokenLinksProgram {

	@Test
	public void brokenlinkFind() {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com");

	//	driver.findElement(By.name("q")).sendKeys("Selenium Learning \n");

		List<WebElement> links = driver.findElements(By.tagName("a"));

		System.out.println("Total Links : " + links.size());

		ArrayList<String> urlList = new ArrayList<String>();

		// To traverse to each link and fetch the link value using href attribute
		for (WebElement link : links) {
			String url = link.getAttribute("href");
			urlList.add(url);

			if (url == null || urlList.isEmpty()) {

				System.out.println("Invalid url");
				continue;

			}

			try {
				HttpURLConnection httpConnection = (HttpURLConnection) new URL(url).openConnection();
				httpConnection.connect();
				int respCode = httpConnection.getResponseCode();

				if (respCode >= 400) {
					System.out.println(url + " is broken and its responsecode is " + respCode);
				} else
					System.out.println(url + " is Valid and its responsecode is " + respCode);

			} catch (Exception ex) {
				ex.printStackTrace();
			}

		}

		driver.close();
	}
}
