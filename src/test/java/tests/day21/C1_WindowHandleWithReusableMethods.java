package tests.day21;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.Set;

public class C1_WindowHandleWithReusableMethods {

    @Test
    public void test01() throws InterruptedException {
        // https://the-internet.herokuapp.com/iframe adresine gidin.
        // Elemental Selenium yazisina tiklayalim
        // acilan windows'da Sponsored by Sauce Labs yazisi locate edip yazdirin
        Driver.getDriver().get("https://the-internet.herokuapp.com/iframe");
        // ben click yapmadan var olan window'un handle'ni alsam
        String ilkSayfaHandleDegeri = Driver.getDriver().getWindowHandle();

      //  Thread.sleep(10000); Throws a gerek kalmadan bunun yerine waitfor methodu olusturduk kaullandik.
        ReusableMethods.waitFor(5);

        Driver.getDriver().findElement(By.linkText("Elemental Selenium")).click();

        //bundan sonraki kisim icin Reusable method kullandik
        ReusableMethods.switchToWindow("Elemental Selenium: Receive a Free, Weekly Tip on Using Selenium like a Pro");
        System.out.println(Driver.getDriver().getTitle());


       /*

       eskiden kullandigimiz method

             // click yaptiktan sonra tum handle degerlerini alsam
        Set<String> handleListesi = Driver.getDriver().getWindowHandles();
        // elimizde icinde 2 handle degeri bulunan bir set var
        // Bunlardan biri ilk sayfanin handle degeri
        // ikinci sayfanin handle degerini nasil bulabilirim
        String ikinciSayfaHandleDegeri="";
        for (String each: handleListesi
        ) {
            if (!each.equals(ilkSayfaHandleDegeri)){
                ikinciSayfaHandleDegeri=each;
            }
        }
        Driver.getDriver().switchTo().window(ikinciSayfaHandleDegeri);

        WebElement souceLabYazisiElementi=Driver.getDriver().findElement(By.xpath("//a[text()='Sauce Labs']"));
        System.out.println(souceLabYazisiElementi.getText());

        */
    }
}
