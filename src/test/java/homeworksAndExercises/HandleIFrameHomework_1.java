package homeworksAndExercises;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class HandleIFrameHomework_1 {
    static WebDriver driver;

    @BeforeClass
    public  static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //https://the-internet.herokuapp.com/iframe adresine gidin.
        driver.get("https://the-internet.herokuapp.com/iframe");
    }

    @AfterClass
    public  static  void tearDowm() {
        //driver.close();
    }

    @Test
    public void test1(){
        //“An IFrame containing….” textinin erisilebilir oldugunu test edin ve konsolda yazdirin.

        if(driver.findElement(By.tagName("h3")).isEnabled()){
            System.out.println("h3 tag test PASS");
        }
        else {System.out.println("h3 tag test FAIL"); }

        //Text Box’a “Merhaba Dunya!” yazin.
      //  driver.findElement(By.xpath("//*[@id='tinymce']")).click();
        WebElement iFrame=driver.findElement(By.xpath("//*[@id='mce_0_ifr']"));
        driver.switchTo().frame(iFrame);
        driver.findElement(By.xpath("//*[@id='tinymce']")).clear();
       driver.findElement(By.xpath("//*[@id='tinymce']")).sendKeys("Merhaba Dunya");

       //TextBox’in altinda bulunan “Elemental Selenium” linkinin textinin gorunur oldugunu
        //dogrulayin ve konsolda yazdirin
        driver.switchTo().parentFrame();

              if(driver.findElement(By.linkText("Elemental Selenium")).isDisplayed()){
            System.out.println("Elemental Selenium display test PASS");
        }
        else System.out.println("Elemental Selenium display test FAIL");

    }
}
