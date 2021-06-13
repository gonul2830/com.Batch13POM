package tests.day16;

import org.testng.annotations.Test;
import pages.KoalaResortLoginPage;
import utilities.ConfigReader;
import utilities.TestBase;

public class C4_ConfigKullanmaTesti extends TestBase {

    /*
1 ) Bir Class olustur : PositiveTest
2) Bir test method olustur positiveLoginTest()
 http://qa-environment.koalaresorthotels.com adresine git
 login butonuna bas
 test data username: manager ,
 test data password : Manager1!
 Degerleri girildiginde sayfaya basarili sekilde girilebildigini test et
 */

    @Test
    public void test01(){
        //Kodumuzu tamamen dinamik yapmak icin 3 dataya ihtiyacım var
        //1-locate ===> Bunları Page Class'ından obje üreterek alabilirim
        //2-Test datalari ====> Bunlar icin obje olusturmama gerek yok,

        //ConfigReader Class'ında hersey static oldugu icin
        //sadece Class ismi ile herseye ulabailirim

        driver.get(ConfigReader.getProperty("kr_url"));

        KoalaResortLoginPage koalaResortLoginPage = new KoalaResortLoginPage(driver);
        koalaResortLoginPage.ilkLoginLink.click();
        koalaResortLoginPage.kullaniciAdi.sendKeys(ConfigReader.getProperty("kr_valid_username"));
        koalaResortLoginPage.passwordTextBox.sendKeys(ConfigReader.getProperty("kr_valid_password"));
        koalaResortLoginPage.loginButonu.click();
    }
}
