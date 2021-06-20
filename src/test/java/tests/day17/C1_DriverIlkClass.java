package tests.day17;

import org.testng.annotations.Test;
import utilities.Driver;

public class C1_DriverIlkClass {

    @Test
    public void test01(){
        //Driver class static oldugu icin direkt class ismiyle cagirdik
        //eskiden kullandigimiz driver yerine bundan sonra artik driver =>Driver.getDriver();olacak

        Driver.getDriver().get("https://youtube.com");

        Driver.getDriver().get("https://www.facebook.com");

        Driver.getDriver().get("https://amazon.com");

      Driver.closeDriver();

    //  Driver asdf = new Driver(); //default  constructor bu. ama bundan object



    }
}
