package smokeTest;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.KoalaResortPage;
import utilities.ConfigReader;
import utilities.Driver;

public class PositiveLoginTest {

    @Test
    public void positiveLoginTest(){

        /*
        http://qa-environment.koalaresorthotels.com adresine git
        login butonuna bas
    test data username: manager ,
    test data password : Manager1!
    Degerleri girildiginde sayfaya basarili sekilde girilebildigini test et
 */
        Driver.getDriver().get(ConfigReader.getProperty("kr_url"));

        KoalaResortPage koalaResortPage= new KoalaResortPage();
        koalaResortPage.ilkLoginLink.click();
        koalaResortPage.kullaniciAdi.sendKeys(ConfigReader.getProperty("kr_valid_username"));
        koalaResortPage.passwordTextBox.sendKeys(ConfigReader.getProperty("kr_valid_password"));
        koalaResortPage.loginButonu.click();

        Assert.assertEquals(Driver.getDriver().getCurrentUrl(),ConfigReader.getProperty("kr_basarili_giris_url"));
        Driver.closeDriver();

    }
}
