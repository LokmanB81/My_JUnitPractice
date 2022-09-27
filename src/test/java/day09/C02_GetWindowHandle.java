package day09;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_GetWindowHandle {
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
        driver.quit();
    }

    @Test
    public void test1(){
    //1- Amazon Sayfasina girelim
        driver.get("https://amazon.com");
        String amazonWindowHandle= driver.getWindowHandle();

//2- Url'nin amazon içerdiğini test edelim
        String expectedUrl="amazon";
        Assert.assertTrue(driver.getCurrentUrl().contains("amazon"));


//3- Yeni bir pencere açıp bestbuy anasayfasına gidelim.(https://www.bestbuy.com)
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.bestbuy.com");
        String bestbuyWindowHandle= driver.getWindowHandle();

//4- title'in BestBuy içerdiğini test edelim
        String expectedTitle="Best Buy";
        Assert.assertTrue(driver.getTitle().contains(expectedTitle));

//5- İlk sayfaya dönüp sayfada java aratalım
        driver.switchTo().window(amazonWindowHandle);
        driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']")).
                sendKeys("java", Keys.ENTER);

//6- Arama sonuclarının java içerdiğini test edelim
        String expectedWord="java";
        Assert.assertTrue(driver.findElement(By.xpath("//*[@class='a-section a-spacing-small a-spacing-top-small']")).
                getText().contains(expectedWord));

//7- Yeniden bestbuy sayfasına gidelim
        driver.switchTo().window(bestbuyWindowHandle);

//8- Logonun görünürlüğünü test edelim
        Assert.assertTrue(driver.findElement(By.xpath("//*[@alt='Best Buy Logo']")).isDisplayed());
//9- Sayfaları Kapatalım
}
}
