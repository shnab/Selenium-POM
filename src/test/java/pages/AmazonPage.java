package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;
import java.util.List;
public class AmazonPage {

    public AmazonPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//table[@class='navFooterMoreOnAmazon']") ////*[@id="navFooter"]/div[4]/table
    public WebElement table;

    @FindBy(xpath = "//tbody//tr")
    public List<WebElement> tableSatirSayilari;

    @FindBy(xpath = "//td[@tbody='navFooterDescSpacer']")
    public List<WebElement> doluSutunSayilari;

    @FindBy(xpath = "//tbody//tr[1]//td")
    public List<WebElement> tumDoluSutunSayilari;

    @FindBy(xpath = "//tbody//tr//td")
    public List<WebElement> amazonYazisiAra;

    @FindBy(xpath = "//tbody//tr[5]//td[3]")
    public WebElement homeService;

    @FindBy(xpath = "//tbody//tr//td")
    public List<WebElement> tableTamami;

    @FindBy(xpath = "//tbody//tr//td")
    public List<WebElement> tableTamamiString;

    public void getamazonPage(){
        Driver.getDriver().get(ConfigReader.getProperty("amazon_url"));
    }

    //➢ Amazon ana sayfasinda en altta bulunan Webtable'i inceleyebilmek icin AmazonPage
    //clasinda en altta gitme isini yapacak bir method olusturun
    public void altaGitTabloyuBul(){
        Actions actions=new Actions(Driver.getDriver());
        actions.moveToElement(table); //bu syfanin en altindaki table direkt gider.
    }

    public String satirSutundakiBilgiyiGetir(int satirNo, int sutunNo){
        //ornek 5. satir 4. sutunu yazdir //tbody//tr["+ 5+"]//td["+4+"]"
        String dataPath="//tbody//tr["+ satirNo +"]//td["+sutunNo+"]";
        return Driver.getDriver().findElement(By.xpath(dataPath)).getText();
    }

}
