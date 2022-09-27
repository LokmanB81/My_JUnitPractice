package homeworksAndExercises;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBaseBeforeClassAfterClass;

import java.time.Duration;

public class IFrameHomework_OurProducts extends TestBaseBeforeClassAfterClass {
    @Test
    public void test1() throws InterruptedException {
        //  1. “http://webdriveruniversity.com/IFrame/index.html” sayfasina gidin
        driver.get("http://webdriveruniversity.com/IFrame/index.html");

       // 2. “Our Products” butonuna basin
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe")));
        driver.findElement(By.xpath("//*[text()='Our Products']")).click();

        // 3. “Cameras product”i tiklayin
    driver.findElement(By.xpath("//*[@id='camera-img']")).click();

        // 4. Popup mesajini yazdirin
       WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
       wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='modal-body']")));
       System.out.println(driver.findElement(By.xpath("//div[@class='modal-body']")).getText());

        // 5. “close” butonuna basin
       driver.findElement(By.xpath("//*[text()='Close']")).click();

        // 6. "WebdriverUniversity.com (IFrame)" linkini tiklayin
        driver.switchTo().parentFrame();
        driver.findElement(By.xpath("//*[text()='WebdriverUniversity.com (IFrame)']")).click();

        // 7. "http://webdriveruniversity.com/index.html" adresine gittigini test edin
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='nav-title']")).isDisplayed());

    }
}
