package Runners;

import Utilities.GWD;
import com.aventstack.extentreports.service.ExtentService;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

@CucumberOptions(

        tags = "@Regression",
        features = {"src/test/java/FeatureFiles"},
        glue={"StepDefinitions"},
        plugin= {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}


)

public class _08_ParalelTest extends AbstractTestNGCucumberTests {
    //not:kim ne zaman hangi isletim sisteminde yapmis bu test calistiktan sonra bilgisini alacagimiz kisim oldugu icin
    //buraya ekledik.


    @BeforeClass
    @Parameters("browserTipi")
    public void  beforeClass(String browserName){
        //o localdeki browser name e verilecek

        GWD.threadBrowserName.set(browserName);

    }
    @AfterClass //testNg kullandik cucumber ile testNg beraber calisiyor.
    public static void writeExtendReport(){
        //birinci bolum acilama satiri ikinci bolum bilgisi. (ekstra bilgi ekleme bolumu)
                                                                        //bu kisim sistemden aliniyor.
        ExtentService.getInstance().setSystemInfo("Windows User Name",System.getProperty("user.name")); //usurname : Selen Dilek
        //sistemden kullanici adi alinabilir.
        ExtentService.getInstance().setSystemInfo("Time Zone", System.getProperty("user.timezone"));
        ExtentService.getInstance().setSystemInfo("User Name", "Selen Dilek");
        ExtentService.getInstance().setSystemInfo("Application Name", "Campus");
        ExtentService.getInstance().setSystemInfo("Operating System Info", System.getProperty("os.name"));
        ExtentService.getInstance().setSystemInfo("Department", "QA");
        ExtentService.getInstance().setSystemInfo("Ek Satır", "Açıklama");
        ExtentService.getInstance().setSystemInfo("Ek Satır", "Açıklama");
        ExtentService.getInstance().setSystemInfo("Ek Satır", "Açıklama");
        ExtentService.getInstance().setSystemInfo("Ek Satır", "Açıklama");

//spark in icinde aciliyor bu kisim. pdf de degil.
//programbuzz icinde masterthought cucumber reporting diye bir rapor var o da yapilabilir.
//https://www.programsbuzz.com/



    }


}
