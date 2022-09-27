package homeworksAndExercises;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelBosHucreYazdirma {
    @Test
    public void test() throws IOException {
        String dosyayolu="src/main/resources/ulkeler.xlsx";
        FileInputStream fis=new FileInputStream(dosyayolu);
        Workbook workbook= WorkbookFactory.create(fis);

        String bosHucre= workbook.
                getSheet("Sayfa1")
                .getRow(1)
                .getCell(10).getStringCellValue();

        System.out.println(bosHucre);
    }
}
