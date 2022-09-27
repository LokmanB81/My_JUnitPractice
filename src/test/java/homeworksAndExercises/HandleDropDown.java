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
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class HandleDropDown {
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
    public void Test1() throws InterruptedException {
        // https://the-internet.herokuapp.com/dropdown adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dropdown");

        //1.Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        WebElement indexBox=driver.findElement(By.xpath("//*[@id='dropdown']"));
        Select slc1=new Select(indexBox);
        slc1.selectByIndex(1);
        Thread.sleep(1000);
        System.out.println(slc1.getFirstSelectedOption().getText());

        //2. Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın

        slc1.selectByValue("2");
        System.out.println(slc1.getFirstSelectedOption().getText());
        Thread.sleep(1000);

        //3.Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        slc1.selectByVisibleText("Option 1");
        System.out.println(slc1.getFirstSelectedOption().getText());

     //   4.Tüm dropdown değerleri(value) yazdırın
       // List<WebElement> dropDownList=driver.findElements(By.tagName("option"));
        System.out.println("****************************");
        List<WebElement> dropDownList=slc1.getOptions();
       dropDownList.forEach(t-> System.out.println(t.getText()));

        //System.out.println(slc1.getAllSelectedOptions().get(0).getText());


        //5. Dropdown’un boyutunu bulun, Dropdown’da 4 öğe varsa konsolda True , degilse
        //False yazdırın
        Integer expectedValue=4;
        Integer actualValue=dropDownList.size();
       // Assert.assertNotEquals(actualValue,expectedValue);
        if (actualValue==expectedValue){
            System.out.println("Actual size test : True");
        }
        else System.out.println("Actual size test : False");

    }

}


