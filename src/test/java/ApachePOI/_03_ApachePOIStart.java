package ApachePOI;

import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class _03_ApachePOIStart {
    public static void main(String[] args) throws IOException {
        //dosyanin oldugu yerle programim arasinda bir dosya yolu baglantisi olusturmaliyim

        String path="src/test/java/ApachePOI/resource/ApacheExcel2.xlsx";

        //Java dosya okuma nesnesine bu yolu vererek baglanti kuruyorum. Bir dosyada ayni anda hem okuma hem yazma yapilmaz.
        //Ayri ayri calisir. Ayni anda tek yon yapilmiyor. Ayni anda calismaz kapama ve acma.

        FileInputStream dosyaOkumaBaglantisi = new FileInputStream(path); //dosya ile baglanti kurulunca kopyasini ram e atiyor

        //hepsi apachePOI den aliniyor
        Workbook calismaKitabi = WorkbookFactory.create(dosyaOkumaBaglantisi);

        //istedigim isimdeki calisma sayfasini aliyorum
        Sheet calismaSayfasi = calismaKitabi.getSheet("Sheet1");

        //istenen satiri aliyorum
        Row satir = calismaSayfasi.getRow(0); //0. satiri aldim

        Cell hucre = satir.getCell(0); //satirin 0.hucresini aldim

        System.out.println(hucre); //hucre= Lion

        //NOT: Javada txt dosyasi da okutabiliriz.





    }
}
