package ApachePOI;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *  Ekrandaki gibi bir Excel Çarpım tablosunu
 *  YENİ bir excel dosyasına
 *  1 den 10 kadar çarpımlar için yapınız.
 *  (ipucu önce sadece 1 leri yapınız sonra
 *  diğerlerini)
 */

public class _09_Soru2 {
    public static void main(String[] args) throws IOException {

        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Sayfa1");


        int indexRow=0;

        for (int i = 0; i <=10 ; i++) {
            for (int j = 0; j <=10 ; j++) {
                Row row = sheet.createRow(indexRow++); //satir olusturma
                Cell cell1 = row.createCell(0);
                cell1.setCellValue(i);

                Cell cell2 = row.createCell(1);
                cell2.setCellValue("x");

                Cell cell3 = row.createCell(2);
                cell3.setCellValue(j);

                Cell cell4 = row.createCell(3);
                cell4.setCellValue("=");
                Cell cell5 = row.createCell(4);
                cell5.setCellValue(i*j);
            }
            Row row = sheet.createRow(indexRow++); //bos bir satir olusturdum.
        }


        String path = "src/test/java/ApachePOI/resource/NewExcelFile.xlsx";
        FileOutputStream outputStream = new FileOutputStream(path);
        workbook.write(outputStream);
        workbook.close();
        outputStream.close();
        System.out.println("Islem basarili");

    }
}
