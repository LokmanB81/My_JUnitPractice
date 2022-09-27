package day07;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_Authentication {
    static WebDriver driver;

    @BeforeClass
    public  static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //1 Bir class olusturun : BasicAuthentication
        //2 https://the-internet.herokuapp.com/basic_auth sayfasina gidin
        //driver.get("https://the-internet.herokuapp.com/basic_auth");
        //3 asagidaki yontem ve test datalarini kullanarak authentication’i yapin
        //Html komutu : https://username:password@URL
        //Username : admin
        //password : admin
        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");

    }

    @AfterClass
    public  static  void tearDowm() {
        //driver.close();
    }

    @Test
    public  void test1(){

//4 Basarili sekilde sayfaya girildigini dogrulayin
        String expectedTitle="The Internet";
        String actualTitle= driver.getTitle();
        Assert.assertEquals(actualTitle,expectedTitle);

    }
}
