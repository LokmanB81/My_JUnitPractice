package day12;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBaseBeforeClassAfterClass;

public class C02_FileUpload extends TestBaseBeforeClassAfterClass {
    @Test
    public void test1() {
        //https://the-internet.herokuapp.com/upload adresine gidelim
        driver.get("https://the-internet.herokuapp.com/upload");

        //chooseFile butonuna basalim Yuklemek istediginiz dosyayi secelim.
        driver.findElement(By.xpath("//*[@id='file-upload']")).
                sendKeys("C:\\Users\\lkmnb\\Desktop\\Test_execise_sample.bmp");
        //Upload butonuna basalim.
        driver.findElement(By.xpath("//*[@id='file-submit']")).click();

        //“File Uploaded!” textinin goruntulendigini test edelim.
        Assert.assertTrue(driver.findElement(By.xpath("//h3")).isDisplayed());

    }
}
