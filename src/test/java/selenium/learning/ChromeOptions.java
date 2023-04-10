package selenium.learning;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ChromeOptions {

   public void chrome() {
	   WebDriverManager.chromedriver().setup();
	   ChromeOptions co = new ChromeOptions();
	   co.addArguments("--remote-allow-orgin-");
   }

private void addArguments(String string) {
	// TODO Auto-generated method stub
	
}
	
	
}
