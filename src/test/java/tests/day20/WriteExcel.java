package tests.day20;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class WriteExcel {

    @Test
    public void test01() throws IOException {
        String path="src/test/resources/ulkeler.xlsx";
        FileInputStream fileInputStream = new FileInputStream(path);

        Workbook workbook= WorkbookFactory.create(fileInputStream);

        workbook.getSheetAt(0).getRow(0).createCell(6).setCellValue("NUFUSBENİMKİ");
        workbook.getSheetAt(0).getRow(3).createCell(6).setCellValue("100000");
        workbook.getSheetAt(0).getRow(5).createCell(6).setCellValue("125000");

        FileOutputStream fileOutputStream= new FileOutputStream(path);
        workbook.write(fileOutputStream);


    }

}
