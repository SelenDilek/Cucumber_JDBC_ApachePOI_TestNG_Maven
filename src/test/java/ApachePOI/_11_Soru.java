package ApachePOI;


import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
/*
   Main den bir metod çağırmak suretiyle, path i ve sheetName i verilen excelden
   istenilen sütun kadar veriyi okuyup bir List e atınız.
   Bu soruda kaynak Excel için : ApacheExcel2.xlsx  in 2.sheet ini kullanabilirsiniz.
 */
public class _11_Soru {
    public static void main(String[] args) throws IOException {

        String path = "src/test/java/ApachePOI/resource/ApacheExcel2.xlsx";
        String sheetName="testCitizen";
        int sutunSayisi=2;
       ArrayList<ArrayList<String>> data = getData(path,sheetName,sutunSayisi);

        System.out.println("datas = " + data);


    }

    public static  ArrayList<ArrayList<String>> getData(String path,String sheetName,int sutunSayisi) throws IOException {

        ArrayList<ArrayList<String>> tablo = new ArrayList<>(); //satirlarin listesi gerekiyor bana. her satir kendi icinde
        //bir list o yuzden listin listi oluyor

        Sheet sheet=null;



        try {
            FileInputStream inputStream = new FileInputStream(path);
            Workbook workbook = WorkbookFactory.create(inputStream);
            sheet = workbook.getSheet(sheetName);
        } catch (IOException e) {
            System.out.println("e= " + e.getMessage());
        }

        //bir rowdaki iki satiri oku

            for (int i = 0; i <sheet.getPhysicalNumberOfRows() ; i++) { //her bir satiri //buraya satir sayisi yazilir
                ArrayList<String> satir = new ArrayList<>();
                for (int j = 0; j <sutunSayisi ; j++) { //buraya sutun sayisi yazilir(zaten bize sutun sayisini vermis)
                    satir.add(sheet.getRow(i).getCell(j).toString());

                }

                tablo.add(satir);
            }

        return tablo;
    }
}
