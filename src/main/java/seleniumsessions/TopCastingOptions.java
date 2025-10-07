package seleniumsessions;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chromium.ChromiumDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class TopCastingOptions {

	public static void main(String[] args) {
		
//		Different Top Casting Options
		
//		1. Valid, Local only for chrome driver, not recommended
//		ChromeDriver driver = new ChromeDriver();
		
//		2. Valid , most recommended
//		WebDriver driver = new ChromeDriver();
		
//		3. Valid, recommended, only for remote/cloud/AWS execution
//		WebDriver driver = new RemoteWebDriver(null, null)
		
//      4. valid only for chrome, Edge driver, so not recomended
//		ChromiumDriver driver= new ChromeDriver();
//		driver = new ChromeDriver();
//		driver = new EdgeDriver();
//		driver = new FirefoxDriver(); Error
//		
//		5.valid, not recommended as you can access only two methods FE, FEs FindElements
//		SearchContext driver = new ChromeDriver();
//		driver.findElement(null);
//		driver.findElements(null);
//		driver.get(); Error
		
//		6. valid, not recommended as you can access only two methods FE, FEs FindElements
//		SearchContext driver = new RemoteWebDriver();
//		driver.findElement(null);
//		driver.findElements(null);
//		driver.get(); Error
		
				
	}

}
