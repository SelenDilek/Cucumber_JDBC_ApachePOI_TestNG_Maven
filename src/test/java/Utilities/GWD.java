package Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Locale;

public class GWD {
    //paralel test icin her cagiran bundan bir tane alacak static i coklayacak.
    private static ThreadLocal<WebDriver> threadDriver= new ThreadLocal<>(); //static private yazdik ki herkes burdan ayni seyi kullansin ve getile erisebilsin degismesin
    // threadDriver.get() -> bulundugum thread deki driveri i al -> yoksa set edecez.
    // threadDriver.get() -> bulundugum thread deki driveri i set et
    public static ThreadLocal<String> threadBrowserName= new ThreadLocal<>(); //browser da her locale ozel(isim xml den gonderiliyor)
  //Runner in icine XML Runner i cagiracak


    public static WebDriver getDriver() {

        //rapor islemleri icin dil ingilizce olsun diye ekledik en son derste ekledik.
        Locale.setDefault(new Locale("EN"));
        System.setProperty("user.language", "EN");

        //inheritance yapmaya gerek kalmayacak
        //eger kullanilmayan driver varsa yenisini olustur.
        if(threadBrowserName.get()==null)
            threadBrowserName.set("chrome");
            //ilk kez 1 defa calissin eger calisiyorsa aynisi calissin.//o localdeki driveri ver
            //gelen browser ismine gore chrome,edge,firefox switch uretip set edecem. paralel test gercek sirkette yapilmaz
            //cunku ayni anda girilen veriler cakisabilir arka arkaya calistirrlar.

       //xml den calistirilmayan bolumler icin direkt olarak bunu set et cunku java switch icine
            //null gelince anlamiyor. paralel calismiyorsa da bu kisim kullanilacak. //driver var ise

        if(threadDriver.get() == null) { //driver var ise var olan hattaki driver i al.

            switch (threadBrowserName.get()) {

                case "firefox":
                    threadDriver.set(new FirefoxDriver()); // ilgili threade bir driver set ettim
                    break;

                case "safari":
                    threadDriver.set(new SafariDriver());
                    break;

                case "edge":
                    threadDriver.set(new EdgeDriver());
                    break;

                default:
                    threadDriver.set(new ChromeDriver());

                    //javanin bir eksikligi var:switch icine null geldigi zaman default e gonderemiyor napacagini bilmiyor null
                    //kontrolu konulur.en ustte if else ile :

            }
        }
            threadDriver.get().manage().window().maximize();
            threadDriver.get().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20)); // 20 sn mühlet: sayfayı yükleme mühlet
             //bulunduğum threade driver ver

            return threadDriver.get();
    }

    //driver kapat
    public static void quitDriver(){
//test sonucu ekranda bi sure beklesin diye.
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        //driver i kapat (swithch default deger null u algilamiyor o yuzden bu kismi paralel calismayacaklar icin yaptik)

            if (threadDriver.get()!=null) { //driver var ise
                threadDriver.get().quit();

                WebDriver driver = threadDriver.get(); // direk eşitleme yapamadığım için, içindekini al
                driver = null;  // null a eşitle

                threadDriver.set(driver);
                //yeni bir driver olustup icine null atilir cunku ayni driver i null atanmaz.
                //direkt esitlenmedigi icin icindekini al bosalt set et baska bir kullanima hazir hale getir.
                //her test çalışıp kpandığında paralel olarak çalışmak için driverı sıfırlıyor


        }
    }

}
