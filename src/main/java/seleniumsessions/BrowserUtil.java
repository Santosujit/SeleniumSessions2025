package seleniumsessions;

import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class BrowserUtil {

	WebDriver driver;// class level no need to initilise with NULL, bydefault it will take, but local
						// level you have to

	/**
	 * initDriver method will initialie the browser, opens the browser
	 * 
	 * @param browserName
	 * @return driver you can use later
	 */
	public WebDriver initDriver(String browserName) {

		System.out.println("Browser Name is " + browserName);
		switch (browserName.trim().toLowerCase()) {
		case "chrome":
			driver = new ChromeDriver();
			break;
		case "firefox":
			driver = new FirefoxDriver();
			break;
		case "edge":
			driver = new EdgeDriver();
			break;
		case "safari":
			driver = new SafariDriver();
			break;
		default:
			System.out.println("plz pass the right browser....");
			throw new BrowserException("====INVALID BROWSER=====");// this is throwing own custom Exception
		// break;
		}
		return driver;
	}

	public void launchURL(String url) {
		if (url.indexOf("http") != 0) {// http will always should start from 0th index of the URL
			throw new BrowserException("http(s) is missing in the URL...");
		}
		driver.get(url);
	}

	public String getPageTitle() {
		return driver.getTitle();
	}

	public String getPageURL() {
		return driver.getCurrentUrl();
	}

	public void quitBrowser() {
		driver.quit();

	}
}
