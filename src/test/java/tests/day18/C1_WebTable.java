package tests.day18;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.KoalaResortPage;
import utilities.Driver;

public class C1_WebTable {
    /*
    ● login() metodun oluşturun ve oturum açın.
    ● http://qa-environment.koalaresorthotels.com /admin/HotelRoomAdmin adresine gidin
                 ○ Username : manager
                 ○ Password : Manager1!
    ● table() metodu oluşturun
             ○ Tüm table body’sinin boyutunu(sutun sayisi) bulun. /tbody
             ○ Table’daki tum body’I ve başlıkları(headers) konsolda yazdırın.
    ● printRows() metodu oluşturun //tr
             ○ table body’sinde bulunan toplam satir(row) sayısını bulun.
             ○ Table body’sinde bulunan satirlari(rows) konsolda yazdırın.
             ○ 4.satirdaki(row) elementleri konsolda yazdırın.
     */

    @Test (groups = "mini_regression")
    public void table() {
        KoalaResortPage koalaResortPage = new KoalaResortPage();
        koalaResortPage.koalaResortLogin();
        //○ Tüm table body’sinin boyutunu(sutun sayisi) bulun. /tbody

        //--//tbody//tr[1]//td[9] bu body deki 1. satirdaki data() sayisini veriyor
        //bu locator ile 9 tane wEBELEMNT dondugu icin
        System.out.println("tablodaki sutun sayisi : " + koalaResortPage.birinciSatirDatalar.size());

        //○ Table’daki tum body’I ve başlıkları(headers) konsolda yazdırın.
        //Listemiz WebElementlerden olustugu icin direkt yazdiramayiz.
        System.out.println(koalaResortPage.sutunBasliklari);

        String basliklar;
        for (WebElement each : koalaResortPage.sutunBasliklari) {
            basliklar = each.getText();
            System.out.println(basliklar + ", ");
        }
        //○ Table’daki tum body’I konsolda yazdırın.
        System.out.println(koalaResortPage.tbodyWebElement.getText());

        //Eger tum body tek bir WebElemnt olarak locate eder ve yazdirirsak tum body gorulebilir
        //ancak bu anlamli degil ve cok kullnilmaz. Bu durumda satir, sutun ayrima sansimiz olmaz

        //Body nin icinde bulunan td sayisini bulmak icin //tbody//td locate kullanilir
        System.out.println("TABLO body sinde bulunan cell sayisi: " + koalaResortPage.bodydekiTumDataListesi.size());

        Driver.closeDriver();
    }

        @Test (groups = {"smoke"})
       public void getRows(){
            // ● printRows() metodu oluşturun //tr
            KoalaResortPage koalaResortPage = new KoalaResortPage();
            koalaResortPage.koalaResortLogin();

            // ○ table body’sinde bulunan toplam satir(row) sayısını bulun.
            // --//tboy//tr
            System.out.println("Tablodaki satirlar sayisi: " + koalaResortPage.satirlarListesi.size()); //Tablodaki satirlar sayisi: 10

            //○ Table body’sinde bulunan satirlari(rows) konsolda yazdırın.

            for (WebElement each: koalaResortPage.satirlarListesi) {
                System.out.println("Tum satirlar : " + each.getText());
            }

            System.out.println("======");
            //○ 4.satirdaki(row) elementleri konsolda yazdırın.

            System.out.println("4. satir elemanlari : " + koalaResortPage.satirlarListesi.get(3).getText());
            System.out.println("======");
            //bir liste olusturmaddan, parametre olarak satir numarasi kabul edip
            // girilen numaradaki satiri yazdiran bir metod yaziniz
            //ornek 5. satir //tbody//tr[4]
            koalaResortPage.istenenSatiriYazdir(5);

            Driver.closeDriver();

        }

        //2. Baska bir Test metodu oluşturun: printDataTest();
        @Test
    public void  printDataTest(){
            KoalaResortPage koalaResortPage = new KoalaResortPage();
            koalaResortPage.koalaResortLogin();

//    1. Bir metod oluşturun : printData(int row, int column);
//        a. Satır(row) ve sütun(column) numarasını girdiğinizde, printData metodu bu   hücredeki(cell) veriyi yazdırmalıdır.

            koalaResortPage.istenenSatirveSutunYazdir(5, 1);

//        a. Ve bu metodu printData() methodunu cagirmak icin kullanin.
//        b. Örnek: printData (3,5); => 3. satır, 5. Sütundaki veriyi yazdırmalıdır
//        c. yazdirilan datanin olmasi gereken dataya esit oldugunu test edin

         koalaResortPage.istenenSatirveSutunYazdir(4,5); //3. satir 5.  sutunun degeri : 05.05.2000

            koalaResortPage.dataBul(4,5); //istediginiz data : 05.05.2000

        Assert.assertEquals(koalaResortPage.istenenSatirveSutunYazdir(4,5), "05.05.2000");

       // Assert.assertEquals(koalaResortPage.dataBul(4,5), "05.05.2000"); // bu hocanin cozumu

      //  Assert.assertEquals(koalaResortPage.dataBul(4,5), "05.05.2000");

            koalaResortPage.sutunYazdir(3); //manager@st.com

       // Driver.closeDriver();

        }
    }


