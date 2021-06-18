package tests.day16;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.FaceBookLoginPage;
import utilities.TestBase;

public class C1_FaceBookLoginTest extends TestBase {

    @Test(groups = {"mini_regression,smoke_test"})
    public void gelenekselTest(){
        driver.get("https://facebook.com");

       WebElement guvenlikButonu= driver.findElement(By.xpath("(//button[@value='1'])[3]"));
       guvenlikButonu.click();

        WebElement emailTextBox = driver.findElement(By.id("email"));
        emailTextBox.sendKeys("gonullltslk@gmail.com");

        WebElement passwordTextBox = driver.findElement(By.id("pass"));
        passwordTextBox.sendKeys("1234");

       WebElement loginButonu = driver.findElement(By.xpath("//button[@name='login']"));
       loginButonu.click();
       driver.close();
    }


    @Test(groups = "mini_regression")
    public void pageIleTest(){
        driver.get("https://facebook.com");
        FaceBookLoginPage faceBookLoginPage   = new  FaceBookLoginPage(driver);
        faceBookLoginPage.guvenlikButonu.click();
        faceBookLoginPage.emailTextBox.sendKeys("gonul@gmail.com");
        faceBookLoginPage.passwordTextBox.sendKeys("12345");
        faceBookLoginPage.loginButonu.click();
        driver.close();
    }


}
