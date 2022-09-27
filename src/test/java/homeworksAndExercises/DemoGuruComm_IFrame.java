package homeworksAndExercises;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class DemoGuruComm_IFrame {
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
    public void test1() throws InterruptedException {
        //1) http://demo.guru99.com/test/guru99home/ sitesine gidiniz
        driver.get("   http://demo.guru99.com/test/guru99home/ ");

        //2) sayfadaki iframe sayısını bulunuz.
       // List<WebElement> iframeSayisi=driver.findElements(By.tagName("iframe"));
        List<WebElement> iframeSayisi=driver.findElements(By.xpath("//iframe"));
        System.out.println("iframeSayisi = " + iframeSayisi.size());

        driver.switchTo().frame(1);

        //3) ilk iframe'deki (Youtube) play butonuna tıklayınız.
       // WebElement iFrame1=driver.findElement(By.xpath("//*[@src='https://www.youtube.com/embed/RbSlW8jZFe8']"));
     //   driver.switchTo().frame(iFrame1);
        driver.findElement(By.xpath("//*[@aria-label='Play']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@class='ytp-play-button ytp-button']")).click();

        //4) ilk iframe'den çıkıp ana sayfaya dönünüz
        driver.switchTo().parentFrame();

        //5) ikinci iframe'deki (Jmeter Made Easy) linke
        // (https://www.guru99.com/live-selenium-project.html)
        //tıklayınız
        WebElement iFrame2= driver.findElement(By.xpath("//*[@id='a077aa5e']"));
        driver.switchTo().frame(iFrame2);
        driver.findElement(By.xpath("//*[@src='Jmeter720.png']")).click();

    }
}
