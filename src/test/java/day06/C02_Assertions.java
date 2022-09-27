package day06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_Assertions {
    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @After
    public void tearDowm() {
        //driver.close();
    }
    //3 farkli test method'u olustur
    @Test
    public  void test1(){
        //Amazon sayfasina git
        driver.get("https://amazon.com");
/*
        // url'in "amazon" icergini test et
        String expectedUrl="amazon";
      //  System.out.println(driver.getCurrentUrl());
      String actualUrl= driver.getCurrentUrl();
       Assert.assertTrue(actualUrl.contains(expectedUrl)); // test pass

 */

        String expectedUrl="https://facebook.com";
        String actualUrl= driver.getCurrentUrl();
        Assert.assertNotEquals(actualUrl,expectedUrl);


    }
    @Test
    public  void test2(){
        //Amazon sayfasina git
        driver.get("https://amazon.com");

        //title'in "facebook" icermedigini test et
        String expectedTitle="facebook";
        String actualTitle=driver.getTitle();
        Assert.assertFalse(actualTitle.contains(expectedTitle));  // test pass

    }

    @Test
    public  void test3(){
        //Amazon sayfasina git
        driver.get("https://amazon.com");

        //- sol ust kosede amazon logosunun gorundugunu test et

        boolean actualResult=driver.findElement(By.xpath("//*[@id='nav-logo-sprites']")).isDisplayed();
        Assert.assertTrue(actualResult); // test pass

/*
        WebElement logo=driver.findElement(By.xpath("//*[@id='nav-logo-sprites']"));
        Assert.assertTrue(logo.isDisplayed());

 */




    }

    /*





 */


}
