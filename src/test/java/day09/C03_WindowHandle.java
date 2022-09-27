package day09;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_WindowHandle {
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
        //driver.quit();
    }

    @Test
    public void test1(){

        //Amazon anasayfa adresine gidin.
        driver.get("https://amazon.com");

        //Sayfa’nin window handle degerini String bir degiskene atayin
        String amazonHandle= driver.getWindowHandle();
        System.out.println(amazonHandle);

        //Sayfa title’nin “Amazon” icerdigini test edin
        String expectedTitle="Amazon";
        Assert.assertTrue(driver.getTitle().contains(expectedTitle));

        //Yeni bir tab olusturup, acilan tab’da techproeducation.com adresine gidin
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://techproeducation.com");

        //Sayfa title’nin “TECHPROEDUCATION” icerdigini test edin
        String expectedTitle1="TECHPROEDUCATION";
        Assert.assertFalse(driver.getTitle().contains(expectedTitle1));

        //Yeni bir window olusturup, acilan sayfada walmart.com adresine gidin
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://walmart.com");
        String walmartHandle= driver.getWindowHandle();

        //Sayfa title’nin “Walmart” icerdigini test edin
        String expectedTitle2="Walmart";
        Assert.assertTrue(driver.getTitle().contains(expectedTitle2));

        //Ilk acilan sayfaya donun ve amazon sayfasina dondugunuzu test edin
        driver.switchTo().window(amazonHandle);
       Assert.assertTrue(driver.getTitle().contains(expectedTitle));

    }

}
