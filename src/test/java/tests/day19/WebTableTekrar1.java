package tests.day19;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.KoalaResortPage;
import utilities.ConfigReader;
import utilities.Driver;

public class WebTableTekrar1 {

    //1. Bir metod oluşturun : printData(int row, int column);
    //  a. Satır(row) ve sütun(column) numarasını girdiğinizde,
    //  printData metodu bu     hücredeki(cell) veriyi yazdırmalıdır.
    //2. Baska bir Test metodu oluşturun: printDataTest();
    //  a. Ve bu metodu printData() methodunu cagirmak icin kullanin.
    //  b. Örnek: printData (3,5); => 3. satır, 5. Sütundaki veriyi yazdırmalıdır
    //  c. yazdirilan datanin olmasi gereken dataya esit oldugunu test edin
    @Test
            public void test01() {
        KoalaResortPage koalaResortPage = new KoalaResortPage();
        koalaResortPage.koalaResortLogin();

        koalaResortPage.istenenHucreyiYazdir(5,4);

        //5. satir 4. sütündaki bilginin Lucio McKenzie Md oldugunu test edin
        //========>  //tbody//tr[5]//td[4]
        String  actualHucreYazisi = koalaResortPage.dataStringBul(5,4);
        Assert.assertEquals(actualHucreYazisi, ConfigReader.getProperty("webTableExpectedData"));

        Driver.closeDriver();
    }
}
