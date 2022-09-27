package day13;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeClassAfterClass;

public class D18_WebTables_DevamSorusu extends TestBaseBeforeClassAfterClass {
    @Test
    public void test() {
        login();
       // 1. Bir metod oluşturun : printData(int row, int column);
        //a. Satır(row) ve sütun(column) numarasını girdiğinizde, printData metodu bu
        //hücredeki(cell) veriyi yazdırmalıdır.
        int row=5;
        int column=5;
     //  printData(row, column);

       // 2. Baska bir Test metodu oluşturun: printDataTest( );
        printDataTest();


    }

    private void printDataTest() {
        // a. Ve bu metodu printData( ) methodunu cagirmak icin kullanin.
        // b. Örnek: printData (3,5); => 3. satır, 5. Sütundaki veriyi yazdırmalıdır
        int row=3; int column=5;

        String actualData=printData(row,column);

        String expectedData=driver.findElement(By.xpath("//tbody//tr["+row+"]//td["+column+"]")).getText();


        // c. yazdirilan datanin olmasi gereken dataya esit oldugunu test edin

        Assert.assertEquals(expectedData,actualData);

    }

    private String printData(int row, int column) {
        WebElement cellElement= driver.findElement(By.xpath("//tbody//tr["+row+"]//td["+column+"]"));
        System.out.println(cellElement.getText());
        return cellElement.getText();
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
