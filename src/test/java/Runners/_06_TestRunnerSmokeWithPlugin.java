package Runners;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterClass;

@CucumberOptions(
        //dryrun=calistirmadan her sey tamam mi diyekontrol ediyor. sadece kontrol eder sistemi calistirmaz.Eksik dosya var mi diye
        //kontrol eder. kuru calistirma on calistirma. Onceden bakiyor testleri calistirmiyor stepler yerinde mi diye on kontrol yapiyor.

        tags = "@SmokeTest",
        features = {"src/test/java/FeatureFiles"},
        glue={"StepDefinitions"},
        dryRun = false, // true olduğunda testi çalıştırmaz sadece feature lara ait steplerin varlığını kontrol eder.
        // False olduğunda ise testi çalıştırır.
        plugin= {"html:target/site/cucumber-pretty.html"}  // simple report //plugin rapor oldugunu anliyor
        //cucumber basic report plugin

//https://www.programsbuzz.com/ -> raporlar icin ->testNG yi buluyoruz. en altlarda ->Cucumber TestNG: Generate Extent Report
 //https://www.programsbuzz.com/article/cucumber-testng-generate-extent-report-using-extent-adapter-grasshopper
)
public class _06_TestRunnerSmokeWithPlugin extends AbstractTestNGCucumberTests {


    @AfterClass
    public static void Deneme(){

        //Extend report islemleri icin ayrilan bolum.
        //plugin icine de eklenti yazilir. extend report icinde bulunan kisim

    }




}
