package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FacebookLoginPage {

    //bu classin  driveri
    WebDriver driver;

    //parametresi driver olan bir constructor olusturduk
    //diger package ersebilsin diye "public"" yaptik
    public FacebookLoginPage(WebDriver driver) {

        //divera simdi deger verecegiz. ve yukaridaki driver ile esitledik
        //Test classindaki driver ile bu driver ayni oldu
        this.driver =driver;

        //PageFactory, Driver a iik deger atamasi yapiyor
        PageFactory.initElements(driver, this);
    }

                //Burada LOCATE leri yapiyoruz //
    //email textbox locate ettik burada
    @FindBy(id ="email")
    public WebElement emailTextBox;

    @FindBy(id="pass")
    public WebElement passwordTextBox;

    @FindBy(xpath = "//button[@name='login']")
    public WebElement loginButon;

}
