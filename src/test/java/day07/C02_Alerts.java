package day07;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_Alerts {
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
    public void acceptAlert(){
//Bir metod olusturun: acceptAlert
        //1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result
        //mesajının  “You successfully clicked an alert” oldugunu test edin.
        System.out.println("**********************");
        driver.manage().window().setSize(new Dimension(850,768));
        driver.findElement(By.xpath("//*[text()='Click for JS Alert']")).click();
        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();
        Assert.assertTrue(driver.
                findElement(By.xpath("//*[@id='result']")).isDisplayed());

    }

    @Test
    public void dismissAllert(){
        //Bir metod olusturun: dismissAlert
        //2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının
        //“successfuly” icermedigini test edin.
        System.out.println("****************");
        driver.findElement(By.xpath("//*[text()='Click for JS Confirm']")).click();
        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();
        String expectedWord="successfuly";
        String actualWord=driver.
                findElement(By.xpath("//*[text()='You clicked: Cancel']")).getText();
        Assert.assertFalse(actualWord.contains(expectedWord));
    }

    @Test
    public void sendKeysAlert(){
        //Bir metod olusturun: sendKeysAlert
        //3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, OK butonuna
        //tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın.
        System.out.println("****************");
        driver.findElement(By.xpath("//*[text()='Click for JS Prompt']")).click();
        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().sendKeys("lokman");
        driver.switchTo().alert().accept();
        String expectedWord="lokman";
        String actualWord=driver.
                findElement(By.xpath("//*[text()='You entered: lokman']")).getText();
        Assert.assertTrue(actualWord.contains(expectedWord));

    }
}
