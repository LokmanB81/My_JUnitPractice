package day15;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C01_ReadExcel {
    @Test
    public void test1() throws IOException {
        String dosyayolu="src/main/resources/ulkeler.xlsx";
        FileInputStream fis=new FileInputStream(dosyayolu);
        Workbook workbook= WorkbookFactory.create(fis);

        int lastRowNum=workbook.getSheet("Sayfa1").getLastRowNum();

        for (int i = 0; i <lastRowNum ; i++) {
            for (int j = 1; j < 4; j++) {
                System.out.println(workbook.getSheet("Sayfa1").getRow(i).getCell(j).toString());

            }
        }
    }
}
