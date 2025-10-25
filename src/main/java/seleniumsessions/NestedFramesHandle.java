package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NestedFramesHandle {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get("https://selectorshub.com/iframe-scenario/");

        // page --> f1 --> f2 --> f3 -- ele
        // driver.switchTo().frame("pact1")
        // .switchTo().frame("pact2")
        // .switchTo().frame("pact3")
        // .findElement(By.id("glaf")).sendKeys("Google");

        String header = driver.switchTo().frame("pact1")
                .switchTo().frame("pact2")
                .switchTo().frame("pact3")
                .switchTo().parentFrame()
                .switchTo().parentFrame()
                .switchTo().defaultContent()
                .findElement(By.tagName("h3")).getText();
        System.out.println(header);

        // driver.switchTo().frame("pact1");//f1 or frame1
        // driver.findElement(By.id("inp_val")).sendKeys("testing");
        //
        // driver.switchTo().frame("pact2");//f2 or frame2
        // driver.findElement(By.id("jex")).sendKeys("automation");

        // driver.switchTo().frame("pact3");//f3 or frame3
        // driver.findElement(By.id("glaf")).sendKeys("Google");

        // f3->f2:
        // driver.switchTo().parentFrame();
        // driver.findElement(By.id("jex")).sendKeys(" with selenium");
        //
        // //f2->f1:
        // driver.switchTo().parentFrame();
        // driver.findElement(By.id("inp_val")).sendKeys(" in NAL");

        // f1->page(DC):DC means DefaultContent
        // driver.switchTo().defaultContent();
        // String header = driver.findElement(By.tagName("h3")).getText();
        // System.out.println(header);

        // f1->page(PF):
        // driver.switchTo().parentFrame();
        // String header = driver.findElement(By.tagName("h3")).getText();
        // System.out.println(header);

        // page --> f2: invalid, you have to go to child frame 1st
        // driver.switchTo().frame("pact2");//f2
        // driver.findElement(By.id("jex")).sendKeys("cypress");

        // page-->f1:
        // driver.switchTo().frame("pact1");//f1
        // driver.findElement(By.id("inp_val")).sendKeys(" playwright");
        //
        // //f1-->f3:No not possible, you can't bypass frame while going from parent frame to child or reverse
        // driver.switchTo().frame("pact3");//f3
        // driver.findElement(By.id("glaf")).sendKeys("MS");

        // page -->f1: yes
        // f1-->f2: yes
        // f2-->f3: yes
        // page --> f2: no
        // page --> f3: no
        // page --f1--f2--f3: yes

        // f3-->f2: yes(PF)
        // f2-->f1: yes(PF) PF means parentFrame method available in Selenium4
        // f1-->page : yes(PF, DC)
        // f3-->f2(PF)-->f1(PF)

        // f3 -->f1: invalid
        // driver.switchTo().frame("pact1");//f1
        // driver.findElement(By.id("inp_val")).sendKeys(" manual");

        // f3-->page:valid
        // driver.switchTo().defaultContent();
        // String header = driver.findElement(By.tagName("h3")).getText();
        // System.out.println(header);

        // f2-->page:
        // driver.switchTo().defaultContent();
        // String header = driver.findElement(By.tagName("h3")).getText();
        // System.out.println(header);

    }

}
