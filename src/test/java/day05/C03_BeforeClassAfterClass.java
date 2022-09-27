package day05;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_BeforeClassAfterClass {
    static WebDriver driver;
    /*
BeforeClass ve AfterClass notasyonlari kullaniyorsak
olusturacagimiz method'u static yapmammiz gerekiyor
 */

    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @AfterClass
    public static void taerDown(){
        driver.close();
    }

    @Test
    @Ignore
    public void method1(){
        driver.get("https://google.com");
        //driver.get("https://amazon.com");
    }

    @Test
    public void method2(){
        driver.get("https://techproeducation.com");
    }

    @Test
    public void method3(){
        driver.get("https://amazon.com");
        WebElement searchBox= driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("samsung headphones", Keys.ENTER);
        System.out.println(driver.
                findElement(By.xpath("(//*[@class='a-section a-spacing-small a-spacing-top-small'])[1]")).
                getText());
        driver.findElement(By.xpath("(//*[@class='s-image'])[1]")).click();

    }
}
