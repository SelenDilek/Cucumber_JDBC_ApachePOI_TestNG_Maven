package ApachePOI;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * TODO:
 *  Ekrandaki gibi bir Excel Çarpım tablosunu
 *  YENİ bir excel dosyasına(var olmayan)
 *  1 den 10 kadar çarpımları YAN YANA yapınız.
 *  (ipucu önce sadece 1 leri yapınız sonra
 *  diğerlerini)
 */


public class _10_Soru3 {
    public static void main(String[] args) throws IOException {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Sayfa1");



        int rowsIndex = sheet.getPhysicalNumberOfRows();



        //yan yana yazdirmak icin rows sabit kalacak cell artacak bir bosluk ile
        //1.rowun 1.hucresi 1x1 2.hucresi bosluk 3.hucresi 2x1 4.hucresi bosluk 5.hucresi 3x1

        for (int i = 1; i <=10 ; i++) {

            for (int j = 1; j <=10 ; j++) {
                Row row = sheet.createRow(rowsIndex++);
                Cell cell1 = row.createCell(j);
                cell1.setCellValue(i);
                Cell cell2 = row.createCell((j+1));
                cell2.setCellValue("x");
                Cell cell3 = row.createCell((j+2));
                cell3.setCellValue(j);
                Cell cell4 =row.createCell((j+3));
                cell4.setCellValue("=");
                Cell cell5 = row.createCell((j+4));
                cell5.setCellValue(i*j);

            }
            Row bosSatir = sheet.createRow(rowsIndex++);

        }



        //excele yazdirmak icin
        String path = "src/test/java/ApachePOI/resource/ooo.xlsx";
        FileOutputStream outputStream = new FileOutputStream(path);
        workbook.write(outputStream);
        workbook.close();
        outputStream.close();

        System.out.println("Basari ile tamamlandi !!");



    }
}
