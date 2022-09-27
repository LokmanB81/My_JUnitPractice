package homeworksAndExercises;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class HandleDropDown_Amazon {
    static WebDriver driver;

    @BeforeClass
    public  static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //● https://www.amazon.com/ adresine gidin.
        driver.get("https://www.amazon.com/");


    }

    @AfterClass
    public  static  void tearDowm() {
        //driver.close();
    }

    @Test
    public  void test1() throws InterruptedException {
        //Arama kutusunun yanindaki kategori menusundeki kategori sayisinin 45
        //oldugunu test edin
/*
       List<WebElement> categoryMenu= driver.findElements(By.xpath("//option"));
        System.out.println(categoryMenu.size());
        Integer expectedSize=45;
        Integer actualSize= categoryMenu.size();
        Assert.assertNotEquals(actualSize,expectedSize);

 */

        WebElement categoryMenu= driver.findElement(By.xpath("//*[@id='searchDropdownBox']"));
     Select slc1=new Select(categoryMenu);
     slc1.selectByIndex(5);

       List<WebElement> elementCount=slc1.getOptions();
       Integer expectedSize=45;
       Integer actualSize=elementCount.size();
       System.out.println(actualSize);
        Assert.assertNotEquals(actualSize,expectedSize);


    }

    @Test
    public void test2(){
        //1. Kategori menusunden Books secenegini secin
        WebElement categoryMenu= driver.findElement(By.xpath("//*[@id='searchDropdownBox']"));
        Select slc1=new Select(categoryMenu);
        //Thread.sleep(1000);
        slc1.selectByIndex(5);
        System.out.println(slc1.getFirstSelectedOption().getText());
      //  List<WebElement> dropElements=slc1.getOptions();
      //  System.out.println(dropElements.get(10).getText());

        //2. Arama kutusuna Java yazin ve aratin
        driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']")).
                sendKeys("Java", Keys.ENTER);

        //3. Bulunan sonuc sayisini yazdirin
        WebElement result=driver.findElement(By.xpath("(//*[@class='a-section a-spacing-small a-spacing-top-small'])[1]"));
        System.out.println("Bulunan sonuc adedi: "+result.getText());
        String [] resultArr=result.getText().split(" ");
        System.out.println("bulunan sonuc : "+resultArr[3]);

       // 4. Sonucun Java kelimesini icerdigini test edin
        String expectedWord="Java";
        String actualWord=result.getText();
        Assert.assertTrue(actualWord.contains(expectedWord));

    }

    /*
           ●https://www.amazon.com/ adresinegidin.
           -Test1
           Arama kutusunun yanindaki kategori menusundeki kategori sayisinin45
           oldugunu testedin
           -Test2
           1.Kategori menusunden Books seceneginisecin
           2.Arama kutusuna Java yazin vearatin
           3.Bulunan sonuc sayisiniyazdirin
           4.Sonucun Java kelimesini icerdigini testedin
*/
    /*
    WebDriver driver;
    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://amazon.com");
    }
    @After
    public void tearDown() {
        //driver.close();
    }
    @Test
    public void test1(){
        //Arama kutusunun yanindaki kategori menusundeki kategori sayisinin 45
        //oldugunu test edin
        List<WebElement> drops = driver.findElements(By.xpath("//option"));
        System.out.println(drops.size());
        for (WebElement w:drops) {
            System.out.println(w.getText());
        }
        int dropDownList = drops.size();
        int expectedSayi = 45;
        Assert.assertNotEquals(expectedSayi,dropDownList);
    }
    @Test
    public void test2(){
//           1.Kategori menusunden Books secenegini secin
        WebElement ddm = driver.findElement(By.xpath("//*[@id='searchDropdownBox']"));
        ddm.sendKeys("Books");
//           2.Arama kutusuna Java yazin vearatin
        driver.findElement(By.cssSelector("input[id='twotabsearchtextbox']")).sendKeys("Java", Keys.ENTER);
//           3.Bulunan sonuc sayisiniyazdirin
        WebElement sonucYazisi = driver.findElement(By.xpath("//*[@class='a-section a-spacing-small a-spacing-top-small']"));
        System.out.println(sonucYazisi.getText());
//           4.Sonucun Java kelimesini icerdigini testedin
        String expectedKelime = "Java";
        String actualSonucYazisi = sonucYazisi.getText();
        Assert.assertTrue(actualSonucYazisi.contains(expectedKelime));

    }*/

    /*
    /**
selectByVisibleText () / deselectByVisibleText ()   görüntülenen metne göre bir seçeneği seçer / seçimi kaldırır
selectByValue () / deselectByValue ()   "value" öz niteliğinin değerine göre bir seçeneği seçer / seçimi kaldırır
selectByIndex () / deselectByIndex ()   indeksine göre bir seçeneği seçer / seçimi kaldırır
isMultiple ()   açılır öğe bir seferde birden fazla seçime izin veriyorsa, DOĞRU döndürür; Aksi takdirde YANLIŞ
Hiçbirini seçme() önceden seçilen tüm seçeneklerin seçimini kaldırır
 */




}
