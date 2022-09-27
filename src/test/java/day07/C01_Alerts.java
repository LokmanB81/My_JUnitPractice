package day07;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_Alerts {
    static WebDriver driver;

    @BeforeClass
    public  static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //// https://the-internet.herokuapp.com/javascript_alerts adresine gidelim
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

    }

    @AfterClass
    public  static  void tearDowm() {
        //driver.close();
    }

    @Test
    public  void test1(){

        //// Click for JS Alert butonuna tıklayalım
        driver.findElement(By.xpath("//*[text()='Click for JS Alert']")).click();

        //// Tıkladıktan sonra çıkan uyarı mesajına (Alerte) tamam diyelim
        String message=driver.switchTo().alert().getText();
        driver.switchTo().alert().accept();

        System.out.println("alert message : "+message);
    }

    @Test
    public  void test2(){

        //// Click for JS Alert butonuna tıklayalım
        driver.findElement(By.xpath("//*[text()='Click for JS Confirm']")).click();

        //// Tıkladıktan sonra çıkan uyarı mesajına (Alerte) tamam diyelim
        String message=driver.switchTo().alert().getText();
        driver.switchTo().alert().dismiss();

        System.out.println("alert message : "+message);
    }



}
