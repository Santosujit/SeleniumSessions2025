package seleniumsessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MultiSessions {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();//session id =123
		driver = new ChromeDriver();//session id =456
		driver = new ChromeDriver();//session id =789
		// out of 3 browsers launched, this browser will be closed
		driver.quit();

	}

}
