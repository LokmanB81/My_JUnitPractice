package day06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.security.Key;
import java.time.Duration;

public class C05_Assertions {
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
       // http://automationpractice.com/index.php sayfasina gidelim
        driver.get("http://automationpractice.com/index.php");

        //Sign in butonuna basalim
        driver.findElement(By.xpath("//*[@class='login']")).click();

        //Email kutusuna @isareti olmayan bir mail yazip enter’a
        driver.findElement(By.xpath("//*[@id='email']")).sendKeys("lllgmail.com", Keys.ENTER);

        //bastigimizda “Invalid email address” uyarisi ciktigini test edelim
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Invalid email address.']")).isDisplayed());



    }












    /*
    1. Bir Class olusturalim YanlisEmailTesti
2.
3.
4.


     */
}
