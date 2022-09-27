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
import java.util.ArrayList;
import java.util.List;

public class C04_IFrame {
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

        driver.get("https://html.com/tags/iframe/");
        //List<WebElement> iFrameList= new ArrayList<>(driver.findElements(By.xpath("//iframe")));
        List<WebElement> iFrameList= new ArrayList<>(driver.findElements(By.tagName("iframe")));
        System.out.println(iFrameList.size());

        WebElement youtubeIframe= driver.
                findElement(By.xpath("//*[@src='https://www.youtube.com/embed/owsfdh4gxyc']"));
        driver.switchTo().frame(youtubeIframe);
        driver.findElement(By.xpath("//*[@aria-label='Play']")).click();
    }
}
