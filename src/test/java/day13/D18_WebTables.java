package day13;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeClassAfterClass;

import java.util.List;

public class D18_WebTables extends TestBaseBeforeClassAfterClass {
    @Test
    public void name() {
        // login( ) metodun oluşturun ve oturum açın.
        login();
        
        // table( ) metodu oluşturun
      //  table();

        //printRows( ) metodu oluşturun //tr
        // printRows();

        // printCells( ) metodu oluşturun //td
      //  printCells();

        // printColumns( ) metodu oluşturun
        printColumn();
    }

    private void printColumn() {
        // table body’sinde bulunan toplam sutun(column) sayısını bulun.
        List<WebElement> tableColumnNum=driver.findElements(By.xpath("//tbody//tr[1]//td"));
        System.out.println(tableColumnNum.size());
        System.out.println("******************************");

        // Table body’sinde bulunan sutunlari(column) konsolda yazdırın.
        for (int i = 1; i <= tableColumnNum.size(); i++) {
            List<WebElement> allColumnElements = driver.findElements(By.xpath("//tbody//tr//td[" + i + "]"));
            allColumnElements.forEach(t -> System.out.println(t.getText()));
            System.out.println("**********************");
        }

            // 5.column daki elementleri konsolda yazdırın
           List<WebElement> fifthColumnElements=driver.findElements(By.xpath("//tbody//tr//td[5]"));
           fifthColumnElements.forEach(t-> System.out.println(t.getText()));

    }

    private void printCells() {
        // table body’sinde bulunan toplam hücre(cell) sayısını bulun.
        List<WebElement> allCellsNum=driver.findElements(By.xpath("//tbody//tr//td"));
        System.out.println(allCellsNum.size());
        System.out.println("*****************************");

        allCellsNum.forEach(t-> System.out.println(t.getText()));
    }

    private void printRows() {
        // table body’sinde bulunan toplam satir(row) sayısını bulun.
        List<WebElement> rowNumber=driver.findElements(By.xpath("//tbody//tr"));
        System.out.println(rowNumber.size());
        System.out.println("******************************");

        // Table body’sinde bulunan satirlari(rows) konsolda yazdırın.
        List<WebElement> rowElements=driver.findElements(By.xpath("//tbody//tr"));
        rowElements.forEach(t-> System.out.println(t.getText()));
        System.out.println("********************************");
    }

    private void table() {
        // Tüm table body’sinin boyutunu(sutun sayisi) bulun. /tbody
        List<WebElement> bodyColumnSize=driver.findElements(By.xpath("//tbody//tr[1]//td"));
        System.out.println(bodyColumnSize.size());
        System.out.println("******************************");

        // Table’daki tum body’i ve başlıkları(headers) konsolda yazdırın.
        List<WebElement> tumBody=driver.findElements(By.xpath("//tbody//tr"));
        tumBody.forEach(t-> System.out.println(t.getText())); // tum body
        System.out.println("*****************************");

        WebElement header= driver.findElement(By.xpath("//thead//tr"));
        System.out.println(header.getText());
        System.out.println("****************************");

        System.out.println(driver.findElement(By.xpath("//tbody//tr[4]")).getText());

    }

    private void login() {
        // https://www.hotelmycamp.com admin/HotelRoomAdmin adresine gidin
        //Username : manager
        //Password : Manager1!
        driver.get("https://www.hotelmycamp.com/admin/HotelRoomAdmin");
        driver.findElement(By.xpath("//*[@id='UserName']")).
                sendKeys("manager");
        driver.findElement(By.xpath("//*[@id='Password']")).
                sendKeys("Manager1!");
        driver.findElement(By.xpath("//*[@type='submit']")).click();
    }

}
