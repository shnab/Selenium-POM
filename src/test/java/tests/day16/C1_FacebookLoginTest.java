package tests.day16;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.FacebookLoginPage;
import utilities.TestBase;

public class C1_FacebookLoginTest extends TestBase {

    //bu grupta eger smoke calisacaksa o zaman :
    //<exclude name="mini_regression" ve
    //include name="smoke" yaparsak, bunlar ayni grup icinde oldugu icin bu grup calismaz. bIRINI KAPATIP DIGERINI acamiyoruz.
    @Test (groups = {"mini_regression", "smoke"})
    public void gelenekselTest(){
        driver.get("https://www.facebook.com");
        driver.findElement(By.xpath("(//button[@type='submit'])[3]")).click();

        WebElement mailTextBox= driver.findElement(By.id("email"));
        mailTextBox.sendKeys("email@gmail.com");

        WebElement password = driver.findElement(By.id("pass"));
        password.sendKeys("12345");

        driver.findElement(By.xpath("//button[@name='login']")).click();
    }

    @Test (groups = "mini_regression")
    public void pageIleTest(){
        driver.get("https://www.facebook.com");
        driver.findElement(By.xpath("(//button[@type='submit'])[3]")).click();

        //Buraya neden driver yaziyoruz.
        FacebookLoginPage facebookLoginPage = new FacebookLoginPage(driver);

        facebookLoginPage.emailTextBox.sendKeys("email@gmail.com");
        facebookLoginPage.passwordTextBox.sendKeys("12345");
        facebookLoginPage.loginButon.click();
    }

}
