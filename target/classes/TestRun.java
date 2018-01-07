package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features = "feature", glue = { "Ooyala.Steps" })
public class TestRun extends AbstractTestNGCucumberTests {

}