package day11;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeClassAfterClass;

public class C03_FakerClass extends TestBaseBeforeClassAfterClass {
    @Test
    public void test1() {
        //"https://facebook.com"  Adresine gidin
        driver.get("https://facebook.com");

        //“create new account”  butonuna basin
        driver.findElement(By.xpath("//*[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();

        //firstName” giris kutusuna bir isim yazin
        Faker fake=new Faker();
        Actions action=new Actions(driver);
        String email=fake.internet().emailAddress();
        WebElement isim= driver.findElement(By.xpath("(//*[@type='text'])[2]"));
        action.click(isim).sendKeys(fake.name().firstName()).
        sendKeys(Keys.TAB).sendKeys(fake.name().lastName()).
        sendKeys(Keys.TAB).sendKeys(email).
        sendKeys(Keys.TAB).sendKeys(email).
        sendKeys(Keys.TAB).sendKeys(fake.internet().password()).perform();

        //4- Kaydol tusuna basalim
        driver.findElement(By.xpath("(//*[text()='Sign Up'])[3]")).click();



    }
}
