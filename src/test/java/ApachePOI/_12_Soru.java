package ApachePOI;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;

public class _12_Soru {
    //ekleme yapacak. dosya yok ve icine yazi yazdiracaz en son satira(dosya varsa veya yoksa durumu var.)
    public static void main(String[] args) {

        String path = "src/test/java/ApachePOI/resource/SenaryoSonuclari2.xlsx";
        String bilgi = "test passed";

        writeToExcel(path, bilgi); // excel create
        writeToExcel(path, bilgi); // dosya artık var alt taraf çalışacak
        writeToExcel(path, bilgi);
        writeToExcel(path, bilgi);
    }

    public static void writeToExcel(String path, String bilgi) {

        File file = new File(path);

        if (!file.exists()) // dosya yok ise(ilk kez ve bi kez calisiyor)
        {
            //hafzada worbook oluştur, içinde hafızada sheet oluştur
            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet sheet = workbook.createSheet("Sayfa1");

            //hafızada işlemlerini yap
            Row yeniSatir = sheet.createRow(0);
            Cell hucre = yeniSatir.createCell(0);
            hucre.setCellValue(bilgi+" create oldu");

            //kaydet
            try {
                FileOutputStream outputStream = new FileOutputStream(path);
                workbook.write(outputStream);
                workbook.close();
                outputStream.close();
            } catch (Exception ex) {
                System.out.println("ex.getMessage() = " + ex.getMessage());
            }
        } else {

            FileInputStream inputStream=null;
            Workbook workbook=null;
            Sheet sheet=null;

            try {
                inputStream = new FileInputStream(path);
                workbook = WorkbookFactory.create(inputStream); //hafizaya create et
                sheet = workbook.getSheetAt(0);
            } catch (Exception ex) {
                System.out.println("ex.getMessage() = " + ex.getMessage());
            }

            int sonSatirIndex = sheet.getPhysicalNumberOfRows(); //son bos satirinn indexi
            Row yeniSatir = sheet.createRow(sonSatirIndex);
            Cell yeniHucre = yeniSatir.createCell(0);
            yeniHucre.setCellValue(bilgi);

            try {
                inputStream.close(); //input Streami kapatip outputstream yazariz. Cunku acma ve kapatma cift yonlu calismaz(two way road)
                FileOutputStream outputStream = new FileOutputStream(path);
                workbook.write(outputStream);
                workbook.close();
                outputStream.close();
            } catch (Exception ex) {
                System.out.println("ex.getMessage() = " + ex.getMessage());
            }
        }

    }
}
