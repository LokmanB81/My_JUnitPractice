package day13;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeClassAfterClass;

import java.util.List;

public class C02_WebTables extends TestBaseBeforeClassAfterClass {
    @Test
    public void test() {
        // https://www.hotelmycamp.com admin/HotelRoomAdmin adresine gidin
        driver.get("https://www.hotelmycamp.com/admin/HotelRoomAdmin");

        //login( ) metodun oluşturun ve oturum açın.
        login();

        // table( ) metodu oluşturun
       // table();

       // printRows( ) metodu oluşturun //tr
      //  printRows();

        // printCells( ) metodu oluşturun //td
       // printCells();

        //printColumns( ) metodu oluşturun
        printColumns();


    }

    private void printColumns() {
        //table body’sinde bulunan toplam sutun(column) sayısını bulun.
        List<WebElement> sutunSayisi=driver.findElements(By.xpath("//thead//th"));
        System.out.println("sutunSayisi.size() = " + sutunSayisi.size());

        //Table body’sinde bulunan sutunlari(column) konsolda yazdırın.
        WebElement sutun= driver.findElement(By.xpath("//tbody//td"));
        System.out.println("sutun.getText() = " + sutun.getText());
        List<WebElement> sutunElements=driver.findElements(By.xpath("//thead//td"));
        sutunElements.forEach(t-> System.out.println(t.getText()));

        //5.column daki elementleri konsolda yazdırın
        List<WebElement> sutunElementleri5=driver.findElements(By.xpath("//tbody//tr//td[5]"));
        sutunElementleri5.forEach(t-> System.out.println(t.getText()));


    }



    private void printCells() {
    // table body’sinde bulunan toplam hücre(cell) sayısını bulun.
        List<WebElement> totalCells=driver.findElements(By.xpath("//tbody//tr//td"));
        System.out.println("totalCells sayisi= " + totalCells.size());

        // Table body’sinde bulunan hücreleri(cells) konsolda yazdırın.
        totalCells.forEach(t-> System.out.println(t.getText()));
    }

    private void printRows() {
        // table body’sinde bulunan toplam satir(row) sayısını bulun.
        List<WebElement> satirSayisi=driver.findElements(By.xpath("//tbody//tr"));
        System.out.println("satirSayisi.size = " + satirSayisi.size());

        //Table body’sinde bulunan satirlari(rows) konsolda yazdırın.
        satirSayisi.forEach(t-> System.out.println(t.getText()));

     /*   for (WebElement each:satirSayisi
             ) {
            System.out.println(each.getText());
        }

      */

        //4.satirdaki(row) elementleri konsolda yazdırın
       // System.out.println(satirSayisi.get(3).getText());
        System.out.println("*****************");
        System.out.println(driver.findElement(By.xpath("//tbody//tr[4]")).getText());

    }

    private void table() {
        // Tüm table body’sinin boyutunu(sutun sayisi) bulun. /tbody

        List<WebElement> sutunSayisi=driver.findElements(By.xpath("//thead//tr//th"));
        System.out.println("sutunSayisi.size = " + sutunSayisi.size());


        // Table’daki tum body’I ve başlıkları(headers) konsolda yazdırın.
       WebElement basliklar=driver.findElement(By.xpath("//thead//tr"));
        System.out.println(basliklar.getText());
        System.out.println("******************");

        WebElement body= driver.findElement(By.xpath("//tbody"));
        System.out.println(body.getText());
     /*   for (WebElement each:sutunSayisi
             ) {
            System.out.println(each.getText());
        }

      */
    }

    private void login() {
        //Username : manager
        //Password : Manager1!
        driver.findElement(By.xpath("//*[@id='UserName']")).
                sendKeys("manager");
        driver.findElement(By.xpath("//*[@id='Password']")).
                sendKeys("Manager1!");
        driver.findElement(By.xpath("//*[@type='submit']")).click();
    }
    /*
Tabloda <table> tagı altında tablonun baslıgını gosteren <thead> tagı bulunur.
Eger baslikda satir(row) varsa <thead> tagı altinda <tr> (satır-row) tagı vardır.
Ve baslıkdaki sutunlara yani hucrelere(cell) de <th> tagı ile ulasilir.
Baslıgın tablodaki verilere <tbody> tagı ile altındaki satırlara(row) <tr> tagı ile sutunlara yani
hucrelere <td> tagı ile ulasilir.
 */
}
