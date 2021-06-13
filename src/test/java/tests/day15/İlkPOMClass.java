package tests.day15;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilities.TestBase;

public class İlkPOMClass extends TestBase {
    /*
    1 - https://www.facebook.com/ adresine gidin
2- POM’a uygun olarak email, sifre kutularini ve giris yap butonunu locate edin
3- Faker class’ini kullanarak email ve sifre degerlerini yazdirip, giris butonuna basin
4- Basarili giris yapilamadigini test edin
     */

    @Test
    public void test01(){
        driver.get("https://facebook.com");
        driver.findElement(By.xpath("(//button[@value='1'])[3]")).click();
        WebElement email = driver.findElement(By.id("email"));
    }
}
