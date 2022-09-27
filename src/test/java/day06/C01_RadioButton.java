package day06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_RadioButton {
    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @After
    public void tearDowm() {
        //driver.close();
    }

@Test
    public void radioButtonTest(){
        // https://www.facebook.com adresine gidin
    driver.get("https://www.facebook.com");

    //Cookies’i kabul edin

    //“Create an Account” button’una basin
    driver.findElement(By.xpath("(//a[@role='button'])[2]")).click();

    //“radio buttons” elementlerini locate edin
    WebElement f_Button=driver.findElement(By.xpath("(//*[@type='radio'])[1]"));
    WebElement m_Button=driver.findElement(By.xpath("(//*[@type='radio'])[2]"));
    WebElement c_Button=driver.findElement(By.xpath("(//*[@type='radio'])[3]"));

    //Secili degilse cinsiyet butonundan size uygun olani secin
    if(!m_Button.isSelected()){
    m_Button.click();}

}




/*
    Bir class oluşturun : RadioButtonTest
    Gerekli yapiyi olusturun ve aşağıdaki görevi tamamlayın.

    Cookies’i kabul edin




 */

}
