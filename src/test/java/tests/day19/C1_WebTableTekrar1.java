package tests.day19;

import org.testng.annotations.Test;
import pages.KoalaResortPage;
import utilities.Driver;

public class C1_WebTableTekrar1 {

    //1. Bir metod oluşturun : printData(int row, int column);
    //  a. Satır(row) ve sütun(column) numarasını girdiğinizde,
    //  printData metodu bu     hücredeki(cell) veriyi yazdırmalıdır.
    //2. Baska bir Test metodu oluşturun: printDataTest();
    //  a. Ve bu metodu printData() methodunu cagirmak icin kullanin.
    //  b. Örnek: printData (3,5); => 3. satır, 5. Sütundaki veriyi yazdırmalıdır
    //  c. yazdirilan datanin olmasi gereken dataya esit oldugunu test edin

    @Test
    public void test01(){
        KoalaResortPage koalaResortPage = new KoalaResortPage();
       koalaResortPage.koalaResortLogin();

        //istedigimiz satir ve sutunu yazdiralim
        koalaResortPage.istenenHucreyiYazdir(5,4);//Lucio McKenzie MD

        //5. satir 4. sutundaki bilginin Lucio McKenzie MD oldugunu dogrulayin
        //tbody//tr[5]//td[4]

        Driver.closeDriver();


    }

}
