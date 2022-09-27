package day15;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.TestBaseBeforeClassAfterClass;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class C04_GetScreenShot extends TestBaseBeforeClassAfterClass {
    @Test
    public void test1() throws IOException {
        //amazon a gidelim, tum sayfanin resmini alalim
        driver.get("https:techproeducation.com");

        /*
        bir web sayfanin resmini alabilmek icin TakesScreenshot class indan bir obje olusturulur.
        File class indan gecici bir dosyaya  ts objesi uzerinden
        getScreenshotAs(OutputType.FILE) metodu ile atatriz
         */
        TakesScreenshot ts= (TakesScreenshot) driver;
        File tumSayfaResmi=ts.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(tumSayfaResmi,new File("target/ekranGoruntusu/allPage"+tarih+".jpeg"));
    }
}
