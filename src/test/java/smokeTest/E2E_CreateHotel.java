package smokeTest;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import pages.KoalaResortPage;
import utilities.ConfigReader;
import utilities.Driver;

public class E2E_CreateHotel {
    /*
    1. Tests packagenin altına class olusturun: D17_CreateHotel
2. Bir metod olusturun: createHotel
3. http://qa-environment.crystalkeyhotels.com adresine git.
4. Username textbox ve password metin kutularını locate edin ve asagidaki verileri
girin.
a. Username : manager
b. Password : Manager2!
5. Login butonuna tıklayın.
6. Hotel Management/Hotel List menusunden ADD HOTEL butonuna tiklayin
7. Açılan sayfadaki tüm metin kutularına istediğiniz verileri girin.
8. Save butonuna tıklayın.
9. “Hotel was inserted successfully” textinin göründüğünü test edin.
10. OK butonuna tıklayın
     */

    @Test
    public void createHotel() throws InterruptedException {
        KoalaResortPage koalaResortPage = new KoalaResortPage();
        koalaResortPage.koalaResortLogin();

        koalaResortPage.hotelManagement.click();
        koalaResortPage.hotelList.click();
        koalaResortPage.addHotel.click();

        Actions actions= new Actions(Driver.getDriver());
        actions.click(koalaResortPage.codeTextBox)
                .sendKeys(ConfigReader.getProperty("kr_code")).perform();
        koalaResortPage.nameTextBox.sendKeys(ConfigReader.getProperty("kr_costumer_name"));
        actions.click(koalaResortPage.nameTextBox)
                .sendKeys(ConfigReader.getProperty("kr_costumer_name")).perform();
        actions.click(koalaResortPage.adressTextBox)
                .sendKeys(ConfigReader.getProperty("kr_costumer_adress")).perform();
        actions.click(koalaResortPage.phoneTextBox)
                .sendKeys(ConfigReader.getProperty("kr_customer_phone")).perform();
        actions.click(koalaResortPage.emailTextBox)
                .sendKeys(ConfigReader.getProperty("kr_customer_email"))
                .perform();
  Thread.sleep(5000);
        Select select = new Select(koalaResortPage.acilirMenu);
        select.selectByVisibleText(ConfigReader.getProperty("kr_dropdown_value"));
        koalaResortPage.saveButonu.click();




    }


}
