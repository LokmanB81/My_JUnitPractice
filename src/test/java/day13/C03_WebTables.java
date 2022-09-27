package day13;

import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBaseBeforeClassAfterClass;

public class C03_WebTables extends TestBaseBeforeClassAfterClass {
    @Test
    public void test() {
        //Bir onceki class'taki adrese gidelim
        // sayfaya giris yapalim
        //Username : manager
        //Password : Manager1!
        // https://www.hotelmycamp.com admin/HotelRoomAdmin adresine gidin
        driver.get("https://www.hotelmycamp.com/admin/HotelRoomAdmin");
        driver.findElement(By.xpath("//*[@id='UserName']")).
                sendKeys("manager");
        driver.findElement(By.xpath("//*[@id='Password']")).
                sendKeys("Manager1!");
        driver.findElement(By.xpath("//*[@type='submit']")).click();

       // input olarak verilen satir ve sutun sayisina sahip
       // cell'deki texti yazdiralim.

       // int satir = 3;
      //  int sutun = 4;
        /*
        String element=driver.findElement(By.xpath("//tbody//tr[3]//td[4]")).getText();
        System.out.println("3*4. cell : "+element);

         */


        for (int i = 1; i < 11; i++) {
            if (driver.findElement(By.xpath("//tbody//tr[" + i + "]//td[4]")).getText().equals("gonca")) {
                System.out.println(driver.findElement(By.xpath("//tbody//tr[" + i + "]//td[2]")).getText());
            }
        }

    }
}
