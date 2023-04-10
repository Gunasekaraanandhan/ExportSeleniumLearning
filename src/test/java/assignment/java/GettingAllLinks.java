package assignment.java;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GettingAllLinks {

	@Test
	public void seleniumLearningLinks() {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com");

		driver.findElement(By.name("q")).sendKeys("Selenium Learning \n");

		List<WebElement> links = driver.findElements(By.tagName("a"));

		System.out.println("Total Links : " + links.size());

		ArrayList<String> totalLink = new ArrayList<String>();
		
		for (WebElement link : links) {
			
			String url = link.getAttribute("href");
			totalLink.add(url);

			if (url == null) {

				// System.out.println("===========================================================================");
				// System.out.println("Invalid link");
				continue;
				
			}
			System.out.println("===========================================================================");
			System.out.println(url);

		}
		System.out.println("===========================================================================");

		driver.close();
	}

}
