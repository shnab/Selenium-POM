package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.IOException;

public abstract class TestBaseRapor {

    //3 tane obje olusturmamiz gerekiyor.
    protected static ExtentReports extentReports; //extent report'a ilk atamayi yapar.HTML icini duzenliyor
    protected static ExtentTest extentTest; // test pass veya failed gibi bilgileri kaydeder. Ayrica ekran resmi icin de kullaniriz
    protected static ExtentHtmlReporter extentHtmlReporter; // Html raporu duzenler

    // Test işlemine başlamadan hemen önce (test methodundan önce değil, tüm test işleminden önce)
    //Before test, class, package, method ne calisirsa calissin
    // ilk once BeforeTest calisacak
    @BeforeTest(alwaysRun = true) // alwaysRun : her zaman çalıştır.
    public void setUpTest() {
        extentReports = new ExtentReports();
        //rapor oluştuktan sonra raporunuz nereye eklensin istiyorsanız buraya yazıyorsunuz.
        //user.dir ==> icinde bulundugumuz dosyayi verir
        // icinde bulundugumuz dosyanin altina bu dosyayi olusturacak => "/test-output/Rapor.html";
        String rapor ="Rapor";

         String filePath = System.getProperty("user.dir") + "/test-output/" + rapor  + ".html";
        //oluşturmak istediğimiz raporu (html formatında) başlatıyoruz, filePath ile dosya yolunu belirliyoruz.
        extentHtmlReporter = new ExtentHtmlReporter(filePath);
        extentReports.attachReporter(extentHtmlReporter);

        // İstediğiniz bilgileri buraya ekeyebiliyorsunuz.
        extentReports.setSystemInfo("Enviroment","QA"); //QA, DEV, Prod environment
        extentReports.setSystemInfo("Browser", ConfigReader.getProperty("browser")); // chrome, firefox
        extentReports.setSystemInfo("Automation Engineer", "Abbas12");
        //raporun basligi ne olsun istiyorsak buraya yazacagiz.
        extentHtmlReporter.config().setDocumentTitle("Arama Testi");
        ////raporun adi ne olsun istiyorsak buraya yazacagiz
        extentHtmlReporter.config().setReportName("smoke test ==Arama Automation Reports");
    }


    // Her test methodundan sonra eğer testte hata varsa, ekran görüntüsü alıp rapora ekliyor
    @AfterMethod(alwaysRun = true)
    public void tearDownMethod(ITestResult result) throws IOException {

        if (result.getStatus() == ITestResult.FAILURE) { // eğer testin sonucu başarısızsa
            String screenshotLocation = ReusableMethods.getScreenshot(result.getName());
            extentTest.fail(result.getName());
            extentTest.addScreenCaptureFromPath(screenshotLocation);
            extentTest.fail(result.getThrowable());
        } else if (result.getStatus() == ITestResult.SKIP) { //skip olduysa diye kontrol ediyor.  eğer test çalıştırılmadan geçilmezse
            extentTest.skip("Test Case is skipped: " + result.getName()); // Ignore olanlar
        }
        Driver.closeDriver();
    }


    //hersey calisip bitecek, en son bu calisacak
    // Raporlandırmayı sonlandırmak icin
    @AfterTest(alwaysRun = true)
    public void tearDownTest() {
        extentReports.flush(); //burada sifonu cektik artik
    }
}

