package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FaceBookLoginPage {
    WebDriver driver;

  public FaceBookLoginPage(WebDriver driver){
  this.driver=driver;

      PageFactory.initElements(driver,this);

    }

    @FindBy(id="email")
   public WebElement emailTextBox;


  @FindBy(id="pass")
  public WebElement passwordTextBox;

@FindBy(xpath="//button[@name='login']")
    public WebElement loginButonu;

@FindBy(xpath="(//button[@value='1'])[3]")
    public WebElement guvenlikButonu;
}
