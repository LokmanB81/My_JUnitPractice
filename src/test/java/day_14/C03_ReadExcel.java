package day_14;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C03_ReadExcel {
    @Test
    public void readExcelTest1() throws IOException {
        //- Dosya yolunu bir String degiskene atayalim
        String dosyaYolu="src/main/resources/ulkeler.xlsx";

        //- FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
        FileInputStream fis=new FileInputStream(dosyaYolu);

        //- Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim
        Workbook workbook = WorkbookFactory.create(fis);

        // belirtilen satir no ve sutun no degerlerini parametre olarak alip
    // o cell'deki datayi konsola yazdirin
    // sonra sonucun konsolda yazanla ayni oldugunu dogrulayin

        int satir=12;
        int sutun=2;

        String actualData=workbook.
                getSheet("Sayfa1").
                getRow(satir-1).
                getCell(sutun-1).
                toString();

        System.out.println(actualData);
        String expectedData="Baku";

        Assert.assertEquals(expectedData,actualData);




    }
}
