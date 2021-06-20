package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class KoalaResortLoginPage {

    //1.webdriver olustur
    WebDriver driver;

    //2.parametreli public constructor
    //parametre olarak Webdriver driver tyaz

    public KoalaResortLoginPage (WebDriver driver){

        //3. parametre olarak verilen driver ile WebDriver driver; eslestir
        this.driver =driver;

        //4.page fabrikasina git ve
        PageFactory.initElements(driver, this);
    }

    @FindBy(linkText = "Log in")
    public WebElement ilkLoginLinki;

    @FindBy(id ="UserName")
    public WebElement username;

    @FindBy(id="Password")
    public WebElement password;

    @FindBy(id="btnSubmit")
    public WebElement loginButonu;



}
