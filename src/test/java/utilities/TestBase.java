package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

//TestBase testBase = new TestBase(); abstract olunca object olusturamayagiz diger classlarda
public abstract class TestBase {
    //public : herkes degistirebilir
    //protected: ayni package yada child classlar
    //default ( bir sey yazmayinca da): package private deniliyor
    //private : bunu sadece class icinde kullaniyoruz

    protected WebDriver driver;

    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        //  driver.manage().timeouts().pageLoadTimeout(15,TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }
    @AfterMethod
    public void tearDown(){

        //driver.close();
    }
}
