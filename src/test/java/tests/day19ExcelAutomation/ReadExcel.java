package tests.day19ExcelAutomation;

import org.apache.poi.ss.usermodel.*;
import org.testng.annotations.Test;
import utilities.ConfigReader;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ReadExcel {
@Test
    public void readExcel() throws IOException {

    String excelPath = "src/test/resources/ulkeler.xlsx";
    FileInputStream fileInputStream = new FileInputStream(excelPath);

    //excel oldugu icn WOrkBook olusturmamız gerekiyor.

    Workbook workBook = WorkbookFactory.create(fileInputStream);
    // Excel in yapısı geregi sheet secmeliyiz

    Sheet sheet = workBook.getSheet("sayfa1");
    //Sayfadan sonra satıra ulasmalıyız.
    //Satir icin index girmeliyiz , index sıfırdan baslar
    //ornegin 5.satira gitmek istiyorsak; index 4 olur.

    Row row = sheet.getRow(4);
    //Satırdan  sonra cell secmemiz lazım
    //Cell icin index girmeliyiz , index sıfırdan baslar
    //ornegin 4.Cell gitmek istiyorsak; index 3 olur.
    // suanda cell variable'ının icinde workbook/sayfa1/5.satir/4.cell bilgisi var.

     Cell cell = row.getCell(3);

      System.out.println(cell);

}
@Test
    public void readExcel2() throws IOException {
    //1. Method da cell e ulasmak icin fis,workbook,sheet,row ve cell olusturduk
    //ama cell'e ulasmak icin daha kısa bir yol olarak
    //fis ve workbook olusturduktan sonra
    //Cell cell = workbook.getsheet(SayfaADİ).getRow(Row İndex'i).getCell(Cell index'i)
    FileInputStream fileInputStream = new FileInputStream(ConfigReader.getProperty("excel_path"));
    Workbook workbook= WorkbookFactory.create(fileInputStream);
    Cell istenenHucre = workbook.
            getSheet(ConfigReader.getProperty("excel_sayfa_ismi")).
            getRow(Integer.parseInt(ConfigReader.getProperty("excel_satir_index"))).
            getCell(Integer.parseInt(ConfigReader.getProperty("excel_cell_index")));
    System.out.println(istenenHucre);

    // hucredeki bilginin ilk harfini yazdırın.
    //Eger cell deki bilgiyi sadece yazdırmak istersek sout(cell) yazabiliriz
    //Ama cell deki bilgi uzerinde manipulation yapmak istersek
    //        // oncelikle toString() method'u ile Cell'i String'e dataCasting yapmaliyiz

    System.out.println( istenenHucre.toString().charAt(0));

    System.out.println(istenenHucre.toString().substring(0,1));

    //excel  sayfa1'deki satir sayisini bulun

    //workbook.getSheet(ConfigReader.getProperty("excel_sayfa_ismi")).getLastRowNum()

    System.out.println( workbook.getSheet(ConfigReader.getProperty("excel_sayfa_ismi")).getLastRowNum());

   // workbook.getSheet(ConfigReader.getProperty("excel_sayfa_ismi")).getPhysicalNumberOfRows()
    System.out.println(workbook.getSheet(ConfigReader.getProperty("excel_sayfa_ismi")).getPhysicalNumberOfRows());


    System.out.println("2.sayfa son satır index'i " + workbook.getSheetAt(1).getLastRowNum());
    System.out.println("2.sayfa fiziki kullanilan satır sayisi " + workbook.getSheetAt(1).getPhysicalNumberOfRows());

//Excel deki tüm dataları Class'ımıza almak istersek;
    //Excel de bulunan tüm ülkelerin türkce isimlerini yazdırın
//Her satirdaki 2.indexteki bilgi isteniyor.

    for(int index=0;
    index<workbook.getSheetAt(0).getLastRowNum(); index++) {
        System.out.println(workbook.getSheetAt(0).getRow(index).getCell(2));
    }
int sonSatirIndex = workbook.getSheetAt(0).getLastRowNum();

    for(int index =1; index<sonSatirIndex; index++){
        String baskentIsmi = workbook.getSheetAt(0).getRow(index).getCell(2).toString();
        System.out.println((index+1) +" . satırdaki baskent ismi" + baskentIsmi);
    }
//Excel'deki tüm dataları Class'ımıza almak istersek
    //Bunun icin dataları bir java objesine eklememiz gerekir.
    //Boyle bir bilgiyi depolayacagımız java objesi map olabilir.

    Map<String,String> ulkelerMap = new HashMap<>();
    String key = "";
    String value ="";

    for(int index= 1;index<sonSatirIndex; index++){
        key=workbook.getSheetAt(0).getRow(index).getCell(0).toString();
        value=workbook.getSheetAt(0).getRow(index).getCell(1).toString()+", "+
                workbook.getSheetAt(0).getRow(index).getCell(2).toString()+","+
                workbook.getSheetAt(0).getRow(index).getCell(3).toString();

        ulkelerMap.put(key,value);

    }
    System.out.println(ulkelerMap);


    fileInputStream.close();
    workbook.close();
}

}
