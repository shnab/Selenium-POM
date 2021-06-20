package tests.day22Odev;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class D26_AmazonHucreTesti {
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
Soru 2 :
➢ AmazonPage sayfasinda istedigim satir ve sutun sayisi ile cagirdigimda bana
hucredeki yaziyi getirecek bir method olusturun
➢ Tests paketi altinda yeni bir class olusturun: D26_AmazonHucreTesti
➢ Bu class'in altinda bir test method olusturun : hucretesti() ve webtable'da 3. satir
2.sutundaki yazinin "Home Services" yazisi icerdigini test edin
➢ Yeni bir method olusturun : AmazonYazisi() ve tabloda 9 Hucrede "Amazon" yazisi
bulundugunu test edin
Soru 3 :
➢ Amazon uzerine yapilan 4 testi otomatik olarak calistiracak xml kodunu yazin ve
calistirin
➢ D26_AmazonSatirSutunSayisi class'indan satirSayisi() testini ve
D26_AmazonHucreTesti class'indan hucretesti() testini calistiracak xml kodunu yazin
ve calistirin
Soru 4 :
➢ D26_AmazonSatirSutunSayisi class'indan satirSayisi() testini ve
D26_AmazonHucreTesti class'indan hucretesti() testini rapor alacak sekilde hazirlayin
ve 3.sorudaki xml dosyasi ile calistirip raporu olusturun
     */


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

    @Test
    public void satirSayisi(){
       //➢ Bu class'in altinda bir test method olusturun : satirSayisi() ve webtable'da 10 satir
        //oldugunu test edin
        amazonPage.getamazonPage();
        amazonPage.altaGitTabloyuBul();
        System.out.println(amazonPage.tableSatirSayilari.size());

        Assert.assertEquals(amazonPage.tableSatirSayilari.size(), Integer.parseInt(ConfigReader.getProperty("amazon_beklenentablesatirsayisi")));
    }

    @Test
    public void sutunSayisi(){
        //➢ Yeni bir method olusturun : sutunSayisi() ve yazi olan sutun sayisinin 7oldugunu test
        //edin
        amazonPage.getamazonPage();
        amazonPage.altaGitTabloyuBul();
        int actualDoluSutunSayisi = ReusableMethods.getElementsText(amazonPage.tumDoluSutunSayilari).size();
        int expectedDoluSutunSayisi = Integer.parseInt(ConfigReader.getProperty("amazon_beklenentablesutunsayisi"));

        Assert.assertEquals(actualDoluSutunSayisi, expectedDoluSutunSayisi);

        System.out.println("Actual sutun sayisi : " + actualDoluSutunSayisi);
        System.out.println("Ici dolu olmasi gereken sutun sayisi : " + expectedDoluSutunSayisi);

    }

}
