package day15;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import utilities.TestBaseBeforeClassAfterClass;

import java.io.File;
import java.io.IOException;

public class AmazonScreenShotTest extends TestBaseBeforeClassAfterClass {
    @Test
    public void test() throws IOException {
        //1amazon anasayfaya gidin
        driver.get("https://www.amazon.com");

        //2 amazon anasayfaya gittiginizi test edin ve tum sayfanin goruntusunu kaydedin
        String expectedUrl="https://www.amazon.com/";
        String actualUrl= driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl,actualUrl);

        TakesScreenshot ts= (TakesScreenshot) driver;
        File homePageShot=ts.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(homePageShot,new File("target/ekranGoruntusu/products/allPage"+tarih+".jpeg"));


            //3- Nutella icin arama yapin
        driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']"))
                .sendKeys("Nutella", Keys.ENTER);

        // 4- sonucun Nutella icerdigini test edin
        Assert.assertTrue(driver.getCurrentUrl().contains("Nutella"));

        /*
        //Sadece Web elementin resmini alacaksak TakeScreenShot classını kullanmama gerek yok
        //Locate ettiğimiz webelementi direk geçici bir file'a atıp
        FileUtils ile kopyalayıp yolunu(path) belirtiriz
         */

        // Sonucu gosteren yazinin  ekran goruntusunu alin
        WebElement aramaSonucu=driver.findElement(By.xpath("(//*[@class='sg-col-inner'])[1]"));
        File aramaSonucuShot=aramaSonucu.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(aramaSonucuShot,new File("target/ekranGoruntusu/products/aramaSonucu"+tarih+".jpeg"));

       //  ve ilk urunun goruntusunu alin
        WebElement nutellaSearch= driver.findElement(By.xpath("(//*[@class='a-section a-spacing-base'])[1]"));
        File ilkUrunShot=nutellaSearch.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(ilkUrunShot,new File("target/ekranGoruntusu/products/firstProduct"+tarih+".jpeg"));

        // nutella aramasında acilan ekranın goruntusunu alin
        TakesScreenshot ts1= (TakesScreenshot) driver;
        File producthomePageShot=ts1.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(producthomePageShot,new File("target/ekranGoruntusu/products/pAllPage"+tarih+".jpeg"));

    }
}
