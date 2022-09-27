package homeworksAndExercises;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeClassAfterClass;

import java.util.List;
import java.util.Set;

public class WebTables extends TestBaseBeforeClassAfterClass {
    @Test
    public void test() {
        //https://qa-environment.concorthotel.com/admin/HotelRoomAdmin adresine gidin
        driver.get("https://www.hotelmycamp.com/admin/HotelRoomAdmin");
        driver.findElement(By.xpath("//*[@id='UserName']")).
                sendKeys("manager");
        driver.findElement(By.xpath("//*[@id='Password']")).
                sendKeys("Manager1!");
        driver.findElement(By.xpath("//*[@type='submit']")).click();

        //Tüm table body’sinin boyutunu(sutun sayisi) bulun. /tbody
      /*  List<WebElement> sutunSayisi=driver.findElements(By.xpath("//thead//th"));
        System.out.println("sutunSayisi.size() = " + sutunSayisi.size());

        // Table’daki tum body’i ve başlıkları(headers) konsolda yazdırın.
        List<WebElement> tumBody=  driver.findElements(By.xpath("//tbody//tr"));
        tumBody.forEach(t-> System.out.println(t.getText()));

       List< WebElement> basliklar= driver.findElements(By.xpath("//thead//th"));
      //  System.out.println("basliklar.getText() = " + basliklar.getText());
        basliklar.forEach(t-> System.out.print(t.getText()+" "));

       */

        //table body’sinde bulunan toplam hücre(cell) sayısını bulun.
        List<WebElement> tumHucreSayisi=driver.findElements(By.xpath("//tbody//td"));
        System.out.println("sutunSayisi.size() = " + tumHucreSayisi.size());

        //Table body’sinde bulunan hücreleri(cells) konsolda yazdırın.

        List<WebElement> tumElemanlar=driver.findElements(By.xpath("//tbody//tr"));
        tumElemanlar.forEach(t-> System.out.println(t.getText()));

        



         /*




○
○
● printRows( ) metodu oluşturun //tr
○ table body’sinde bulunan toplam satir(row) sayısını bulun.
○ Table body’sinde bulunan satirlari(rows) konsolda yazdırın.
○ 4.satirdaki(row) elementleri konsolda yazdırın.
● printCells( ) metodu oluşturun //td
○
○
● printColumns( ) metodu oluşturun
○ table body’sinde bulunan toplam sutun(column) sayısını bulun.
○ Table body’sinde bulunan sutunlari(column) konsolda yazdırın.
○
         */
    }
}
