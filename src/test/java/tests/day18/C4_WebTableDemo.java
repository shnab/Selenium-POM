
    package tests.day18;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.DemoqaPage;
import utilities.ConfigReader;
import utilities.Driver;

import java.util.List;

    public class C4_WebTableDemo {
        //Benim odev calismam
    /*
    Bir Class olusturun D19_WebtablesHomework
  1. “https://demoqa.com/webtables” sayfasina gidin
  2. Headers da bulunan department isimlerini yazdirin
  3. sutunun basligini yazdirin
  4. Tablodaki tum datalari yazdirin
  5. Tabloda kac cell (data) oldugunu yazdirin
  6. Tablodaki satir sayisini yazdirin
  7. Tablodaki sutun sayisini yazdirin
  8. Tablodaki 3.kolonu yazdirin
  9. Tabloda "First Name" i Kierra olan kisinin Salary'sini yazdirin
10. Page sayfasinda bir method olusturun, Test sayfasindan satir ve sutun sayisini girdigimde bana datayi yazdirsin
     */

        @Test
        public void demoQa(){
            //1-“https://demoqa.com/webtables” sayfasina gidin
            Driver.getDriver().get(ConfigReader.getProperty("demoqa_url"));

            //2. Headers da bulunan department isimlerini yazdirin
            DemoqaPage demoqaPage= new DemoqaPage();
            List<WebElement> headerListe = demoqaPage.headerList;
            for(WebElement each: headerListe){
                System.out.println(each.getText());
            }

            //3. sutunun basligini yazdirin
            System.out.println("3. sutun basligi: " + demoqaPage.headerList.get(2).getText());

            //4.Tablodaki tum datalari yazdirin
            System.out.println("Tablodaki tum elemanlar : " + demoqaPage.tumBodyElementi.getText());

            //5. Tabloda kac cell (data) oldugunu yazdirin
            for (WebElement each: demoqaPage.tumHucrelerListesi
            ) {
                System.out.println(each.getText());
            }
            System.out.println("tablodaki tum hucre sayisi : " + demoqaPage.tumHucrelerListesi.size());

            //  6. Tablodaki satir sayisini yazdirin
            System.out.println("Tablodaki satir sayisi" + demoqaPage.satirlarListesi.size()); //10

            //  7. Tablodaki sutun sayisini yazdirin
            System.out.println("Tablodaki sutun sayisi" + demoqaPage.headerList.size());

            //  8. Tablodaki 3.kolonu --sutunu yazdirin

            //burada wrap kullandik.
            demoqaPage.sutunYazdir(Integer.parseInt(ConfigReader.getProperty("demoqa_istenen_sutun_no")));

            //  9. Tabloda "First Name" i Kierra olan kisinin Salary'sini yazdirin



            //10. Page sayfasinda bir method olusturun, Test sayfasindan satir ve sutun sayisini girdigimde bana datayi yazdirsin

        }
    }


