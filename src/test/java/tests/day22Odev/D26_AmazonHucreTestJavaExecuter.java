package tests.day22Odev;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;

public class D26_AmazonHucreTestJavaExecuter {
         /*
        Soru 1 :
➢ Amazon anasayfaya gidebilecek sekilde bir page sayfasi olusturun : AmazonPage
➢ Amazon ana sayfasinda en altta bulunan Webtable'i inceleyebilmek icin AmazonPage
clasinda en altta gitme isini yapacak bir method olusturun
➢ Tests paketi altinda yeni bir class olusturun: D26_AmazonSatirSutunSayisi
➢ Bu class'in altinda bir test method olusturun : satirSayisi() ve webtable'da 10 satir
oldugunu test edin
➢ Yeni bir method olusturun : sutunSayisi() ve yazi olan sutun sayisinin 7oldugunu test
edin
     */

    AmazonPage amazonPage =new AmazonPage();

    JavascriptExecutor javascriptExecutor = (JavascriptExecutor) Driver.getDriver();

    @Test
    public void satirSayisi(){
        //➢ Bu class'in altinda bir test method olusturun : satirSayisi() ve webtable'da 10 satir
        //oldugunu test edin
        amazonPage.getamazonPage();
       // amazonPage.altaGitTabloyuBul();
        //javascriptExecutor  sayfayi direkt locate edilen asagidaki kisma goturur.
        javascriptExecutor.executeScript("arguments[0].scrollIntoView(true);",amazonPage.table);

        System.out.println(amazonPage.tableSatirSayilari.size());

        Assert.assertEquals(amazonPage.tableSatirSayilari.size(), Integer.parseInt(ConfigReader.getProperty("amazon_beklenentablesatirsayisi")));
    }

}
