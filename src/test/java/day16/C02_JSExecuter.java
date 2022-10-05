package day16;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeClassAfterClass;

public class C02_JSExecuter extends TestBaseBeforeClassAfterClass {
    @Test
    public void test() {
        //amazon sayfasina gidelim.
        // asagidaki carrers butonunu gorunceye kadar scroll yapalim ve
       // Carrers butonuna JS ile clicl yapalim.

        driver.get("https://www.amazon.com");
        WebElement careers=driver.findElement(By.xpath("//*[text()='Careers']"));
        WebElement aboutAmazon= driver.findElement(By.xpath("//*[text()='About Amazon']"));
        JavascriptExecutor jse= (JavascriptExecutor) driver;

        jse.executeScript("arguments[0].scrollIntoView(true);",careers);
        jse.executeScript("arguments[0].click();",aboutAmazon);
    }
}
