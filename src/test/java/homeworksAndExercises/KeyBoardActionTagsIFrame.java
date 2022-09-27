package homeworksAndExercises;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeClassAfterClass;

public class KeyBoardActionTagsIFrame extends TestBaseBeforeClassAfterClass {
    @Test
    public void test1() {
        //2https://html.com/tags/iframe/ sayfasina gidelim
        driver.get("https://html.com/tags/iframe/");


        //3- video’yu gorecek kadar asagi inin
        WebElement iFrame= driver.findElement(By.xpath("//*[@src='https://www.youtube.com/embed/owsfdh4gxyc']"));
        action.moveToElement(iFrame).perform();



         //4 videoyu izlemek icin Play tusuna basin
        driver.switchTo().frame(iFrame);
        driver.findElement(By.xpath("//*[@aria-label='Play']")).click();

        //5 videoyu calistirdiginizi test edin
        Assert.assertTrue(driver.findElement(By.xpath("//*[@class='ytp-time-current']")).isEnabled());



    }
}
