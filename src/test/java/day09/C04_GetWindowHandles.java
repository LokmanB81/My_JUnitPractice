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
import java.util.ArrayList;
import java.util.List;

public class C04_GetWindowHandles {
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
    public void test1() throws InterruptedException {
        //https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");
        String ilkSekme= driver.getWindowHandle();


        //Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        Assert.assertTrue(driver.findElement(By.xpath("//h3")).getText().
                contains("Opening a new window"));

        //Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        Assert.assertTrue(driver.getTitle().contains("The Internet"));

        //Click Here butonuna basın.
        driver.findElement(By.xpath("//*[text()='Click Here']")).click();

        List<String> windowHandlesList = new ArrayList<>(driver.getWindowHandles());

        //Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
        driver.switchTo().window(windowHandlesList.get(1));
        Assert.assertTrue(driver.getTitle().contains("New Window"));

        //Sayfadaki textin “New Window” olduğunu doğrulayın.
        Assert.assertTrue(driver.findElement(By.xpath("//h3")).getText().
                contains("New Window"));

        //Bir önceki pencereye geri döndükten sonra sayfa
        // başlığının “The Internet” olduğunu  doğrulayın.
        driver.switchTo().window(windowHandlesList.get(0));
        Assert.assertTrue(driver.getTitle().contains("The Internet"));




        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://amazon.com");
        windowHandlesList.add(driver.getWindowHandle());


       driver.switchTo().window(windowHandlesList.get(0));
       // driver.switchTo().window(ucuncuSekme);

      // driver.switchTo().window(amazonPage);
       // driver.switchTo().window(windowHandlesList.get(2));
        driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']")).
                sendKeys("java", Keys.ENTER);

        //driver.switchTo().window(windowHandlesList.get(0));
        driver.switchTo().window(ilkSekme);
        driver.findElement(By.xpath("//*[text()='Click Here']")).click();

       // windowHandlesList.add(driver.getWindowHandle());
       // driver.switchTo().window(windowHandlesList.get(2));

        Thread.sleep(2000);
       // driver.switchTo().window(windowHandlesList.get(0));


        //driver.switchTo().window(windowHandlesList.get(1));






    }

}
