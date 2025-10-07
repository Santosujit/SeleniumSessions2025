package seleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class RightContextClick {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://swisnl.github.io/jQuery-contextMenu/demo.html");
		Actions act = new Actions(driver);
		act.contextClick(driver.findElement(By.xpath("//span[text()='right click me']"))).perform();
//		right click and contextclick, both are same
		List<WebElement> contextMenuOptions = driver.findElements(By.cssSelector("ul.context-menu-list span"));
		for (WebElement e : contextMenuOptions) {
			String text = e.getText();
			System.out.println(text);
			if (text.equals("Copy")) {
				e.click();
				break;
			}
		}

	}

}

;
