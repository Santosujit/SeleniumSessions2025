package seleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSearch {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.co.in/");

		By SeacrhField = By.name("q");
		By suggestions = By.xpath("//ul[@class='G43f7e']/li//div[@class='wM6W7d']/span");

//		doSearch(SeacrhField, suggestions, "Selenium", "tutorial");
//		doSearch(SeacrhField, suggestions, "Naveen automation labs", "linkedin");
		ElementUtil eleUtil = new ElementUtil(driver);
//		eleUtil.doSearch(SeacrhField, suggestions, "acvacvwisisjsdgdfdfdfdfdfetetetetegdgdgdgfwrwrw", "test");
//		eleUtil.doSearch(SeacrhField, suggestions, "Selenium", "tutorial");
		eleUtil.doSearch(SeacrhField, suggestions, "Selenium", "cypress rocks");

//		By SeacrhField = By.name("q");
//		driver.findElement(SeacrhField).sendKeys("Selenium");
//		Thread.sleep(3000);
//
//		By suggestions = By.xpath("//ul[@class='G43f7e']/li//div[@class='wM6W7d']/span");
//		List<WebElement> suggestionsList = driver.findElements(suggestions);
//		for (WebElement e : suggestionsList) {
//			String text = e.getText();
//			System.out.println(text);
//			if (text.contains("tutorial")) {
//				e.click();
//				break;// break will never exits the condition, it exits the loop itself
//		}
//		}

	}

	public static void doSearch(By SeacrhField, By suggestions, String searchKey, String matckKey)
			throws InterruptedException {

		driver.findElement(SeacrhField).sendKeys(searchKey);
		Thread.sleep(3000);

		List<WebElement> suggestionsList = driver.findElements(suggestions);
		for (WebElement e : suggestionsList) {
			String text = e.getText();
			System.out.println(text);
			if (text.contains(matckKey)) {
				e.click();
				break;// break will never exits the condition, it exits the loop itself

			}

		}
	}
}
