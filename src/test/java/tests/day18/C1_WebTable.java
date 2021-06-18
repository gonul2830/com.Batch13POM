package tests.day18;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.KoalaResortPage;
import utilities.Driver;

public class C1_WebTable {
    /*
    ● login() metodun oluşturun ve oturum açın.
● http://qa-environment.koalaresorthotels.com /admin/HotelRoomAdmin adresine gidin
 ○ Username : manager
 ○ Password : Manager1!
● table() metodu oluşturun
 ○ Tüm table body’sinin boyutunu(sutun sayisi) bulun. /tbody
 ○ Table’daki tum body’I ve başlıkları(headers) konsolda yazdırın.
● printRows() metodu oluşturun //tr
 ○ table body’sinde bulunan toplam satir(row) sayısını bulun.
 ○ Table body’sinde bulunan satirlari(rows) konsolda yazdırın.
 ○ 4.satirdaki(row) elementleri konsolda yazdırın.
     */
    @Test(groups = "mini_regression")
    public void table(){
        KoalaResortPage koalaResortPage = new KoalaResortPage();
        koalaResortPage.koalaResortLogin();

        /*
        //tbody//tr[1]//td bu body deki 1.satırdaki data sayısını veriyot.
        bu
         */
        System.out.println("tablodaki sutun sayisi = " + koalaResortPage.birinciSatirDatalar.size());


        //System.out.println(koalaResortPage.sutunBasliklari);
        //Listemiz Webelementlerden olustugu icin direk yazdıramayız.
        // Yazdırmak icin for each ile her bir webelementi alıp ustundeki texti yazdirmamiz lazim

        for (WebElement w: koalaResortPage.sutunBasliklari
             ) {
            System.out.println(w.getText());
        }


        System.out.println(koalaResortPage.tbodyWebelement.getText());
        //Eger tüm body'i tek bir webElement olarak locate eder ve yazdırırsanız
        // tüm bu body i görebiliriz
        //ancak bu cok kullanılmaz cünkü bu durumda satır,sutun veya dataları ayirma sansımız yoktur
        //tüm body tek bir element olarak yazdırılabilinir ama islem yapmak zordur.
        //Bodynin icinde bulunan td sayisini bulmak icin //tbody//td locateni kullanacagız


        System.out.println("Tablo bodysinde bulunan cell sayisi: " + koalaResortPage.bodydekiTumdataListesi.size());
        Driver.closeDriver();
        }

    @Test (groups = "smoke_test")
    public void getRow(){
        /*
         printRows() metodu oluşturun //tr
 ○ table body’sinde bulunan toplam satir(row) sayısını bulun.
 ○ Table body’sinde bulunan satirlari(rows) konsolda yazdırın.
 ○ 4.satirdaki(row) elementleri konsolda yazdırın.
         */

        KoalaResortPage koalaResortPage = new KoalaResortPage();
        koalaResortPage.koalaResortLogin();
         //  ○ table body’sinde bulunan toplam satir(row) sayısını bulun.

        //======>  //tbody//tr bize birinci satırları verir

        System.out.println("tablodaki satir sayisi: "+ koalaResortPage.satirlarListesi.size());
        System.out.println("========================");
//○ Table body’sinde bulunan satirlari(rows) konsolda yazdırın.
        for (WebElement w : koalaResortPage.satirlarListesi
             ) {
            System.out.println(w.getText());
        }
        System.out.println("============================");

        //○ 4.satirdaki(row) elementleri konsolda yazdırın.
        System.out.println(koalaResortPage.satirlarListesi.get(3).getText());


        //Bir Liste olusturmadan, parametre olarak satır numarası kabul edip
        //girilen numaradaki satiri yazdıran bir method yazınız.

        // ornek 5.satir desem locate //tbody//tr[4]

        //7. satiri yazdiralim
        System.out.println("=======================");
        koalaResortPage.istenenSatiriYazdir(7);
        Driver.closeDriver();

    }


}
