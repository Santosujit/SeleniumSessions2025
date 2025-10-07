package seleniumsessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class QuitVsClose {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com/");
//		driver.quit();
		driver.close();
		System.out.println(driver.getTitle());// org.openqa.selenium.NoSuchSessionException: Session ID is null. Using
												// WebDriver after calling quit()? for quit

//		org.openqa.selenium.NoSuchSessionException: invalid session id for close()

	}

}
