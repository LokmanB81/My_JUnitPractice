package day10;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeAfter;
import utilities.TestBaseBeforeClassAfterClass;

import javax.swing.*;

public  class C03_Actions extends TestBaseBeforeClassAfterClass {

    @Test
    public void test1(){
        //amazon sayfasına gidelim
        //account menusunden create a list link'ine tıklaylim
        driver.get("https://amazon.com");
        WebElement accountList= driver.findElement(By.xpath("//*[@id='nav-link-accountList']"));
        Actions actions=new Actions(driver);
        actions.moveToElement(accountList).perform();
        driver.findElement(By.xpath("//*[text()='Create a List']")).click();



    }
}
