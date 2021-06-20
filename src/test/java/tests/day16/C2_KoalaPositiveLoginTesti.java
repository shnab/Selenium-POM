package tests.day16;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import pages.KoalaResortLoginPage;
import pages.KoalaResortPage;
import utilities.Driver;
import utilities.TestBase;

public class C2_KoalaPositiveLoginTesti  {
        // public class C2_KoalaPositiveLoginTesti //extends TestBase


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
    public void pozitifLoginTesti(){

        //Burada Driver.getDriver(). classindan metod ile cagiridk.
       // Driver.getDriver().get("http://qa-environment.koalaresorthotels.com");

        //normalde ew KoalaResortLoginPage(driver) diye cagiyorduk ama sonradan new KoalaResortPage(); olusturdukm ve  driver parametresi olmadan cagirdik
        KoalaResortPage koalaResortPage = new KoalaResortPage();
        //KoalaResortLoginPage koalaResortHotelPage = new KoalaResortLoginPage(driver);
        koalaResortPage.ilkLoginLinki.click();
        koalaResortPage.username.sendKeys("manager");
        koalaResortPage.password.sendKeys("Manager1!");
        koalaResortPage.loginButonu.click();

        /*

      KoalaResortLoginPage koalaResortHotelPage = new KoalaResortLoginPage(driver);

        koalaResortHotelPage.ilkLoginLinki.click();

        //test data username: manager ,
        koalaResortHotelPage.username.sendKeys("manager");

        //test data password : Manager1!
        koalaResortHotelPage.password.sendKeys("Manager1!");

        //Degerleri girildiginde sayfaya basarili sekilde girilebildigini test et
        koalaResortHotelPage.loginButonu.click();

        */



    }



}
