package tests.day21;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import utilities.ConfigReader;

public class Deneme {
//    protected static ExtentReports extentReports; //extent report'a ilk atamayi yapar.HTML icini duzenliyor
//    protected static ExtentTest extentTest; // test pass veya failed gibi bilgileri kaydeder. Ayrica ekran resmi icin de kullaniriz
//    protected static ExtentHtmlReporter extentHtmlReporter; // Html raporu duzenler

    public static void main(String[] args) {

//        setUpTest();
//    }
//
//    public static void setUpTest() {
      //  extentReports = new ExtentReports();
        //rapor oluştuktan sonra raporunuz nereye eklensin istiyorsanız buraya yazıyorsunuz.
        //user.dir ==> icinde bulundugumuz dosyayi verir
        // icinde bulundugumuz dosyanin altina bu dosyayi olusturacak => "/test-output/Rapor.html";
        int numara= 1;

       // String filePath = System.getProperty("user.dir") + "/test-output/"+numara+".Rapor.html";
        String path="C:/Users/gebruiker/com.Batch13POM/test-output/"+numara+".Rapor.html";

        for(int i=0; i<20; i++){
            if(path.indexOf(45,46)==numara){
                System.out.println(path);

                //                System.out.println(numara);
//                System.out.println(path);
            }
           numara++;
            path = path.replace(path.charAt(46), (char) numara);
        }
        System.out.println(path);


//        //oluşturmak istediğimiz raporu (html formatında) başlatıyoruz, filePath ile dosya yolunu belirliyoruz.
//        extentHtmlReporter = new ExtentHtmlReporter(filePath);
//        extentReports.attachReporter(extentHtmlReporter);
//
//        // İstediğiniz bilgileri buraya ekeyebiliyorsunuz.
//        extentReports.setSystemInfo("Enviroment","QA"); //QA, DEV, Prod environment
//        extentReports.setSystemInfo("Browser", ConfigReader.getProperty("browser")); // chrome, firefox
//        extentReports.setSystemInfo("Automation Engineer", "Abbas12");
//        //raporun basligi ne olsun istiyorsak buraya yazacagiz.
//        extentHtmlReporter.config().setDocumentTitle("Arama Testi");
//        ////raporun adi ne olsun istiyorsak buraya yazacagiz
//        extentHtmlReporter.config().setReportName("smoke test ==Arama Automation Reports");
    }
}
