package Utilities;

import _JDBC.Gun01.JDBCParent;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

//DataBaseden bilgi okuma. Excelden de okudugumuz bilgiyi yazdirdigimiz bir utility olusturmustuk.
public class DBUtility {
    public static Connection connection; // shift+F6 ile hepsini birden degistirir connection i
    public static Statement statement;

    public static List<List<String>> getDataList(String sql) {

        DBConnecionOpen();

        List<List<String>> dataList = new ArrayList<>();

        try {
            ResultSet rs = statement.executeQuery(sql);
            ResultSetMetaData rsmd = rs.getMetaData();

            while (rs.next()) {
                List<String> rowList = new ArrayList<>();
                for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                    rowList.add(rs.getString(i));
                }

                dataList.add(rowList);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        DBConnecionClose(); // sorguyu kapatip tabloyu gonderecek

        return dataList;
    }

    public static  void DBConnecionOpen() {

        String hostUrl = "jdbc:mysql://db-technostudy.ckr1jisflxpv.us-east-1.rds.amazonaws.com/sakila"; //java ve pomxml sagliyor
        String userName = "root";
        String password = "'\"-LhCB'.%k[4S]z"; // tek slash i biz koyduk

        try {
            connection = DriverManager.getConnection(hostUrl, userName, password); // java.sql den aldik fileinput gibi bulmazsa hata verck
            statement = connection.createStatement(); // statment ekran anlaminda
        } catch (Exception ex) {
            System.out.println("ex.Message= " + ex.getMessage());
        }
    }
    public static  void DBConnecionClose() {

        try {
            connection.close(); // bu baglantinin iki yerde de tanimlanmasi icin class icinde tanimlanmali method icinde degil
        } catch (Exception ex) {
            System.out.println("ex.getMessage() = " + ex.getMessage());
        }


    }
}