package tests.day21;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.KoalaResortPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class C2_HtmlRaporDuzenleme extends TestBaseRapor {
    /*
    // 1- Test class'ini extends ile TestBaseRapor Class'ina child yapalim
    // 2- extentTest=extentReports.createTest("Test ismi", "Tanim");  rapor olusturalim
    // 3- Gerekli/istedigimiz satirlara extentTest.info("Aciklama") ekleyelim
    // 4- Assert olan satirda aciklamayi extentTest.pass ile yapabiliriz
     */


    @Test
    public void pozitifLoginTesti() {
        // 2- extentTest=extentReports.createTest("Test ismi", "Tanim");  rapor olusturalim
        extentTest=extentReports.createTest("Smoke", "Gecerli bilgilerle test");

        // 4- Assert olan satirda aciklamayi extentTest.pass ile yapabiliriz

        //Burada Driver.getDriver(). classindan metod ile cagiridk.
        Driver.getDriver().get(ConfigReader.getProperty("kr_url"));

        // 3- Gerekli/istedigimiz satirlara extentTest.info("Aciklama") ekleyelim
        extentTest.info("Koala Resort sayfasina gidildi");

        //normalde ew KoalaResortLoginPage(driver) diye cagiyorduk ama sonradan new KoalaResortPage(); olusturdukm ve  driver parametresi olmadan cagirdik
        KoalaResortPage koalaResortPage = new KoalaResortPage();
        //KoalaResortLoginPage koalaResortHotelPage = new KoalaResortLoginPage(driver);
        koalaResortPage.ilkLoginLinki.click();
        extentTest.info("Login linkine click yapildi");
        koalaResortPage.username.sendKeys(ConfigReader.getProperty("kr_valid_username"));
        extentTest.info("Gecerli kullanici adi yazildi");
        koalaResortPage.password.sendKeys(ConfigReader.getProperty("kr_valid_password"));
        extentTest.info("Gecerli sifre girildi");
        koalaResortPage.loginButonu.click();
        extentTest.info("Login butonuna basildi");
        Assert.assertEquals(Driver.getDriver().getCurrentUrl(), ConfigReader.getProperty("kr_basarili_giris_url"));
        extentTest.pass("Basarili giris yapildigi test edildi");

    }

    @Test
    public void yanlisSifreVeKullaniciAdiTest(){
        //her test ivin bunu ayri ayri yazmak lazim
        extentTest=extentReports.createTest("Smoke", "Gecerli bilgilerle test");

        // http://qa-environment.koalaresorthotels.com adresine git
        Driver.getDriver().get(ConfigReader.getProperty("kr_url"));

        //	login butonuna bas

        KoalaResortPage koalaResortPage=new KoalaResortPage();

        koalaResortPage.ilkLoginLinki.click();

        //test data username: manager ,
        koalaResortPage.username.sendKeys(ConfigReader.getProperty("kr_wrong_username"));

        //test data yanlis password : manager1!

        koalaResortPage.password.sendKeys(ConfigReader.getProperty("kr_wrong_password"));

        //Degerleri girildiginde hata verdigini test et
        koalaResortPage.loginButonu.click();

        Assert.assertFalse(koalaResortPage.girisYapilamadiElementi.isDisplayed());
        extentTest.pass("Basarili giris yapilamadigi test edildi");

        Driver.closeDriver();
    }
}
