package ApachePOI;

import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class _06_WrittenInTheExcel {
    public static void main(String[] args) throws IOException {
      //bos excele ilk cellleri create edip okuttuk tanittik.

        String path="src/test/java/ApachePOI/resource/WriteInTheExcelFile.xlsx";
        FileInputStream inputStream = new FileInputStream(path); //okuma yonunde actim
        Workbook workbook = WorkbookFactory.create(inputStream); //suanda hafizada. Hafizaya kopyasi olusturuldu
        Sheet sheet = workbook.getSheetAt(0);

        //hafizada yazma islemine basliyorum. (satir ve sutunlari yok)

        //son satirin indexi alinip bos yere yeni satir aciyor
        int sonSatirIndex= sheet.getPhysicalNumberOfRows(); //bos excelde son satur 0 , ama birden cok icin her seferinde olusturacak

        Row yeniSatir=sheet.createRow(sonSatirIndex); //hucreler suanda yok ben olusturursam hucreler olusutur. Henuz hucrem yok.

        Cell yeniHucre = yeniSatir.createCell(0); //ben yazdigim zaman hucre ve satir olusur. //ilk hucre olusturuldu
        yeniHucre.setCellValue("Merhaba Dunya");

        //yazma isim bitti dosyayi kaydetmeye geciyorum okuma hattini kapatiyoruz.
        inputStream.close();

        //bunun icin dosyayi yazma yonunde ac

        FileOutputStream outputStream = new FileOutputStream(path); //kabal yazma yonune cevrildi
        workbook.write(outputStream);
        //hafizayi bosalt
        workbook.close(); //hafizada kalmasin diye kapatiyoruz hafizayi kapat excelde yok ama programmatik oldugu icin kapatiyor
        outputStream.close(); //yazma kanalini kapat

        System.out.println("Islem bitti");




//not : woorkbook un write output kabul ediyor sadece. biz hafizada create yapiyoruz dosyada degil.


    }
}
