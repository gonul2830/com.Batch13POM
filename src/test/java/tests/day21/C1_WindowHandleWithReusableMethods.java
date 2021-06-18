package tests.day21;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.Set;

public class C1_WindowHandleWithReusableMethods {
    @Test
    public void test01(){
        Driver.getDriver().get("https://the-internet.herokuapp.com/iframe");
        //Ben click yapmadan var olan Window un handle'ini alsam

        String ilkSayfaHandleDeger = Driver.getDriver().getWindowHandle();


        Driver.getDriver().findElement(By.linkText("Elemental Selenium")).click();

       // System.out.println(Driver.getDriver().getTitle());
        //Elemental Selenium: Receive a Free, Weekly Tip on Using Selenium like a Pro
        //Sauce Labs
       ReusableMethods.switchToWindow("Elemental Selenium: Receive a Free, Weekly Tip on Using Selenium like a Pro");


/*
        //ESKİDEN KULLANDIGIMIZ KODLAR
        //click yaptıktan sonra tüm handle degerlerini alsam;
        Set<String> handleListesi =  Driver.getDriver().getWindowHandles();

        //Elimizde icinde 2 handle degeri bulunan bir set var
        //Bunlardan biri ilk sayfanin handle degeri
        //ikinci sayfanin handle degerini nasil bulabilirim (for each ile yapabilrim)
        String ikinciSayfaHandleDegeri="";
        for (String each:handleListesi) {
            if(!each.equals(ilkSayfaHandleDeger)){
                ikinciSayfaHandleDegeri = each;
            }
        }
        Driver.getDriver().switchTo().window(ikinciSayfaHandleDegeri);
        System.out.println(Driver.getDriver().getTitle());



 */

        WebElement souceLabYazisi = Driver.getDriver().findElement(By.xpath("//a[text()='Sauce Labs']"));
        System.out.println(souceLabYazisi.getText());
        Driver.closeDriver();

    }

}
