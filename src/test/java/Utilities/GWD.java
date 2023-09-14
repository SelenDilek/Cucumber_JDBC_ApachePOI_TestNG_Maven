package Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class GWD { //cucumberda fonksiyonlar her yerde oldugu icin getdriver ile kullanilir. extends de yapabiliriz
    //ama isimizi zorlastirir. mantiksal olarak en uygun bu. burda class class gitmiyor da direkt kullanarak gidiyoruz.(step def icin)
    //her tarafta inheritance yapmaya gerek kalmayacak direkt fonk. icinde cagirip kullanacaz.
    private static WebDriver driver; //static private yazdik ki herkes burdan ayni seyi kullansin ve getile erisebilsin degismesin



    public static WebDriver getDriver() { //setter a gerek yok her yerden bunu cagirabilecem cunku her yerde fonksiyon var
        //inheritance yapmaya gerek kalmayacak
        if(driver==null) { //ilk kez 1 defa calissin eger calisiyorsa aynisi calissin.
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        }
        return driver;
    }

    //driver kapat
    public static void quitDriver(){
//test sonucu ekranda bi sure beklesin diye.
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        if(driver != null){ //driver var ise

            driver.quit();
            driver=null;

        }
    }

}
