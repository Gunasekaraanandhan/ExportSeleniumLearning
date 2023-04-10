package selenium.learning;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import java.util.*;
import java.net.MalformedURLException;
import java.net.URL;
public class LoginTestCaseHDFCTest {
  private WebDriver driver;
  private Map<String, Object> vars;
  JavascriptExecutor js;
  
  public void setUp() {
    driver = new ChromeDriver();
    js = (JavascriptExecutor) driver;
    vars = new HashMap<String, Object>();
  }
 
  public void tearDown() {
    driver.quit();
  }
  @Test
  public void loginTestCaseHDFC() {
    driver.get("https://netbanking.hdfcbank.com/netbanking/");
    driver.manage().window().setSize(new Dimension(1050, 708));
    driver.switchTo().frame(0);
    driver.findElement(By.name("fldLoginUserId")).sendKeys("1234566789");
    driver.findElement(By.linkText("CONTINUE")).click();
    driver.switchTo().defaultContent();
    driver.findElement(By.id("keyboard")).sendKeys("123456");
    driver.findElement(By.id("loginBtn")).click();
    driver.close();
  }
}
