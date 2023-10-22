package _JDBC.Gun02;

import _JDBC.Gun01.JDBCParent;
import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class _01_GetAllRowColumn extends JDBCParent {
    //DB de index yok 1 den baslar.
    @Test
    public void test1() throws SQLException {
        ResultSet rs = sorguEkrani.executeQuery("select city_id,city,country_id from city");
        rs.last(); // son satira gittim
        
        String id = rs.getString(1); // 1. kolon city_id
        System.out.println("id = " + id);

        // eger field in tipi uyuyor ise ilgili donusum ile alinabilir

        int intId = rs.getInt(1); // eger ki int turunde ise colomn alabiliriz yoksa hata verir.
        System.out.println("intId = " + intId);

    }


    @Test
    public void test2() throws SQLException {

        ResultSet rs = sorguEkrani.executeQuery("select * from city"); // yildiz aldim kac tane geldigini bilmeyeyim
       //rs.getString(1); // bu bana verileri veriyor baslik bilgileri ve miktarlari icin icin :

        //veri harici diger bilgiler (hepsiburada->insprect->meta yaz orda da var )
        ResultSetMetaData rsmd = rs.getMetaData(); // bilginin haricinde tablonun icinde yer alan diger bilgiler gelir donus tipi ise
        int columnCount=rsmd.getColumnCount();

        rs.next(); // ilk satira gittim
        for (int i = 1; i < columnCount ; i++) {

            System.out.print(rs.getString(i)+" "); // bulundugum satirin tum bilgileri
            //kac tane baslik varsa hepsini yazdirabilirim
        }

        System.out.println();

        for (int i = 1; i <columnCount ; i++) { //column larin isimlerini ve tiplerini aldim

            System.out.print(rsmd.getColumnName(i) + "\t" + rsmd.getColumnTypeName(i) +" ");
        }


    }

    @Test
        public void test3() throws SQLException {
// language tablosundaki tüm satırları ve tüm sütunları yazdırınız,
            // aynı mysql sonuç ekranında olduğu gibi

            ResultSet rs = sorguEkrani.executeQuery("select * from language");
            ResultSetMetaData rsmd = rs.getMetaData();

            for (int i = 1; i <=rsmd.getColumnCount() ; i++) {
                System.out.print(rsmd.getColumnName(i)+ "\t");

            }
            System.out.println();

            while (rs.next()) { //her bir sonrakine gidebiliyorsan satir var demektir satir oldugu surece
                for (int i = 1; i <= rsmd.getColumnCount(); i++) { //kac tane varsa o kadar yaz her bir satirda kac colomn varsa o kadar yazacak
                    System.out.print(rs.getString(i) + "\t");
                }

                System.out.println();
            }
    }
    @Test
    public void test3_3Cozumu() throws SQLException {
// language tablosundaki tüm satırları ve tüm sütunları yazdırınız,
        // aynı mysql sonuç ekranında olduğu gibi

        ResultSet rs = sorguEkrani.executeQuery("select * from language");
        ResultSetMetaData rsmd = rs.getMetaData();

        for (int i = 1; i <= rsmd.getColumnCount(); i++) {
            System.out.printf("%-20s" ,rsmd.getColumnName(i));

        }
        System.out.println();

        while (rs.next()) { //her bir sonrakine gidebiliyorsan satir var demektir satir oldugu surece
            for (int i = 1; i <= rsmd.getColumnCount(); i++) { //kac tane varsa o kadar yaz her bir satirda kac colomn varsa o kadar yazacak
                System.out.printf("%-20s" ,rs.getString(i)); //ilk yazdir sonra 20 birim bosluk birak
            }

            System.out.println();


        }

        // % : değişkenin değerini işaret eder
        // - : sola dayalı yazdırır, default sağa dayalı
        // 20: kaç hane kullanılacak herzaman onun bilgisi
        // s : string değerler içis , sayısal değerler için d kullanılır
        // "%5.2f" : sayı için 5 hane kullan, ondalıklı kısım için 2 hane
    }


    // bir metoda sorguyu("select * from language") gönderiniz,
    // metod size sorgunun datasını bir ArrayList olarak döndürsün

    @Test
    public void test4(){
        // bir metoda sorguyu("select * from language") gönderiniz,
        // metod size sorgunun datasını bir ArrayList olarak döndürsün

        String sorgu="select * from language";
        List<List<String>>  donenList =getListData(sorgu);
        System.out.println("donenList = " + donenList);
    }

    public  List<List<String>> getListData(String sorgu){
        List<List<String>> tablo=new ArrayList<>();

        try {
            ResultSet rs = sorguEkrani.executeQuery(sorgu);
            ResultSetMetaData rsmd=rs.getMetaData();

            while (rs.next()) {
                List<String> satir=new ArrayList<>();
                for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                    satir.add(rs.getString(i));
                }

                tablo.add(satir);
            }
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }

        return tablo;
    }
// TODO : DB den Customer tablosunu okutarak yeni bir excel e yazdiriniz




}
