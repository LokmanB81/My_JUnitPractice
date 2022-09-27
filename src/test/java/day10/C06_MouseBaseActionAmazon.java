package day10;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeClassAfterClass;

public class C06_MouseBaseActionAmazon extends TestBaseBeforeClassAfterClass {

    @Test
    public void test1(){

       // 1 https://www.amazon.com/ adresine gidelim
        driver.get("https://amazon.com");
        driver.navigate().refresh();

       // 2 Sag ust bolumde bulunan “Account & Lists” menusunun acilmasi icin mouse’u bu menunun ustune getirelim
        WebElement accountLists= driver.findElement(By.xpath("//*[@id='nav-link-accountList']"));
        Actions action=new Actions(driver);
        action.moveToElement(accountLists).perform();

       // 3 “Create a list” butonuna basalim
        driver.findElement(By.xpath("//*[text()='Create a List']")).click();

       // 4 Acilan sayfada “Your Lists” yazisi oldugunu test edelim
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='my-lists-tab']")).getText().contains("Your Lists"));

    }
}
