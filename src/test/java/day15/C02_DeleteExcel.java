package day15;

import org.apache.poi.ss.usermodel.*;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class C02_DeleteExcel {
    @Test
    public void deleteExcel() throws IOException {
        //-Dosya yolunu bir String degiskene atayalim
        //-FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
        //-Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim
        //-WorkbookFactory.create(fileInputStream)
        //-Sheet objesi olusturun workbook.getSheetAt(Sayfa1)
        //-Row objesi olusturun sheet.getRow(3)
        //-Cell objesi olusturun row.getCell(3)
        String dosyayolu="src/main/resources/ulkeler.xlsx";
        FileInputStream fis=new FileInputStream(dosyayolu);
        Workbook workbook= WorkbookFactory.create(fis);

        Sheet sheet= workbook.getSheet("Sayfa1");
        Row row= sheet.getRow(3);

        Cell cell=row.getCell(3);

        row.removeCell(cell);

        FileOutputStream fos=new FileOutputStream(dosyayolu);
        workbook.write(fos);


        //-3. Satır 3. Cell'deki veriyi silelim
        //-Silindiğini test edin

     /*   System.out.println(workbook.getSheet("Sayfa1").
                getRow(3).
                getCell(4).toString());

      */

        Assert.assertNull(workbook.getSheet("Sayfa1").getRow(3).getCell(3));



    }
}
