package seleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

//Print all the Google Languages Link's Text and click on Punjabi

public class GoogleLanguageLinks {

	static WebDriver driver;

	public static void main(String[] args) {

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.co.in/");

		List<WebElement> langLinks = driver.findElements(By.xpath("//div[@id='SIvCob']/a"));
		for (WebElement e : langLinks) {
			String text = e.getText();
			System.out.println(text);
			if (text.contains("ਪੰਜਾਬੀ")) {
				e.click();
				break;
			}
		}

	}

}
