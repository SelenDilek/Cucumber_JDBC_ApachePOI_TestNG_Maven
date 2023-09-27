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
public class _07_Soru {
    public static void main(String[] args) throws IOException {

        String path = "src/test/java/ApachePOI/resource/CarpimTablosu.xlsx";
        FileInputStream inputStream=new FileInputStream(path);
        Workbook workbook= WorkbookFactory.create(inputStream);
        Sheet sheet=workbook.getSheetAt(0);



        int yeniAcilacakSatirIndexi= 0; //sheet.getPhysicalNumberOfRows(); biz read yapiyoruz ilk basta yani bos sayfadaki tum rowlari aliyoruz
        //row lar yazilmamis oldugu icin ilk deger 0.

        for (int k = 1; k <= 10; k++) {

            for (int i = 1; i <= 10; i++) {

                // ++ her bır ıslemı yenı satıra yaz demek
                Row satir = sheet.createRow(yeniAcilacakSatirIndexi++);

                Cell hucre1 = satir.createCell(0); hucre1.setCellValue(k);
                Cell hucre2 = satir.createCell(1); hucre2.setCellValue("x");
                Cell hucre3 = satir.createCell(2); hucre3.setCellValue(i);
                Cell hucre4 = satir.createCell(3); hucre4.setCellValue("=");
                Cell hucre5 = satir.createCell(4); hucre5.setCellValue(k * i);
            }

            Row bosSatir = sheet.createRow(yeniAcilacakSatirIndexi++);
        }

        inputStream.close();

        //kaydet
        FileOutputStream outputStream=new FileOutputStream(path);
        workbook.write(outputStream);
        workbook.close();
        outputStream.close();

        System.out.println("işlem tamamlandı");
    }





}
