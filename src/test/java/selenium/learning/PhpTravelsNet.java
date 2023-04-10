package selenium.learning;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PhpTravelsNet {

	@Test

	public void search() throws Exception {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://phptravels.net/");

		WebElement ele = driver.findElement(By.id("select2-hotels_city-container"));
		ele.click();
		ele = driver.findElement(By.xpath("//input[@role='searchbox']"));
		ele.sendKeys("chenn");

		Thread.sleep(5000);
		driver.findElement(By.xpath("//li[@aria-selected='false']")).click();

	}

	@Test

	public void datePickHandling() {

		String monthYear = "December 2023";
		String day = "23";
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://phptravels.net/");

		WebElement ele = driver.findElement(By.id("checkin"));
		ele.click();

	//	String currentMonth = driver.findElement(By.xpath("(//div[@class='datepicker-days']/table)[1]//thead//tr//th[@class='switch']")).getText();
		String currentMonth = driver.findElement(By.xpath("(//div[@class='datepicker-days'])[1]//th[@class='switch']")).getText();
		System.out.println(currentMonth);

	//	WebElement next = driver.findElement(By.xpath("(//div[@class='datepicker-days']/table)[1]//thead//tr//th[@class='next']"));
		WebElement next = driver.findElement(By.xpath("(//div[@class='datepicker-days'])[1]//th[@class='next']"));

		while (true) {

			System.out.println("---------------");
			System.out.println(monthYear);
			System.out.println(currentMonth);
			if (monthYear.equals(currentMonth)) {

				break;
			} else 
				next.click();
				 //currentMonth = driver.findElement(By.xpath("(//div[@class='datepicker-days']/table)[1]//thead//tr//th[@class='switch']")).getText();
		     	 currentMonth = driver.findElement(By.xpath("(//div[@class='datepicker-days'])[1]//th[@class='switch']")).getText();
		}
	//	WebElement dayToClick = driver.findElement(By.xpath("(//div[@class='datepicker-days']/table)[1]//tr/td[contains(text(),"+day+")]"));

		WebElement dayToClick = driver.findElement(By.xpath("(//div[@class='datepicker-days'])[1]//td[contains(text(),"+day+")]"));
		dayToClick.click();
	}
}
