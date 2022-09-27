package day11;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeClassAfterClass;

public class C02_ActionsKeyboardActions extends TestBaseBeforeClassAfterClass {
    @Test
    public void test1() {
        //1- https://www.facebook.com adresine gidelim
        driver.get("https://www.facebook.com");

        //2- Yeni hesap olustur butonuna basalim
        driver.findElement(By.xpath("//*[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();

        //3- Ad, soyad, mail ve sifre kutularina deger yazalim ve kaydol tusuna basalim
        WebElement isim= driver.findElement(By.xpath("(//*[@type='text'])[2]"));
        Actions action=new Actions(driver);
        isim.sendKeys("lkmn");
        action.sendKeys(Keys.TAB).
                sendKeys("bayrak").
                sendKeys(Keys.TAB).
                sendKeys("lkmn@gmail.com").
                sendKeys(Keys.TAB).
                sendKeys("123456").
                sendKeys(Keys.TAB).
                sendKeys("123456").
                sendKeys(Keys.TAB).perform();

        //4- Kaydol tusuna basalim
        driver.findElement(By.xpath("(//*[text()='Sign Up'])[3]")).click();

    }
}
