package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileUploadPopUp {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.get("https://cgi-lib.berkeley.edu/ex/fup.html");

		// type=file -- this is mandatory, tag can be anything input/div.
		// If type is not equal to file, then you can't automate that scenario, you have
		// to ask your Den to change to type=file

		WebElement chooseFile = driver.findElement(By.name("upfile"));

		chooseFile.sendKeys("/Users/naveenautomationlabs/Documents/naveen.html");// you are passing the full path of the
																					// file you want to upload

//		AD or Promotional Pop ups come in Prod Env randomly, based on location, offers going on, on random time, so can't be automated
//		They don't come on QA/Staging Env
//		We don't automate the Prod App, we only may do Smoke or Sanity Testing prpd App
//		Browser window pop up - That 'll be covered on window handling session
//		Location pop up and Notification pop up are not JS pop up
//		Location pop up and Notification pop up are handled by ChromeOptions Class
//		Captcha can't be automated, as Captcha are created to prevent automation or BOT

	}

}