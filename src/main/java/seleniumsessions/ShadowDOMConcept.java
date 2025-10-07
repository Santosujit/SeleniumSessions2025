package seleniumsessions;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ShadowDOMConcept {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.get("https://selectorshub.com/iframe-in-shadow-dom/");

		Thread.sleep(4000);

		// Browser --Page --> Shadow DOM --> Shadow DOM --> input#pizza; //There are two
		// shadow doms, one inside another
		// Browser --Page --> iframe --> Shadow DOM --> Shadow DOM --> input#pizza;

		// Using JSPath
		// How to JS Path -> Right click on the HTML Element in DOM -> Copy -> Copy JS
		// Path
		//
		// Selenium doesn't understand HTML Element, It understands WebElement
		// where lots of JSPath is involved, Selenium is not the preferred Automation
		// Tool, Playwright is preferred.

		String jsPath = "return document.querySelector(\"#userName\").shadowRoot.querySelector(\"#app2\").shadowRoot.querySelector(\"#pizza\")";
		// we just added return statement after copying JS Path
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement pizza = (WebElement) js.executeScript(jsPath);// htmlelement --> WebElement

		pizza.sendKeys("Veg Pizza");

		// shadow DOM:
		// xpath is not supported
		// only CSS with JSPath is supported
		// shadow-root (open) --> You can automate
		// shadow-root (close) -> You can't automate

//		SVG Element -> You have to use special Xpath
//		Parent -> local-name()
//		Child -> g or path -> name() or local-name()

//		iFrames and ShadowDOM, UI Developers create to give more security to elements inside it.
//		ShadowElement are light weight container, so performance improves, they load first

	}

}