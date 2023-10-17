package _JDBC.Gun01;

import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

public class _04_Soru extends  JDBCParent{
// city tablosundaki tüm satırlardaki şehir isimlerini next ile yazdırınız

    @Test
    public void test1() throws SQLException {

        ResultSet rs = sorguEkrani.executeQuery("select * from city");


        while (rs.next()) // == true dememize gore yok kendisi zaten boolena donruyor.
            System.out.println(rs.getString("city")); //zaten varsa gidiyor olmadigi zaman birakiyor. boolean donruyor next olabiliyor musun al.



//        for (int i = 0; i <601 ; i++) {
//            rs.next();
//            System.out.println(rs.getString("city"));
//        }










    }





}
