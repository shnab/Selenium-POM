package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ConfigReader;
import utilities.Driver;

import javax.sound.midi.Soundbank;
import java.sql.SQLOutput;
import java.util.List;
import java.util.Scanner;

public class KoalaResortPage {


    //constructor yaptik
    public KoalaResortPage(){
        //driver  Driver.getDriver() classindan aldik. O kadar
        //Driver artik Driver classindan alacagiz
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(linkText = "Log in")
    public WebElement ilkLoginLinki;

    @FindBy(id ="UserName")
    public WebElement username;

    @FindBy(id="Password")
    public WebElement password;

    @FindBy(id="btnSubmit")
    public WebElement loginButonu;


    @FindBy(xpath = "//*[text()='Try again please']")
    public WebElement girisYapilamadiElementi;

    @FindBy (xpath = "//*[text()='Hotel Management']")
    public WebElement hotelManagement;

    @FindBy (partialLinkText = "Hotel List")
    public WebElement hotelList;

    @FindBy (xpath = "//*[text()='Add Hotel ']")
    public WebElement addHotel;

    @FindBy(id = "Code")
    public WebElement codeTextBox;

    @FindBy(id = "IDGroup")
    public WebElement acilirMenu;

    @FindBy(id = "btnSubmit")
    public WebElement saveButonu;

    @FindBy(xpath = "//div[text()='Hotel was inserted successfully']")
    public WebElement sonucYazisiElementi;

    @FindBy(xpath = "//*[text()='OK']")
    public WebElement sonOKButonu;

    @FindBy(partialLinkText = "Hotel Rooms")
    public WebElement hotelRooms;

    @FindBy(xpath = "//*[text()='Add Hotelroom ']")
    public WebElement addHotelRoom;

    @FindBy(id = "IDHotel")
    public WebElement idHotelDropdown;

    @FindBy(xpath = "//textarea[@dir='ltr']")
    public WebElement roomTextBox;

    @FindBy(linkText = "500")
    public WebElement fiyatBesYuzButonu;

    @FindBy(id = "Price")
    public WebElement priceTextBox;

    @FindBy(id = "IDGroupRoomType")
    public WebElement roomTypeDropdown;

    @FindBy(id = "MaxAdultCount")
    public WebElement maxAdultCount;

    @FindBy(id = "MaxChildCount")
    public WebElement maxChildCount;

    @FindBy(xpath = "//*[text()='HotelRoom was inserted successfully']")
    public WebElement roomCreatedElementi;

    @FindBy(xpath = "//button[@class='btn btn-primary']")
    public WebElement roomCreateSonOK;

    @FindBy(partialLinkText = "Hotel Rooms")
    public WebElement hotelRoomsButonu;

    @FindBy(xpath = "(//*[text()='List Of Hotelrooms'])[2]")
    public WebElement hotelRoomListYaziElementi;


    @FindBy(xpath = "//tbody//tr[1]//td")
    public List<WebElement> birinciSatirDatalar;

    @FindBy(xpath = "//thead//tr[1]//th")
    public List<WebElement> sutunBasliklari;

    @FindBy(xpath = "//tbody")
    public WebElement tbodyWebElement;

    @FindBy(xpath = "//tbody//td")
    public List<WebElement> bodydekiTumDataListesi;

    @FindBy(xpath = "//tbody//tr")
    public List<WebElement> satirlarListesi;


    //her seferinde login ile ugrasmamak icin bu metodu yazdik
    public void koalaResortLogin(){
        Driver.getDriver().get(ConfigReader.getProperty("kr_url"));
        ilkLoginLinki.click();
        username.sendKeys(ConfigReader.getProperty("kr_valid_username"));
        password.sendKeys(ConfigReader.getProperty("kr_valid_password"));
        loginButonu.click();
    }

    // bir liste olusturmaddan, parametre olarak satir numarasi kabul edip
    //  girilen numaradaki satiri yazdiran bir metod yaziniz
    public void istenenSatiriYazdir(int satirNo){
        //====5. satir==> //tbody//tr[4]
       String satirXPath = "//tbody//tr[" + (satirNo-1) + "]";
        System.out.println("Istenen satir elemanlari: " + Driver.getDriver().findElement(By.xpath(satirXPath)).getText());
    }


    public void sutunYazdir(int sutunNo){
        // ornek : her hangi bir satirdaki 2.sutunu bulmak istersek //tbody//tr//td[2] yazabiliriz

//        String sutunPath= "//tbody//tr//td["+sutunNo+"]";
//        String sutunBasliklari= Driver.getDriver().findElement(By.xpath(sutunPath)).getText();
//        System.out.println(sutunBasliklari);

        //Burada sutunu yukaridan asagiya aliyoruz.
        //sutunBasligi header den geliyor.
        String sutunPath= "//tbody//tr//td["+sutunNo+"]";
        WebElement sutunBasligi=Driver.getDriver().findElement(By.xpath("//thead//th[" + sutunNo + "]"));
        System.out.println(sutunBasligi.getText()); //basligi aliyor.

        List<WebElement> istenenSutunListeOlarak=Driver.getDriver().findElements(By.xpath(sutunPath));

        for (WebElement each: istenenSutunListeOlarak
        ) {
            System.out.println(each.getText());
        }

    }

    //a. Satır(row) ve sütun(column) numarasını girdiğinizde, printData metodu bu hücredeki(cell) veriyi yazdırmalıdır.
    //benim cozum
    public String istenenSatirveSutunYazdir(int satirNo, int sutunNo){
        String satirSutunXPath = "//tbody//tr[" + (satirNo) + "]//td["+ sutunNo + "]";
        String getTextSatirSutun = Driver.getDriver().findElement(By.xpath(satirSutunXPath)).getText();
        System.out.println(satirNo + ". satir " +  sutunNo +".  sutunun degeri : " + getTextSatirSutun );
        return getTextSatirSutun;
    }

    //mehmet hocanin cozumu
    public WebElement dataBul(int satirNo, int sutunNo){
        // ornek : her 3. satirdaki 2.sutunu bulmak istersek //tbody//tr[3]//td[2] yazabiliriz
        String dataPath="//tbody//tr["+ satirNo +"]//td["+sutunNo+"]";
        System.out.println(dataPath);

        System.out.println("istediginiz data : " + Driver.getDriver().findElement(By.xpath(dataPath)).getText());
        return Driver.getDriver().findElement(By.xpath(dataPath));
    }

    public void istenenHucreyiYazdir(int satir, int sutun){
        //3. satir ve 5. sutunu yazdir
      //  String hucreXpath = "//tbody//tr[4]//td[5]";
          String hucreXpath = "//tbody//tr["+satir+"]//td["+sutun+"]";
          WebElement istenenWebElement= Driver.getDriver().findElement(By.xpath(hucreXpath));
        System.out.println(istenenWebElement.getText());
    }

    public String dataStringBul(int satirNo, int sutunNo){
        // ornek : her 3. satirdaki 2.sutunu bulmak istersek //tbody//tr[3]//td[2] yazabiliriz
        String dataPath="//tbody//tr["+ satirNo +"]//td["+sutunNo+"]";

        return Driver.getDriver().findElement(By.xpath(dataPath)).getText();
    }

    public WebElement dataWebelementiBul(int satirNo, int sutunNo){
        // ornek : her 3. satirdaki 2.sutunu bulmak istersek //tbody//tr[3]//td[2] yazabiliriz
        String dataPath="//tbody//tr["+ satirNo +"]//td["+sutunNo+"]";

        return Driver.getDriver().findElement(By.xpath(dataPath));
    }

}
