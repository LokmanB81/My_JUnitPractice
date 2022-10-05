package practice05;

import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBaseBeforeClassAfterClass;

public class P01 extends TestBaseBeforeClassAfterClass {
    @Test
    public void test1() {
        // go to url : https://www.techlistic.com/p/selenium-practice-form.html
        driver.get("https://www.techlistic.com/p/selenium-practice-form.html");

        //fill the firstname
        driver.findElement(By.xpath("//*[@name='firstname']")).sendKeys("");

    }
    // ...Exercise3...


//fill the lastname
//check the gender
//check the experience
//fill the date
//choose your profession -> Automation Tester
//choose your tool -> Selenium Webdriver
//choose your continent -> Antartica
//choose your command  -> Browser Commands
//click submit button

}
