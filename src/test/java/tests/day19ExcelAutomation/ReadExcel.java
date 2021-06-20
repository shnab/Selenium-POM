package tests.day19ExcelAutomation;

import org.apache.poi.ss.usermodel.*;
import org.testng.annotations.Test;
import utilities.ConfigReader;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.Map;

public class ReadExcel {

    @Test
    public void readExcel() throws IOException {

        String excelPath="src/test/Resources/ulkeler.xlsx";


        //throws IOException yapmanin dezavantaji kodu durdurur handel edemeyiz
        //dosya okuma
        FileInputStream fileInputStream=new FileInputStream(excelPath);

        // excel oldugu icin workBook-dosya olusturmamiz gerekiyor
        //Workbook objesi olusturuyoruz. MAVEN DEPENDENCY yapiyoruz.
        //apache poi bir API dir //dependency yukledik
        Workbook workBook = WorkbookFactory.create(fileInputStream);

        // excel'in yapisi geregi workbook icinde sheet secmeliyiz
        //sayfaya ulastik
        Sheet sheet=workBook.getSheet("Sayfa1");

        // sayfadan sonra satira ulasmaliyiz
        // satir icin index girmeliyiz, index 0'dan baslar
        // ornegin 5.satira gitmek istiyorsak index: 4 olur

        Row row = sheet.getRow(4);

        // satirdan sonra cell secmemiz lazim
        // cell icin index girmeliyiz, index 0'dan baslar
        // ornegin 4. cell'e gitmek istiyorsak index: 3 olur

        Cell cell=row.getCell(2);

        // suanda cell variable'inin icinde workbook/ Sayfa1 / 5.satir / 4.cell bilgisi var

        System.out.println(cell); //Andorra


    }

    @Test
    public void readExcel2() throws IOException {

        // 1.method'da cell'e ulasmak icin fis(FileInputStream), workbook, sheet, row , cell olusturduk
        // ama cell'e ulasmak icin daha kisa bir yol olarak
        // fis ve workbook olusturduktan sonra
        // Cell cell= workbook.getsheet(sayfaAdi).getRow(Row index'i).getCell(Cell index'i)

        FileInputStream fileInputStream=new FileInputStream(ConfigReader.getProperty("excel_path"));
        Workbook workbook=WorkbookFactory.create(fileInputStream);
        Cell istenenHucre=workbook.
                getSheet(ConfigReader.getProperty("excel_sayfa_ismi")).
                getRow(Integer.parseInt(ConfigReader.getProperty("excel_satir_index"))).
                getCell(Integer.parseInt(ConfigReader.getProperty("excell_cell_index")));//burada Integer.parseInt() ile int cevirdik

        System.out.println(istenenHucre);

        // hucredeki bilginin ilk harfini yazdirin
        // Eger cell'deki bilgiyi sadece yazdirmak istersek, sout(cell) yazabiliriz
        // Ama cell'deki bilgi uzerinde manipulation yapmak istersek
        // oncelikle toString() method'u ile Cell'i String'e dataCasting yapmaliyiz

        System.out.println(istenenHucre.toString().substring(0,1));

        // excel sayfa1'deki satir sayisini bulun

        //0 dan baslar. index
        System.out.println(workbook.getSheet(ConfigReader.getProperty("excel_sayfa_ismi")).getLastRowNum()); //190 =>sayfadaki son satir indeksini verir

        // 1 den baslar. dolu satirlarin sayisini verir(fiziki olarak kullanilan satir sayisini verir)
        System.out.println(workbook.getSheet(ConfigReader.getProperty("excel_sayfa_ismi")).getPhysicalNumberOfRows()); //191 => ici dolu olan row lar

        //eXCelin 2. sayfasinda bazi satirlari kullanip, bazilarini kullanmadik.

        //2. sayfa son satir/row indeksi
        System.out.println("2. sayfa son satir indeksi : " + workbook.getSheetAt(1).getLastRowNum());//23
        System.out.println("2. sayfa son satir indeksi : " + workbook.getSheet(ConfigReader.getProperty("excel_sayfa_ismi2")).getLastRowNum()); //23

        //kullanilan diolu satirlar.
        workbook.getSheetAt(1).getPhysicalNumberOfRows();
        System.out.println("2. sayfa dolu satir sayisi: " + workbook.getSheet(ConfigReader.getProperty("excel_sayfa_ismi2")).getPhysicalNumberOfRows());//7

        //Exceldeki tum datalari Classimiza nasil aliriz.
        //excelde bulunan tum ulkelrin Turkce isimlerini yazdiralaim
        //Yani her satirdaki 2. indeksteki bilgi isteniyor.

        int sonSatirIndeksi = workbook.getSheetAt(0).getLastRowNum();
        for(int index =1; index<=sonSatirIndeksi; index++){

            String turkceBaskentIsimleri =workbook.getSheetAt(0).getRow(index).getCell(3).toString();
            System.out.println( (index+1) + ". satirdaki baskent ismi : " + turkceBaskentIsimleri);
        }

        //exceldeki tum datayi Class imiza almak
        //Bunun icin tum datalari bir Java objesine (map) eklememiz gerekir

        //boyle bir bilgiyi depolayabilecgimiz Java objesi map olabilir
        //Map a depolamak icin sutunlardan birini key, digerlerini value olarak aliriz.

        Map<String, String> ulkelerMap = new HashMap<>();

        String key ="";
        String value="";
        for(int index =1; index<=sonSatirIndeksi; index++){
            key = workbook.getSheetAt(0).getRow(index).getCell(0).toString();
            value=workbook.getSheetAt(0).getRow(index).getCell(1).toString() + "," +
                    workbook.getSheetAt(0).getRow(index).getCell(2).toString() + ", "+
                    workbook.getSheetAt(0).getRow(index).getCell(3).toString();
        ulkelerMap.put(key, value);
        }

        System.out.println(ulkelerMap);

        fileInputStream.close();
        workbook.close();


    }


}