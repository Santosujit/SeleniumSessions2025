package seleniumsessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowMaximizeMinimize {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();// method chaining
//		driver.manage().window().fullscreen();// it's used in TV, or Monitor
		driver.get("https://www.google.com/");
		driver.manage().window().minimize();// once window is minimized, you can't interact with the window, you have to
											// miximize the window again
		driver.manage().window().maximize();

//		viewport ---window size ---responsiveness testing

	}

}
