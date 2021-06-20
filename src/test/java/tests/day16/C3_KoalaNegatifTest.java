package tests.day16;

import org.testng.annotations.Test;
import pages.KoalaResortLoginPage;
import pages.KoalaResortPage;
import utilities.Driver;
import utilities.TestBase;

public class C3_KoalaNegatifTest extends TestBase {

    /*
    1 ) Bir Class olustur : NegativeTest
    2) Bir test method olustur NegativeLoginTest()
     http://qa-environment.koalaresorthotels.com adresine git
     login butonuna bas
     test data username: manager1 ,
     test data password : manager1!
     Degerleri girildiginde sayfaya girilemedigini test et
     */

    @Test
    public void negatifTest(){
        driver.get("http://qa-environment.koalaresorthotels.com");

        KoalaResortLoginPage koalaResortLoginPage = new KoalaResortLoginPage(driver);
        koalaResortLoginPage.ilkLoginLinki.click();
        koalaResortLoginPage.username.sendKeys("manager1");
        koalaResortLoginPage.password.sendKeys("manager1!");
        koalaResortLoginPage.loginButonu.click();

        Driver.closeDriver();
    }

}
