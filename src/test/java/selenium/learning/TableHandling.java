package selenium.learning;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TableHandling {

	@Test

	public void tableHandling() {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
		driver.get("https://datatables.net/examples/basic_init/zero_configuration.html");

		WebElement table = driver.findElement(By.xpath("//table[@id='example']"));
		System.out.println(table.getSize());
		//System.out.println(table.getText());
		List<WebElement> tableRows = table.findElements(By.tagName("tr"));
		System.out.println(tableRows.size());
		int i = 0;

		for (WebElement eachRows : tableRows) {
			if (i == 0) {
				List<WebElement> header = eachRows.findElements(By.tagName("th"));
				for (WebElement tabHeader : header) {
					System.out.print(tabHeader.getText() + "\t" + "\t"+"\t");
				}
				System.out.println();
				i++;
			}
			if (i == 1) {

				List<WebElement> tableData = eachRows.findElements(By.tagName("td"));

				for(WebElement eachTableData:tableData) {
					System.out.print(eachTableData.getText()+"\t"+"\t");
				}
				System.out.println();
			}
		}

		driver.close();
	}
	
}
