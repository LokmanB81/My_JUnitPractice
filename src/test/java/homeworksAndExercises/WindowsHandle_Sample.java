package homeworksAndExercises;

import net.bytebuddy.agent.builder.AgentBuilder;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeClassAfterClass;

import java.util.ArrayList;
import java.util.List;

public class WindowsHandle_Sample extends TestBaseBeforeClassAfterClass {

    @Test
    public void test1() throws InterruptedException {
        // 1 - https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows"); //index 0
        ///String ilkSekme= driver.getWindowHandle();

// 2 - Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        Assert.assertTrue(driver.getTitle().contains("The Internet"));

        // 3 - Aynı pencerede yeni TAB sekmesinde hhtp://www.hepsiburada.com sayfasını açın
        driver.switchTo().newWindow(WindowType.TAB).get("http://www.hepsiburada.com"); //index 1
        //Thread.sleep(500);
        //driver.switchTo().alert().accept();


        // 4 - Yeni bir pencerede "https://amazon.com" sayfasını açın
        driver.switchTo().newWindow(WindowType.WINDOW).get("https://amazon.com"); // index 2

        // 5 - amazon.com sayfasında arama kısmında "Mouse" arayın
        driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']")).
                sendKeys("Mouse", Keys.ENTER);

        // 6- Bulduğu ürünlerden ilk ürünün adında "Mouse" kelimesinin geçtiğini doğrulayın
        Assert.assertTrue(driver.findElement(By.xpath("(//*[@class='sg-col-inner'])[4]")).
                getText().contains("Mouse"));

        // 7 - Yeni bir pencerede "http://asrateknik.com" sayfasını  açın
        driver.switchTo().newWindow(WindowType.WINDOW).get("http://asrateknik.com"); //index 3
        List<String> handle=new ArrayList<>(driver.getWindowHandles());


        // 8 - Ürünler menüsünden "Ameliyathane Hijyen Santralleri" kısmına tıklayın
        WebElement urunlerLinki= driver.findElement(By.xpath("//*[text()='Ürünler']"));
        Actions action=new Actions(driver);
        action.moveToElement(urunlerLinki).perform();

        driver.findElement(By.xpath("(//*[text()='Ameliyathane Hijyen Santralleri'])[1]")).click();



        // 9 - Ameliyathane Hijyen Santralleri sayfasında; "İki Bölgeli Klima sistemi" yazısının göründüğünü test edin.
        Assert.assertTrue(driver.findElement(By.xpath("(//h2)[4]")).isDisplayed());


        //  10 - İlk penceredeki hepsiburada.com sayfasına dönün.
        driver.switchTo().window(handle.get(1));


      //

        // 11 - hepsiburada sayfasında Arama kısmında "Notebook" arayın

        driver.findElement(By.xpath("//*[@type='text']")).click();
        driver.findElement(By.xpath("//*[@type='text']")).sendKeys("Notebook",Keys.ENTER);

        // 12 - Notebook ile ilgili 10000+ sonuç bulundu yazısının göründüğünü onaylayın
        Assert.assertTrue(driver.findElement(By.xpath("//*[@class='searchResultSummaryBar-CbyZhv5896ASVcYBLKmx']")).
                getText().contains("10000+"));

        // 13 - amazon.com sayfasının olduğu pencereye dönün ve pencereyi kapatın
        driver.switchTo().window(handle.get(2));
        driver.close();

        driver.switchTo().window(handle.get(3));
        Thread.sleep(2000);

        driver.switchTo().window(handle.get(1));
        driver.findElement(By.xpath("//*[@viewBox='0 0 171 28']")).click();


        // 14 -İlk açtığınız https://the-internet.herokuapp.com/windows" sayfasına geçin.
        driver.switchTo().window(handle.get(0));

        // 15 - Click Here yazısına tıklayın
        driver.findElement(By.xpath("//*[text()='Click Here']")).click();

       // 16 - Açılan yeni sekmedeki yeni sayfada "New Window" yazısının göründüğünü onaylayın.
        List<String> handlelist=new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(handlelist.get(handlelist.size()-1));

       Assert.assertTrue(driver.findElement(By.xpath("//h3")).getText().contains("New Window"));

    }

}
