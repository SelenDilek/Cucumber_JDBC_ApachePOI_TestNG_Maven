package Runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
//beraber featurelari calistirma
@CucumberOptions(

        features = {"src/test/java/FeatureFiles/_01_Login.feature",
                "src/test/java/FeatureFiles/_02_Country.feature"},

        glue={"StepDefinitions"}


)

public class _02_TestRunnerBelirliFeaturelar extends AbstractTestNGCucumberTests {
}
