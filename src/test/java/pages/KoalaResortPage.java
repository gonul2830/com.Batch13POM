package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ConfigReader;
import utilities.Driver;

import java.util.List;

public class KoalaResortPage {

    public KoalaResortPage (){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(linkText = "Log in")
    public WebElement ilkLoginLink;

    @FindBy (id="UserName")
    public  WebElement kullaniciAdi;


    @FindBy(id="Password")
    public WebElement passwordTextBox;

    @FindBy(id="btnSubmit")
    public WebElement loginButonu;

    @FindBy(xpath = "//*[.='Try again please']")
    public WebElement girisYapilamadiElementi;

    @FindBy (xpath = "//*[text()='Hotel Management']")
    public WebElement hotelManagement;

    @FindBy (partialLinkText = "Hotel List")
    public WebElement hotelList;

    @FindBy (xpath = "//*[text()='Add Hotel ']")
    public WebElement addHotel;

    @FindBy(xpath = "//input[@id='Code']")
    public WebElement codeTextBox;

    @FindBy(xpath = "//input[@id='Name']")
    public WebElement nameTextBox;

    @FindBy(xpath = "//input[@id='Address']")
    public WebElement adressTextBox;

    @FindBy(xpath = "//input[@id='Phone']")
    public WebElement phoneTextBox;

    @FindBy(xpath = "//input[@id='Email']")
    public WebElement emailTextBox;

    @FindBy(id = "IDGroup")
    public WebElement acilirMenu;

    @FindBy(id = "btnSubmit")
    public WebElement saveButonu;

    @FindBy(xpath = "//div[text()='Hotel was inserted successfully']")
    public WebElement sonucYazisiElementi;

    @FindBy(xpath = "//*[text()='OK']")
    public WebElement sonOKButonu;

    @FindBy(partialLinkText = "Hotel Rooms")
    public WebElement hotelRooms;

    @FindBy(xpath = "//*[text()='Add Hotelroom ']")
    public WebElement addHotelRoom;

    @FindBy(id = "IDHotel")
    public WebElement idHotelDropdown;

    @FindBy(xpath = "//textarea[@dir='ltr']")
    public WebElement roomTextBox;

    @FindBy(linkText = "500")
    public WebElement fiyatBesYuzButonu;

    @FindBy(id = "Price")
    public WebElement priceTextBox;

    @FindBy(id = "IDGroupRoomType")
    public WebElement roomTypeDropdown;

    @FindBy(id = "MaxAdultCount")
    public WebElement maxAdultCount;

    @FindBy(id = "MaxChildCount")
    public WebElement maxChildCount;

    @FindBy(xpath = "//*[text()='HotelRoom was inserted successfully']")
    public WebElement roomCreatedElementi;

    @FindBy(xpath = "//button[@class='btn btn-primary']")
    public WebElement roomCreateSonOK;

    @FindBy(partialLinkText = "Hotel Rooms")
    public WebElement hotelRoomsButonu;

    @FindBy(xpath = "(//*[text()='List Of Hotelrooms'])[2]")
    public WebElement hotelRoomListYaziElementi;


    @FindBy(xpath="//tbody//tr[1]//td")
    public List<WebElement> birinciSatirDatalar;


    @FindBy(xpath ="//thead//tr[1]//th" )
    public  List<WebElement>sutunBasliklari;

    @FindBy(xpath="//tbody")
public WebElement tbodyWebelement;

@FindBy(xpath = "//tbody//td")
public List<WebElement>bodydekiTumdataListesi;

@FindBy(xpath = "//tbody//tr")
public List<WebElement>satirlarListesi;



public void koalaResortLogin(){
    Driver.getDriver().get(ConfigReader.getProperty("kr_url"));
    ilkLoginLink.click();
    kullaniciAdi.sendKeys(ConfigReader.getProperty("kr_valid_username"));
    passwordTextBox.sendKeys(ConfigReader.getProperty("kr_valid_password"));
    loginButonu.click();
}

public void istenenSatiriYazdir(int satirNo){
   //=====mesela dorduncu sat??r dendiginde degisen yer sadece sayi (indexin icindeki)===//tbody//tr[3]

    String satirXPath = "//tbody//tr["+ (satirNo-1) +"]";

    System.out.println(Driver.getDriver().findElement(By.xpath(satirXPath)).getText());
}


    public void sutunYazdir(int sutunNo){
        // ornek : her hangi bir satirdaki 2.sutunu bulmak istersek //tbody//tr//td[2] yazabiliriz

        String sutunPath= "//tbody//tr//td["+sutunNo+"]";


        WebElement sutunBasligi=Driver.getDriver().findElement(By.xpath("//thead//th[" + sutunNo + "]"));
        System.out.println(sutunBasligi.getText());

        List<WebElement> istenenSutunListeOlarak=Driver.getDriver().findElements(By.xpath(sutunPath));

        for (WebElement each: istenenSutunListeOlarak
        ) {
            System.out.println(each.getText());
        }


    }

    public String dataStringBul(int satirNo, int sutunNo){
        // ornek : her 3. satirdaki 2.sutunu bulmak istersek //tbody//tr[3]//td[2] yazabiliriz
        String dataPath="//tbody//tr["+ satirNo +"]//td["+sutunNo+"]";

        return Driver.getDriver().findElement(By.xpath(dataPath)).getText();
    }

    public WebElement dataWebelementiBul(int satirNo, int sutunNo){
        // ornek : her 3. satirdaki 2.sutunu bulmak istersek //tbody//tr[3]//td[2] yazabiliriz
        String dataPath="//tbody//tr["+ satirNo +"]//td["+sutunNo+"]";

        return Driver.getDriver().findElement(By.xpath(dataPath));
    }

    public void istenenHucreyiYazdir(int satirNo, int sutunNo){

        // ornek : 5.satir 4 sutunu yazdir  //tbody//tr[   5   ]//td[   4    ]

        String hucreXPath= "//tbody//tr["+ satirNo +"]//td["+ sutunNo + "]";

        WebElement istenenDataElementi= Driver.getDriver().findElement(By.xpath(hucreXPath));

        System.out.println(istenenDataElementi.getText());
    }



}
