package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.util.concurrent.TimeUnit;

//bu bir depo class. Dger classlar bu classi kullanson diye yaptik
public class Driver {


   private Driver(){
       //Default contructor i burada parametresiz olarak gorunur hale getirip yazdik
       //private yaptik boylece bu class disindan bu constructgora ulasilamz ve
       // ve dolayisiyla bu classtan obje uretilemz. Bun obje urettilmesine izin verilmyen
       // class SINGLETON class denir.
   }




    //private => baska classlardan korumak icin
    //static => class ismiyle ulasabilmek icin
    static private WebDriver driver;

   //WebDriver donmeli
   public static WebDriver getDriver(){
       //eger driver varsa yeniden olusturma yoksa olustur.
       //Bunu ayni sayfada  acilmaya devam etsin, tekrar tekrar yeni sekme acmasin diye
       if(driver==null){

           switch (ConfigReader.getProperty("browser")){

               case "chrome":
                   //Ayarlari yaptik
                   WebDriverManager.chromedriver().setup();
                   //Drivera deger atiyoruz
                   driver =new ChromeDriver();
                   break;
               case "firefox":
                   WebDriverManager.firefoxdriver().setup();
                   driver =new FirefoxDriver();
                   break;
               case "opera":
                   WebDriverManager.operadriver().setup();
                   driver=new OperaDriver();
                   break;
               case "safari":
                    WebDriverManager.getInstance(SafariDriver.class).setup();
                    driver=new SafariDriver();
                    break;
               case "edge":
                   WebDriverManager.edgedriver().setup();
                   driver= new EdgeDriver();
                   break;
           }
       }
       driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
       driver.manage().window().maximize();

       return driver;
   }

   public static void closeDriver(){

       //Eger sayfa aciksa yani null degilse kapatmak icin if kullandik
       if(driver != null) {
           driver.close();
           //BROWSERIN AKLINDA SON SAYFA KALMASIN DIYE driver son degerini NULL yaptik
           driver=null;
       }

   }

}
