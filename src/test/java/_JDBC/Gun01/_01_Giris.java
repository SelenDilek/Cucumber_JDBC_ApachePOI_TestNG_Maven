package _JDBC.Gun01;

import org.testng.annotations.Test;

import java.sql.*;

public class _01_Giris {

    // not : ilk 3 satir tum methodlarda ayni olacak
   @Test
    public void test1() throws SQLException {

//  bir sorgunun calismasi icin yapilanlar. (nokta atisi baglanti yapiliyor direkt olarak db in kendisine baglaniyoruz)
       //jdbc:mysql: i biz ekledik sonuna da /sakila yani calisacagimiz tabloyu ekledik
       String hostUrl="jdbc:mysql://db-technostudy.ckr1jisflxpv.us-east-1.rds.amazonaws.com/sakila"; //java ve pomxml sagliyor
       String userName="root";
       String password="'\"-LhCB'.%k[4S]z"; // tek slash i biz koyduk

//  1- baglanti bilgilerini girdik once connection bilgileri set edildi, ayarlandi(excelde file baglantiyi sagliyordu)

       Connection baglanti = DriverManager.getConnection(hostUrl,userName,password); // java.sql den aldik fileinput gibi bulmazsa hata verck

//  2. db sectik sakila mesela (set as default shema) (ekstra bir islem yapmiyoruz) hostUrlye bu bilgi eklendi db e baglandik
// hostUrl'nin sonuna /sakila bunu ekledik db adi

//  3. sorgu ekrani acildi

       Statement sorguEkrani= baglanti.createStatement(); // statment ekran anlaminda

//  4- sorguyu yazdim ve calistirdim ve sonuclari aldim.(java.sql.ResultSet)

      ResultSet sonucTablosu = sorguEkrani.executeQuery("select * from customer"); // sorgu ekraninda sorguyu calistirdim sorguyu calistir sonuclar sorgu
       //sorgu ekraninda kaliyor sonuclar sorgu ekraninin bir parcasi

//  5- altta sonuclar gozuktu (ayni anda tek bir satir okutur bir kac tane birden goremiyorum) biz next next diyince siradakini verir
       // javanin icinde ise sonuclari satir satir okutuyoeuz

       sonucTablosu.next(); // suanda ilk satira geldim. kursor ilk satira geldi

       String ad = sonucTablosu.getNString("first_name");
       String soyad = sonucTablosu.getNString("last_name");
       System.out.println("ad = " + ad);
       System.out.println("soyad = " + soyad);


       sonucTablosu.next(); // suanda ikinci satira geldim. kursor ikinci satira geldi

       String ad2 = sonucTablosu.getNString("first_name");
       String soyad2 = sonucTablosu.getNString("last_name");
       System.out.println("ad = " + ad2);
       System.out.println("soyad = " + soyad2);

       baglanti.close(); // fileinputstreami kapatma gibi dusun


       //2.yol

//       int i =1;
//       while (sonucTablosu.next()){
//
//           System.out.println(sonucTablosu.getNString(2));
//           i++;
//       }


    }
}
