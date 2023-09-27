package ApachePOI;

import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *  Ekrandaki gibi bir Excel Çarpım tablosunu
 *  varolan boş bir excel dosyasına
 *  1 den 10 kadar çarpımlar için yapınız.
 *  (ipucu önce sadece 1 leri yapınız sonra
 *  diğerlerini)
 */

public class _07_Soru1Benimcozum {

    public static void main(String[] args) throws IOException {

        String path="src/test/java/ApachePOI/resource/WriteInTheExcelFile.xlsx";
        FileInputStream inputStream = new FileInputStream(path);
        Workbook workbook = WorkbookFactory.create(inputStream);
        Sheet sheet = workbook.getSheetAt(0);
        for (int i = 1; i <=10 ; i++) {
            for (int j = 0; j <=10 ; j++) {
                int sonSatirIndex= sheet.getPhysicalNumberOfRows();
                Row yeniSatir=sheet.createRow(sonSatirIndex);
                Cell yeniHucre = yeniSatir.createCell(0);
                Cell yeniHucre2 = yeniSatir.createCell(1);
                Cell yeniHucre3 = yeniSatir.createCell(2);
                Cell yeniHucre4 = yeniSatir.createCell(3);
                Cell yeniHucre5 = yeniSatir.createCell(4);
                Cell yeniHucre6 = yeniSatir.createCell(5);

                yeniHucre.setCellValue(i);
                yeniHucre2.setCellValue("x");
                yeniHucre3.setCellValue(j);
                yeniHucre4.setCellValue("=");
                yeniHucre5.setCellValue(i*j);
            }
        }
        inputStream.close();
        FileOutputStream outputStream = new FileOutputStream(path);
        workbook.write(outputStream);
        workbook.close();
        outputStream.close();
        System.out.println("Islem bitti");




    }
}
