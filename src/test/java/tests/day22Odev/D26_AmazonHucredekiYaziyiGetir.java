package tests.day22Odev;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;

import java.sql.ClientInfoStatus;
import java.util.*;

public class D26_AmazonHucredekiYaziyiGetir {
    /*
    Soru 2 :
    ➢ AmazonPage sayfasinda istedigim satir ve sutun sayisi ile cagirdigimda bana
    hucredeki yaziyi getirecek bir method olusturun
    ➢ Tests paketi altinda yeni bir class olusturun: D26_AmazonHucreTesti
    ➢ Bu class'in altinda bir test method olusturun : hucretesti() ve webtable'da 3. satir
    2.sutundaki yazinin "Home Services" yazisi icerdigini test edin
    ➢ Yeni bir method olusturun : AmazonYazisi() ve tabloda 9 Hucrede "Amazon" yazisi
    bulundugunu test edin
     */

    AmazonPage amazonPage = new AmazonPage();
    JavascriptExecutor javascriptExecutor = (JavascriptExecutor) Driver.getDriver();

    @Test
    public void hucreTesti() {
        amazonPage.getamazonPage();
        javascriptExecutor.executeScript("arguments[0].scrollIntoView(true);", amazonPage.table);

        amazonPage.homeService.getText(); //

        String actualHucreYazisi = amazonPage.satirSutundakiBilgiyiGetir(Integer.parseInt(ConfigReader.getProperty("satirno")), Integer.parseInt(ConfigReader.getProperty("sutunno")));
        String expectedHucreYazisi = ConfigReader.getProperty("beklenenhucrebilgisi");

        System.out.println(actualHucreYazisi);
        System.out.println("=================");
        System.out.println(expectedHucreYazisi);

        Assert.assertTrue(actualHucreYazisi.contains(expectedHucreYazisi));
    }

    @Test
    public void amazonYazisi() {
        //    ➢ Yeni bir method olusturun : AmazonYazisi() ve tabloda 9 Hucrede "Amazon" yazisi
        //    bulundugunu test edin
        amazonPage.getamazonPage();
        javascriptExecutor.executeScript("arguments[0].scrollIntoView(true);", amazonPage.table);

        List<String> arananKelimeler = new ArrayList<>();
        for (WebElement each : amazonPage.tableTamami) {
            if (each.getText().contains(ConfigReader.getProperty("aranan_kelime"))) {
                arananKelimeler.add(each.getText());
            }
        }
        System.out.println(arananKelimeler.size());

        Assert.assertEquals(arananKelimeler.size(), 10);
    }
}

//    @Test
//    public void amazonYazisiString() {
//        //    ➢ Yeni bir method olusturun : AmazonYazisi() ve tabloda 9 Hucrede "Amazon" yazisi
//        //    bulundugunu test edin
//        amazonPage.getamazonPage();
//        javascriptExecutor.executeScript("arguments[0].scrollIntoView(true);", amazonPage.table);
//
//        Map<String,Integer> myMap = new HashMap<>();
//        List<String> arananKelimeler = new ArrayList<>();
//        for(WebElement each: amazonPage.tableTamamiString){
//            if(each.getText().contains(ConfigReader.getProperty("aranan_kelime"))){
//                arananKelimeler.add(each.getText());
//
//        String str =arananKelimeler.toString();
//        String arr[] = str.split(" ");
//
//            for (int i = 0; i < arr.length; i++) {
//                if (myMap.containsKey(arr[i])) {
//                    myMap.put(arr[i], myMap.get(arr[i]) + 1);
//                } else {
//                    myMap.put(arr[i], 1);
//                }
//            }
//
//            }
//        }
//        System.out.println(arananKelimeler.size());
//        System.out.println(myMap);
//
//}
//}


