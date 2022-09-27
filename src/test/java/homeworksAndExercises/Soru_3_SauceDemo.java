package homeworksAndExercises;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Soru_3_SauceDemo {
    static WebDriver driver;

    @BeforeClass
    public  static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    @AfterClass
    public  static  void tearDowm() {
        //driver.close();
    }

    @Test
    public void test1(){
        // 1. “https://www.saucedemo.com” Adresine gidin
        driver.get("https://www.saucedemo.com");

        //2. Username kutusuna “standard_user” yazdirin
        driver.findElement(By.xpath("//*[@id='user-name']")).
                sendKeys("standard_user");

        //3. Password kutusuna “secret_sauce” yazdirin
        driver.findElement(By.xpath("//*[@id='password']")).
                sendKeys("secret_sauce");

        //4. Login tusuna basin
        driver.findElement(By.xpath("//*[@id='login-button']")).click();

        //5. Ilk urunun ismini kaydedin ve bu urunun sayfasina gidin
        String fisrtProductName=driver.findElement(By.xpath("//*[text()='Sauce Labs Backpack']")).getText();

        driver.findElement(By.xpath("//*[text()='Sauce Labs Backpack']")).click();

        //6. Add to Cart butonuna basin
    driver.findElement(By.xpath("//*[@id='add-to-cart-sauce-labs-backpack']")).click();

    //7. Alisveris sepetine tiklayin
        driver.findElement(By.xpath("//*[@class='shopping_cart_link']")).click();

        //8. Sectiginiz urunun basarili olarak sepete eklendigini control edin
        String expectedName=fisrtProductName;
        String actualWord=driver.findElement(By.xpath("//*[@class='cart_item']")).getText();
        Assert.assertTrue(driver.findElement(By.xpath("//*[@class='cart_item']")).isDisplayed());

        //9. Sayfayi kapatin
    }
}
