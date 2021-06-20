package tests.day16;

import org.testng.annotations.Test;
import pages.KoalaResortLoginPage;
import utilities.ConfigReader;
import utilities.TestBase;

public class C4_ConfigKullanma extends TestBase {

        /*
    1 ) Bir Class olustur : PositiveTest
    2) Bir test method olustur positiveLoginTest()
     http://qa-environment.koalaresorthotels.com adresine git
     login butonuna bas
     test data username: manager ,
     test data password : Manager1!
     Degerleri girildiginde sayfaya basarili sekilde girilebildigini test et
     */

    @Test
    public void test01(){
                //Kodumu tamamen dinamik yapmak icin 3 dataya ihtiyac var
        //1- Locate ==> bunlari Page classindan obje ureterek alabilirz
        //2.Test datalari ==> bUNLAR icin obje olusturmaya gerek yok.
        // ConfigReader classinda hersey static oldugu icin sadece class ismi ile
        // herseye ulasabiliriz.

        //ConfigReader sayfasndan .getProperty() metodunu cagirdik
        driver.get(ConfigReader.getProperty("kr_url"));

        //KoalaResortLoginPage classindan object yaptik.Bu sayfada locate ler var.
        KoalaResortLoginPage koalaResortLoginPage= new KoalaResortLoginPage(driver);

        koalaResortLoginPage.ilkLoginLinki.click();
        koalaResortLoginPage.username.sendKeys(ConfigReader.getProperty("kr_valid_username"));
        koalaResortLoginPage.password.sendKeys(ConfigReader.getProperty("kr_valid_password"));
        koalaResortLoginPage.loginButonu.click();
    }

}
