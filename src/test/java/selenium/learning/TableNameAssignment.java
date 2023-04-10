package selenium.learning;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TableNameAssignment {

	@Test
	public void tableNameData() {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://datatables.net/examples/basic_init/zero_configuration.html");

		WebElement table = driver.findElement(By.xpath("//table[@id='example']"));
		// System.out.println(table.getText());

		List<WebElement> tableRows = table.findElements(By.tagName("tr"));

		int i = 0;
		for (WebElement eachRows : tableRows) {
			if (i == 0) {
				WebElement name = eachRows.findElement(By.xpath("//table[@id='example']//th[1]"));
				System.out.println(name.getText() + " :");
			}
			i++;

			if (i == 1) {
				System.out.println("-----------------------");
				List<WebElement> tableNameData = eachRows.findElements(By.xpath("//table[@id='example']//td[1]"));
				for (WebElement eachNameData : tableNameData) {
					System.out.println(eachNameData.getText());
				}
			}
		}
		driver.close();
	}

}
