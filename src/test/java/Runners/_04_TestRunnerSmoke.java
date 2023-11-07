package Runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
//tum faturefiles icinde senerio basinda @SmokeTest tagi olanlari calistir.
@CucumberOptions(

        tags = "@SmokeTest",
        features = {"src/test/java/FeatureFiles"},
        glue = {"StepDefinitions"},
        plugin= {"json:target/cucumber/cucumber.json"} // Jenkins için JSON report
        //bu kisim jenkins icin eklendi
)

public class _04_TestRunnerSmoke extends AbstractTestNGCucumberTests {
}