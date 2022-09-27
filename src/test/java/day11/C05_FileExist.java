package day11;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBaseBeforeAfter;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C05_FileExist extends TestBaseBeforeAfter {

    @Test
    public void test1() {
        //https://the-internet.herokuapp.com/download adresine gidelim.
        driver.get("https://the-internet.herokuapp.com/download");

        //test.txt dosyasını indirelim
driver.findElement(By.xpath("//*[text()='test.txt']")).click();

//Ardından isExist( )  methodunda dosyanın başarıyla indirilip indirilmediğini test edelim
        String downloadFile="C:\\Users\\lkmnb\\Downloads\\test.txt";
        Assert.assertTrue(Files.exists(Paths.get(downloadFile)));


        /*





         */

    }
}
