package seleniumsessions;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PsuedoElementsHandle {

	public static void main(String[] args) {
		// Below are Psuedo Elements
		// ::before
		// ::after
		// ::has
		WebDriver driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");

		String script = "return window.getComputedStyle(document.querySelector('label[for=\"input-firstname\"]'), '::before').getPropertyValue('content')";
                         
		JavascriptExecutor js = (JavascriptExecutor) driver;

		String content = js.executeScript(script).toString();// js.executeScript(script) returns Javascript based text,
																// then toString() converts it into java based Text or
																// String
		System.out.println(content);

		if (content.contains("*")) {
			System.out.println("FN is mandatory field");
		}

	}

}

//window.getComputedStyle(document.querySelector('label[for=\"input-firstname\"]'), '::before').getPropertyValue('content')
//document.querySelector(Write the CSS Selector)
//getComputedStyle('Ele','Psueduo Element')