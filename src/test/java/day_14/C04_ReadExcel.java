package day_14;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C04_ReadExcel {
    @Test
    public void readExcelTest1() throws IOException {
        //-Dosya yolunu bir String degiskene atayalim
        String dosyayolu="src/main/resources/ulkeler.xlsx";
        //-FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
        FileInputStream fis=new FileInputStream(dosyayolu);
        //-Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim
        Workbook workbook= WorkbookFactory.create(fis);

        //-Baskent (Turkce)  sutununu yazdiralim
        int sonSatir=workbook.getSheet("Sayfa1").getLastRowNum();// getLastRowNum() metodu bize
                                                                    // excel sayfasindaki tum satir numarasini verir
        System.out.println(sonSatir);

        String baskentlerTurkce="";

        for (int i = 1; i <= sonSatir; i++) {

            baskentlerTurkce=workbook.getSheet("Sayfa1").getRow(i).getCell(3).toString();
            System.out.println("turkceBaskentler = " + baskentlerTurkce);

        }

    }
}
