package homeworksAndExercises;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBaseBeforeClassAfterClass;

import java.util.ArrayList;
import java.util.List;

public class IFrameHomework_LoginPortal extends TestBaseBeforeClassAfterClass {
    @Test
    public void test1() {
        //  1. “http://webdriveruniversity.com” sayfasina gidin
        driver.get("http://webdriveruniversity.com");

        // 2."Login Portal" a kadar asagi inin
        action.moveToElement(driver.findElement(By.xpath("(//h4)[2]"))).perform();

        // 3."Login Portal" a tiklayin
        driver.findElement(By.xpath("(//h4)[2]")).click();


        // 4.Diger window'a gecin
        List<String> handleList= new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(handleList.get(1));

        // 5."username" ve "password" kutularina deger yazdirin
        Faker fake=new Faker();
        driver.findElement(By.xpath("//*[@id='text']")).sendKeys(fake.name().username());
        driver.findElement(By.xpath("//*[@id='password']")).sendKeys(fake.internet().password());

        // 6."login" butonuna basin
        driver.findElement(By.xpath("//*[@id='login-button']")).click();

        // 7.Popup'ta cikan yazinin "validation failed" oldugunu test edin
        String expectedText="validation failed";
        Assert.assertEquals(expectedText,driver.switchTo().alert().getText());

        // 8.Ok diyerek Popup'i kapatin
        driver.switchTo().alert().accept();

        // 9.Ilk sayfaya geri donun
        driver.switchTo().window(handleList.get(0));

        // 10.Ilk sayfaya donuldugunu test edin
        String expectedUrl="http://webdriveruniversity.com/";
        Assert.assertEquals(expectedUrl,driver.getCurrentUrl());

    }
}
