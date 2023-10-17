package _JDBC.Gun01;

import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

// TODO : city tablosundaki tüm satırlardaki şehir isimlerini absolute ile yazdırınız
// TODO : city tablosundaki tüm satırlardaki şehir isimlerini relative ile yazdırınız
public class _06_ToDo extends JDBCParent{

    @Test
    public void test1() throws SQLException {

        ResultSet rs = sorguEkrani.executeQuery("select * from city");
        rs.last();
        int rows = rs.getRow();
        System.out.println(rows);

        for (int i = 1; i < rows; i++) {

            rs.absolute(i); //satirdayim
            System.out.println(i + ".city = " + rs.getString("city"));

        }


    }



    @Test
    public  void test2() throws SQLException {

        ResultSet rs = sorguEkrani.executeQuery("select * from city");

        rs.last(); // son satira gittim
        int rows = rs.getRow(); // bulundugum satirin row no aldim
        System.out.println("rows = " + rows);

        for (int i = 0; i <rows ; i++) {

            rs.first();
            rs.relative(i);

            System.out.println((i+1) + ".city= " + rs.getString("city"));


        }




    }

}
