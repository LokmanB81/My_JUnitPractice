package homeworksAndExercises;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeClassAfterClass;

public class KeyBoardActionHoverOverMe extends TestBaseBeforeClassAfterClass {
    @Test
    public void test1() throws InterruptedException {
        //1- "" sayfasina gidin
        driver.get("http://webdriveruniversity.com/Actions");

        //2- Hover over Me First" kutusunun ustune gelin
        WebElement firstOverMe= driver.findElement(By.xpath("//*[text()='Hover Over Me First!']"));
        action.moveToElement(firstOverMe).perform();

        // 3 -Link 1" e tiklayin
        driver.findElement(By.xpath("(//*[text()='Link 1'])[1]")).click();

        // 4 -Popup mesajini yazdirin
        System.out.println("Alert message :"+driver.switchTo().alert().getText());

        //5 -Popup'i tamam diyerek kapatin
        driver.switchTo().alert().accept();

        //6 - “Click and hold" kutusuna basili tutun
        action.sendKeys(Keys.END).perform();
      //  Thread.sleep(100);
       WebElement clickNHold= driver.findElement(By.xpath("//*[@id='click-box']"));

        action.clickAndHold(clickNHold).perform();

        //7-“Click and hold" kutusunda cikan yaziyi yazdirin
         System.out.println(clickNHold.getText());
        /// Thread.sleep(2000);

         //8- “Double click me" butonunu cift tiklayin
        WebElement doubleClickMe=driver.findElement(By.id("double-click"));
       action.doubleClick(doubleClickMe).perform();

    }
}
