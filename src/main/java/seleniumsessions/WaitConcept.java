package seleniumsessions;

public class WaitConcept {

    public static void main(String[] args) {

        // script -----sync (wait)-----> app(browser)

        // wait:
        // 1. static wait: Thread.sleep(10000); --> coming from Java
        // 10 secs --> 2 secs: 10 secs (If element is found in 2 secs, it will wait for
        // 10 secs, so 8 seconds are wasted)
        // 10 secs ---> 15 secs: 10 secs

        // 2. Dynamic wait:
        // 10 secs: 2 secs : 2 secs, rest 8 seconds will be ignored
        // 10 secs: 0 sec: 0 sec
        // 10 secs: 10 secs: 10 secs
        // 10 secs: 15 secs: NSE (NoSuchElementException)
        // 15 secs: 13 secs: 13 secs

        // In Selenium, we have two types of waits:
        // 2.1: Implicitly Wait
        // 2.2: Explicit Wait
               // 2.2.a: WebDriverWait
               // 2.2.b: FluentWait

    }

}
