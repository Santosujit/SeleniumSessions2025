package seleniumsessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigationMethods {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		System.out.println(driver.getTitle());
		Thread.sleep(1000);// Thread is a class, sleep() is a method
		driver.navigate().to("https://www.amazon.com/");
		System.out.println(driver.getTitle());
		Thread.sleep(1000);
		driver.navigate().back();
		System.out.println(driver.getTitle());
		Thread.sleep(1000);
		driver.navigate().forward();
		System.out.println(driver.getTitle());
		Thread.sleep(1000);
		driver.navigate().back();
		System.out.println(driver.getTitle());
		driver.quit();

//		to() method internally calls get() method, only diff is to() method is overloaded

		driver.navigate().refresh();// very rare case of this method, very dangerous
		// session Id will be same but DOM 'll be reloaded
		// so you may get staleElementException

	}

}
