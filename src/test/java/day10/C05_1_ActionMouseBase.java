package day10;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeClassAfterClass;

public class C05_1_ActionMouseBase extends TestBaseBeforeClassAfterClass {
    @Test
    public void test1() throws InterruptedException {

        //1 https://demoqa.com/droppable adresine gidelim
        driver.get("https://demoqa.com/droppable");

        //2 “Drag me” butonunu tutup “Drop here” kutusunun ustune birakalim
        WebElement dragMe= driver.findElement(By.xpath("//*[@id='draggable']"));
        WebElement dropHere= driver.findElement(By.xpath("//*[@id='droppable']"));
        Actions action=new Actions(driver);

        action.dragAndDrop(dragMe,dropHere).perform();

        //3 “Drop here” yazisi yerine “Dropped!” oldugunu test edin
        Assert.assertEquals((driver.findElement(By.xpath("//*[text()='Dropped!']")).getText()),"Dropped!");

    }
}
