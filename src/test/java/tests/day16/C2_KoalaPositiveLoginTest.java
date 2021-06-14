package tests.day16;

import org.testng.annotations.Test;
import pages.KoalaResortLoginPage;
import pages.KoalaResortPage;
import utilities.Driver;
import utilities.TestBase;

public class C2_KoalaPositiveLoginTest extends TestBase {
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
    public void positiveLoginTest(){
    Driver.getDriver().get("http://qa-environment.koalaresorthotels.com");

    KoalaResortPage koalaResortPage = new KoalaResortPage();
    koalaResortPage.ilkLoginLink.click();
    koalaResortPage.kullaniciAdi.sendKeys("manager");
    koalaResortPage.passwordTextBox.sendKeys("Manager1!");
    koalaResortPage.loginButonu.click();

    /*
    driver.get("http://qa-environment.koalaresorthotels.com");
    KoalaResortLoginPage obj = new KoalaResortLoginPage(driver);
    obj.ilkLoginLink.click();
    obj.kullaniciAdi.sendKeys("manager");
    obj.passwordTextBox.sendKeys("Manager1!");
    obj.loginButonu.click();

     */
}

}
