package Runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
//tum faturefiles icinde senerio basinda @SmokeTest tagi olanlari calistir.
@CucumberOptions(

        tags = "@SmokeTest",
        features = {"src/test/java/FeatureFiles"},
        glue = {"StepDefinitions"}
)

public class _04_TestRunnerSmoke extends AbstractTestNGCucumberTests {
}