package tests.day22Odev;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import pages.KoalaResortPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class D26_HtmlRaporDuzenlemeAmazon extends TestBaseRapor {
    /*
    // 1- Test class'ini extends ile TestBaseRapor Class'ina child yapalim
    // 2- extentTest=extentReports.createTest("Test ismi", "Tanim");  rapor olusturalim
    // 3- Gerekli/istedigimiz satirlara extentTest.info("Aciklama") ekleyelim
    // 4- Assert olan satirda aciklamayi extentTest.pass ile yapabiliriz
     */

    AmazonPage amazonPage =new AmazonPage();

    @Test
    public void satirSayisi(){
        // 2- extentTest=extentReports.createTest("Test ismi", "Tanim");  rapor olusturalim
        extentTest=extentReports.createTest("Smoke", "Gecerli bilgilerle test");
        //➢ Bu class'in altinda bir test method olusturun : satirSayisi() ve webtable'da 10 satir
        //oldugunu test edin
        amazonPage.getamazonPage();
        extentTest.info("Amazon sayfasina gidildi");
        amazonPage.altaGitTabloyuBul();
        extentTest.info("Table bulundu");
        System.out.println(amazonPage.tableSatirSayilari.size());
        extentTest.info("TABLE satir sayilari alindi");

        Assert.assertEquals(amazonPage.tableSatirSayilari.size(), Integer.parseInt(ConfigReader.getProperty("amazon_beklenentablesatirsayisi")));
        extentTest.pass("Beklenen satir sayisi test edildi");
    }

    @Test
    public void sutunSayisi(){
        // 2- extentTest=extentReports.createTest("Test ismi", "Tanim");  rapor olusturalim
        extentTest=extentReports.createTest("Smoke", "Gecerli bilgilerle test");
        //➢ Yeni bir method olusturun : sutunSayisi() ve yazi olan sutun sayisinin 7oldugunu test
        //edin
        amazonPage.getamazonPage();
        extentTest.info("Amazon sayfasina gidildi");
        amazonPage.altaGitTabloyuBul();
        extentTest.info("Table bulundu");
        int actualDoluSutunSayisi = ReusableMethods.getElementsText(amazonPage.tumDoluSutunSayilari).size();
        int expectedDoluSutunSayisi = Integer.parseInt(ConfigReader.getProperty("amazon_beklenentablesutunsayisi"));

        System.out.println("Actual sutun sayisi : " + actualDoluSutunSayisi);
        System.out.println("Ici dolu olmasi gereken sutun sayisi : " + expectedDoluSutunSayisi);

        Assert.assertEquals(actualDoluSutunSayisi, expectedDoluSutunSayisi);
        extentTest.pass("Beklenen sutun sayisi test edildi");

    }

}
