package day12;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBaseBeforeClassAfterClass;

import java.time.Duration;

public class C04_ExplicitlyWait extends TestBaseBeforeClassAfterClass {
    @Test
    public void enabledTest1() {
        //3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        //4. Textbox’in etkin olmadigini(enabled) dogrulayın
        Assert.assertFalse(driver.findElement(By.xpath("//*[@type='text']")).isEnabled());

        //5. Enable butonuna tıklayın ve textbox etkin oluncaya kadar bekleyin
        driver.findElement(By.xpath("(//*[@type='button'])[2]")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.
                elementToBeClickable(By.xpath("//*[@id='message']")));

        //6. “It’s enabled!” mesajinin goruntulendigini dogrulayın.
    Assert.assertTrue(driver.findElement(By.xpath("//*[@id='message']")).isDisplayed());

    //7. Textbox’in etkin oldugunu(enabled) dogrulayın
        Assert.assertTrue(driver.findElement(By.xpath("//*[@type='text']")).isEnabled());





        /*






         */
    }
}
