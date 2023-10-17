package _JDBC.Gun01;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCParent { // boylece test yaparken inheritance yapacam
   public static Connection baglanti;
   public static Statement sorguEkrani;
    @BeforeClass
    public void DBConnecionOpen(){

        String hostUrl="jdbc:mysql://db-technostudy.ckr1jisflxpv.us-east-1.rds.amazonaws.com/sakila"; //java ve pomxml sagliyor
        String userName="root";
        String password="'\"-LhCB'.%k[4S]z"; // tek slash i biz koyduk

        try {
            baglanti = DriverManager.getConnection(hostUrl,userName,password); // java.sql den aldik fileinput gibi bulmazsa hata verck
            sorguEkrani= baglanti.createStatement(); // statment ekran anlaminda
        } catch (Exception ex) {
            System.out.println("ex.Message= " + ex.getMessage());
        }

    }

    @AfterClass
    public void DBConnecionClose(){

        try {
            baglanti.close(); // bu baglantinin iki yerde de tanimlanmasi icin class icinde tanimlanmali method icinde degil
        } catch (Exception ex) {
            System.out.println("ex.getMessage() = " + ex.getMessage());
        }

    }





}
