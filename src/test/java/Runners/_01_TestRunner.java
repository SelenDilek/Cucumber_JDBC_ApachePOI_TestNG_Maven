package Runners; //paket(package) runner olmali.

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

//en son derste bunu yaptik normalde featurfiles klasorunden den calistiriyorduk. POM a burayi calistirmak icin testng yi ekledik.
@CucumberOptions(

        features = {"src/test/java/FeatureFiles/_01_Login.feature"}, //buraya feature files in path i verilecek
        glue = {"StepDefinitions"} //Step definitions in klasoru yazilir.



)

public class _01_TestRunner extends AbstractTestNGCucumberTests {
}
