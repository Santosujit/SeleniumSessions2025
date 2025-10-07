package seleniumsessions;

import org.openqa.selenium.HasAuthentication;
import org.openqa.selenium.Keys;
import org.openqa.selenium.UsernameAndPassword;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

//Later we will see Notification pop up, Location Pop up, Advertisement Pop up etc - Do Research on these topics

public class BasicAuthPopUp {

	public static void main(String[] args) {

		String username = "admin";
		String password = "admin";

//		In the URL, you have to pass your username and password

		WebDriver driver = new ChromeDriver();
		// driver.get("https://"+username + ":" + password + "@"
		// +"the-internet.herokuapp.com/basic_auth");

		// Auth pop ups are not JS alerts
		// can not switch to auth pop ups

//		In Selenium 3.X, If username or password is like admin@123, It used to not work
//		So in Selenium 4.X, They created a new Interface HasAuthenticated

		// Selenium 4.x: HasAuthenticated:
		// only for chromiumdriver: chrome/edge
		((HasAuthentication) driver).register(() -> new UsernameAndPassword(username, password));
		driver.get("https://the-internet.herokuapp.com/basic_auth");

		// AutoIT/Robot Class/Sikuli: They work only on windows os,
		// AutoIT/Robot Class/Sikuli doesn't work on following:
		// linux/mac/headless/cloud/grid/aws/CICD/jenkins

//		//recaptcha:
		// 1. no automation is possible with Captcha
		// 2. QA/Dev/Stage: disable captcha
		// 3. hard code the captcha value in QA/dev. Like 1+1=2 Capcta.
//		hardcode them in Lower Env
//		Captcha are developed mostly by Google
//		Selenium can't automate two-factor authentication
//		Two factor authentication, Dev has to disable this

//		Dev sometimes give 2-factor authnetication API, Dev 'll give the this API's response, you have to enter
//		ther response to automate two factor authentication

//		Lifecycle of a Toast Message is very less, in seconds. Within seconds you can automate Toast Message.
//		Naveen 'll tell How to Toast Message

	}

}
