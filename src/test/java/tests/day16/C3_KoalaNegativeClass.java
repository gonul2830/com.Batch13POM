package tests.day16;

import org.testng.annotations.Test;
import pages.KoalaResortLoginPage;
import utilities.Driver;
import utilities.TestBase;

public class C3_KoalaNegativeClass extends TestBase {
/*
1 ) Bir Class olustur : NegativeTest
2) Bir test method olustur NegativeLoginTest()
 http://qa-environment.koalaresorthotels.com adresine git
 login butonuna bas
 test data username: manager1 ,
 test data password : manager1!
 Degerleri girildiginde sayfaya girilemedigini test et
 */

    @Test
    public  void negativeText() {
        driver.get("http://qa-environment.koalaresorthotels.com");
        KoalaResortLoginPage obj = new KoalaResortLoginPage(driver);
        obj.ilkLoginLink.click();
        obj.kullaniciAdi.sendKeys("manager1");
        obj.passwordTextBox.sendKeys("manager1!");
        obj.loginButonu.click();
        Driver.closeDriver();
    }
}
