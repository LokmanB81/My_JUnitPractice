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

        Assert.assertTrue(driver.getCurrentUrl().contains("Nutella"));
            //    (driver.findElement(By.xpath("//*[@class='a-section a-spacing-small a-spacing-top-small]")).getText().contains("Nutella"));

             //  WebElement ilkUrunShot= driver.findElement(By.xpath("(//*[@class='a-section a-spacing-base'])[1]"));
        File nutellaSearch=driver.findElement(By.xpath("(//*[@class='a-section a-spacing-base'])[1]")).
                getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(nutellaSearch,new File("target/ekranGoruntusu/products/firstProduct"+tarih+".jpeg"));



    }
}
