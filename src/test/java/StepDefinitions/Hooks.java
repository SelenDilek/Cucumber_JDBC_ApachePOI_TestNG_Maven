package StepDefinitions;

import Utilities.ExcelUtility;
import Utilities.GWD;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {
//Ben testNG değilim onun kadar Annotation yok
//çünkü ihtiyacım yok, ihtiyaç kısmını testNG den
//kullanırım. sadece bana lazım olan kısım
//Senaryo bitti veya başladı Annotation ı.
//
//2 tane Annotation
//After
//Before
    @Before
    public void before(){

        System.out.println("Senorya basladi : ?");

    }

    @After
    public void after(Scenario scenario){

       // ExcelUtility.writeToExcel("src/test/java/ApachePOI/resource/SenaryoSonuclari3.xlsx",scenario); //excele sonucu yazdiracaz.

//        //scenario sonucu burda.
//        if(scenario.isFailed()){
//            //bytes baska bir doysyaya veya database e eklemek istersem sececegim kisim.
//            TakesScreenshot ts = ((TakesScreenshot) GWD.getDriver());
//            byte[]  hafizadakiHali = ts.getScreenshotAs(OutputType.BYTES);
//            //onceden dosyaya yaziyorduk simdi baska file e dosyaya ekleyecez. O yuzden Outputype byte yaptik.(byte olunca kendi icine gomebiliyor
//            // dosyanin icine istedigimiz)
//            scenario.attach(hafizadakiHali,"image/png","screenshot name");
     //   System.out.println("Senorya bitti : ?");
        //dogru calisirsa burada quiti cagiracam.

        GWD.quitDriver();
        }



    }


