package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class KoalaResortLoginPage {
    //1 WebDriver olustur
    WebDriver driver;
    //2.Adim : Paremetreli bir constructor olustur
    // ve parametre olarak WebDrevir driver yaz

    public KoalaResortLoginPage(WebDriver driver){

        //3-parametre olarak gelen driver ile bu class daki driver i eslestir
        this.driver= driver;
        // 4-PageFoctory class'ını kullanarak  driver i initilazie yap.
        PageFactory.initElements(driver,this);
    }

    @FindBy (linkText = "Log in")
    public WebElement ilkLoginLink;

    @FindBy (id="UserName")
    public  WebElement kullaniciAdi;


    @FindBy(id="Password")
    public WebElement passwordTextBox;

    @FindBy(id="btnSubmit")
    public WebElement loginButonu;


}
