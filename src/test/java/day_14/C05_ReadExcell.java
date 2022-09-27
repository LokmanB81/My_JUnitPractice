package day_14;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class C05_ReadExcell {
    @Test
    public void test1() throws IOException {

        //-Dosya yolunu bir String degiskene atayalim
        //-FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
        //-Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim
        //-WorkbookFactory.create(fileInputStream)
        //-sayfa 2'ye gidip satir sayisinin 6, kullanilan satir sayisinin ise 3 oldugunu test edin



        String dosyayolu="src/main/resources/ulkeler.xlsx";
        FileInputStream fis=new FileInputStream(dosyayolu);
        Workbook workbook= WorkbookFactory.create(fis);

       // System.out.println(workbook.getSheet("Sayfa1").getLastRowNum());

        int satirNum=workbook.getSheet("Sayfa2").getLastRowNum();
        int expectedLasRow=6;
        System.out.println(satirNum);
        Assert.assertEquals(expectedLasRow,satirNum);

        int kullanilanSatir=workbook.getSheet("Sayfa2").getPhysicalNumberOfRows();
        System.out.println(kullanilanSatir);

        Assert.assertEquals(4,kullanilanSatir);


        /*

        Map<String,String> ulkeler=new HashMap<>();

        for (int i = 1; i < 190; i++) {

           String key= workbook.getSheet("Sayfa1").getRow(i).getCell(0).toString();
           String value=workbook.getSheet("Sayfa1").getRow(i).getCell(1)+" "
                   +workbook.getSheet("Sayfa1").getRow(i).getCell(2)+" "
                   +workbook.getSheet("Sayfa1").getRow(i).getCell(3)+" ";
           ulkeler.put(key,value);
        }

        System.out.println(ulkeler);


         */




    }
}
