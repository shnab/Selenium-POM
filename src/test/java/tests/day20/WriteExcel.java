package tests.day20;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class WriteExcel {

    @Test
    public void writeExcelTest() throws IOException {
       //1
        String path = "src/test/Resources/ulkeler.xlsx";
        //2
        FileInputStream fileInputStream = new FileInputStream(path);
        //3
        Workbook workbook= WorkbookFactory.create(fileInputStream);
        //4 => 4. indexe Nufus ekleyecegiz
        //burada kendi olusturdugumuz workbook a yazdirdik.
        workbook.getSheetAt(0).getRow(0).createCell(4).setCellValue("NUFUS");
        workbook.getSheetAt(0).getRow(4).createCell(4).setCellValue("10000");
        workbook.getSheetAt(0).getRow(5).createCell(4).setCellValue("1000");
        workbook.getSheetAt(0).getRow(6).createCell(4).setCellValue("2100");

        //Simdi workbooka gir excele bu degeri yazdir diyecegiz
        //bunun icin once FileOutputStream kullandik
        FileOutputStream fileOutputStream = new FileOutputStream(path);
        workbook.write(fileOutputStream);



    }
}
