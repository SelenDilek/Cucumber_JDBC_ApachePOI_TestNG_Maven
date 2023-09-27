package ApachePOI;

import io.cucumber.java.sl.In;
import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Kullanıcı aşağıdaki excelde, 1.sutundaki bilgilerden istediğini girecek
 * karşılığında bu bilginin satırındaki karşılık gelen bilgilerin tamamı yazdırılacak.
 * yani metoda "Password" kelimesi gönderilecek, dönen değer Password un değeri olacak.
 * bulup ve sonucun döndürülmesi için metod kullanınız.
 * src/test/java/ApachePsOI/resources/LoginData.xlsx
 */


public class _05_GetASpecificData {
    public static void main(String[] args) throws IOException {

        String donenSonuc = exceldenGetir("Address");
        System.out.println(donenSonuc);
    }

    public static String exceldenGetir(String aranacakKelime) throws IOException {
        String donecek = "";

        String path = "src/test/java/ApachePOI/resource/LoginData.xlsx";
        FileInputStream inputStream = new FileInputStream(path);
        Workbook workbook = WorkbookFactory.create(inputStream);
        Sheet sheet = workbook.getSheetAt(0);

        for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {

            //aradığım satırı buldum :  i.satır
            if (sheet.getRow(i).getCell(0).toString().toLowerCase().contains(aranacakKelime.toLowerCase())) {

                for (int j = 1; j < sheet.getRow(i).getPhysicalNumberOfCells(); j++) {
                    donecek = donecek + sheet.getRow(i).getCell(j);
                    //donecek += sheet.getRow(i).getCell(j);
                }
            }
        }

        return donecek;
    }

}