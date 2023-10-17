package _JDBC.Gun01;

import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

public class _03_NextPrevAbsRel extends JDBCParent {

    @Test
    public void test1() throws SQLException {

        ResultSet rs = sorguEkrani.executeQuery("select*from language");

        rs.next(); // burasi satir demek

        //2 demek 1.satirin 2 sutunu demek
        System.out.println("1.satir " + rs.getString(2)); // 2. colomn u almis olduk index degildir index mantigi yok--ing

        rs.next();
        System.out.println("2.satir " + rs.getString(2)); // italyanca
        //System.out.println("2.satir" + rs.getString("name")); yukarisi ile ayni

        rs.previous(); // bir onceki satir
        System.out.println("2.satir " + rs.getString(2)); // ingilizce bu coloum



    }


    @Test
    public void test2() throws SQLException {

        ResultSet rs = sorguEkrani.executeQuery("select*from film");

        rs.absolute(10); // 10. satira  direkt git
        System.out.println("10.satir title = " + rs.getString("title")); //alaaddin


        rs.absolute(5); // 5. satira  direkt git
        System.out.println("10.satir title = " + rs.getString("title")); //african


        rs.relative(5); //en son neredeysem , ordan itibaren 5 e git
        System.out.println("10.satira title = " + rs.getString("title")); //alaaddin

        rs.next() ; // 11. satira gider


        // rs.next() : sonraki satır
        // rs.previous : önceki satır
        // rs.absolute(10) : baştan itibaren 10.satıra gider.
        // rs.relative(10) : bulunduğu yerden 10.satıra gider.
        // rs.absolute(-10) : - (eksi) sondan demektir, sondan 10.satır
        // rs.relative(-5) :  - (eksi) bulundu yerden 5 satır geri




    }


}
