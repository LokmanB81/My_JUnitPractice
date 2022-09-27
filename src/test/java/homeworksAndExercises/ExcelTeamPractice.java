package homeworksAndExercises;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBaseBeforeClassAfterClass;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelTeamPractice extends TestBaseBeforeClassAfterClass {
    @Test
    public void test() throws IOException {
        String dosyayolu="src/main/resources/testData.xlsx";
        FileInputStream fis=new FileInputStream(dosyayolu);
        Workbook workbook= WorkbookFactory.create(fis);

    String url=workbook.getSheet("Sheet1").getRow(1).getCell(0).getStringCellValue();
    String userName=workbook.getSheet("Sheet1").getRow(1).getCell(1).getStringCellValue();
    String pasWord=workbook.getSheet("Sheet1").getRow(1).getCell(2).getStringCellValue();

    driver.get(url);
    driver.findElement(By.xpath("//*[@id='UserName']")).sendKeys(userName);
    driver.findElement(By.xpath("//*[@id='Password']")).sendKeys(pasWord);
    driver.findElement(By.xpath("//*[@type='submit']")).click();






    }






    // 1 - resources klasöründeki "testData.xlsx" dosyası, Sheet1 sayfasın üzerinde çalışılacaktır.
    // 2 - Bu Excel dökümanı Sheet1 sayfasında 2. satır, 1.sütunundaki ( A2 ) URL bilgisini bir String değişkene aktarın.
    // 3 - Sayfadaki 2.satırdaki "Kullanıcı Adı" hücresindeki veriyi ( B2 ) bir Stringe aktarın.
    // 4 - Sayfadaki 2.satırdaki "Şifre" hücresindeki veriyi ( C2 ) bir Stringe aktarın.
    // 5 - Excel sayfasındaki istenen URL'ye gidin.
    // 6 - Açılan URL'de User Name ve Pasword kısmına, excel dosyasından aldığınız bilgileri girin. Giriş'e basın
    // 7 - Login olduğunuzu doğrulayın ( Mesela; LIST OF HOTELROOMS yazısı görünüyor ise Login olmuşsunuz demektir )
    // 8 - Login olduğunuz sayfanın ekren resmini alın ve target/screenShot klasörüne kaydedin.
    // 9 - Excel sayfasında 2. Satır 4.Sütuna ( D2 ); "TEST PASSED" yazdırın.
    // 10 - Excel sayfasında 2. Satır 5.Sütuna ( E2 ); ekran resminin dosya adını yazdırın.
    // 11 - Üzerine veri eklediğiniz Excel dosyasını kaydedin.
}
