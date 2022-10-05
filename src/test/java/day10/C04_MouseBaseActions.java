package day10;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeAfter;

import java.util.ArrayList;
import java.util.List;

public class C04_MouseBaseActions extends TestBaseBeforeAfter {

    @Test
    public void test1() throws InterruptedException {
        //https://the-internet.herokuapp.com/context_menu sitesine gidelim
        driver.get("https://the-internet.herokuapp.com/context_menu");

        //- Cizili alan uzerinde sag click yapalim
        WebElement kareliBolge= driver.findElement(By.xpath("//*[@id='hot-spot']"));
        Actions actions=new Actions(driver);
        actions.moveToElement(kareliBolge).contextClick().perform();

        //Alert’te cikan yazinin “You selected a context menu” oldugunu
        //test edelim.
        String expectedText="You selected a context menu";
        Assert.assertEquals((driver.switchTo().alert().getText()),expectedText);

        //Tamam diyerek alert’i kapatalim
        driver.switchTo().alert().accept();

        //Elemental Selenium linkine tiklayalim
        driver.findElement(By.xpath("//*[text()='Elemental Selenium']")).click();
       List<String> handleList=new ArrayList<>(driver.getWindowHandles());

      // WebElement sagClick=driver.findElement(By.xpath("//*[text()='Elemental Selenium']"));
      // actions.moveToElement(sagClick).contextClick().perform();

        //Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim
        driver.switchTo().window(handleList.get(1));
        String expextedh1Text="Elemental Selenium";
       String actualh1Text=driver.findElement(By.xpath("//h1")).getText();
        Assert.assertEquals(actualh1Text,expextedh1Text);
    }

}
