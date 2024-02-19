package _JDBC.Gun01;

import _JDBC.Gun01.JDBCParent;
import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

public class _02_Giris extends JDBCParent {

    @Test
    public void test1() throws SQLException {
        ResultSet sonuc= sorguEkrani.executeQuery("select * from customer");

        sonuc.next(); //satir verir

        System.out.println(sonuc.getString("first_name")); // sutun verir
//        System.out.println(sonuc.getString("last_name"));
//
//        sonuc.next(); // bir sonraki satiri verir
//
//        System.out.println(sonuc.getString("first_name"));
//        System.out.println(sonuc.getString("last_name"));





    }
}
