package ApachePOI;

import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


public class _04_ApachePOIGetAllData {

    public static void main(String[] args) throws IOException {


        String path="src/test/java/ApachePOI/resource/ApacheExcel2.xlsx";
        FileInputStream inputStream = new FileInputStream(path); //her syafada farkli bir object adi vermemiz lazim

        Workbook workbook = WorkbookFactory.create(inputStream);
        Sheet sheet = workbook.getSheetAt(0); //ismi veya indexi ile alinabilir

        int rowCount = sheet.getPhysicalNumberOfRows(); // kac tane satir oldugunu verir.

        for (int i = 0; i <rowCount ; i++) { //satir sayisi zoo.lenght gibi
            //simdi buraya her bir satirin kac hucresi var onu bulup ona kadar hucreleri alacagim
            Row row = sheet.getRow(i);
            int cellCount=row.getPhysicalNumberOfCells();

            for (int j = 0; j <cellCount ; j++) { //zoo[i].lenght

                Cell cell = row.getCell(j); //j sutun
                System.out.println(cell + "\t");


            }
            System.out.println();

            System.out.println("--------------------------------------------------");
            //2.yol

            for (int k = 0; k <sheet.getPhysicalNumberOfRows() ; k++) { //sheetdeki tum rowlari al
                for (int j = 0; j <sheet.getRow(k).getPhysicalNumberOfCells() ; j++) { //sheetdeki her bir rowdaki cell i al.

                    System.out.println(sheet.getRow(k).getCell(j)+"\t");
                    System.out.println();
                }

            }
        }







    }
}
