package day13;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeClassAfterClass;

import java.util.List;

public class D19_WebTablesDemoQA extends TestBaseBeforeClassAfterClass {
    @Test
    public void test() {
        // 1. “https://demoqa.com/webtables” sayfasina gidin
        driver.get("https://demoqa.com/webtables");

        // 2. Headers da bulunan department isimlerini yazdirin
        List<WebElement> header=driver.findElements(By.xpath("//*[@class='rt-td'][6]"));
        header.forEach(t-> System.out.println(t.getText()));

        // 3. sutunun basligini yazdirin
        System.out.println(driver.findElement(By.xpath("//*[text()='Age']")).getText());




    }
    /*



4. Tablodaki tum datalari yazdirin
5. Tabloda kac cell (data) oldugunu yazdirin
6. Tablodaki satir sayisini yazdirin
7. Tablodaki sutun sayisini yazdirin
8. Tablodaki 3.kolonu yazdirin
9. Tabloda "First Name" i Kierra olan kisinin Salary'sini yazdirin
10. Page sayfasinda bir method olusturun, Test sayfasindan satir ve sutun
sayisini girdigimde bana datayi yazdirsin
     */
}
