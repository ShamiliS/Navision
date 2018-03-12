package test.java.DevOps_recipe01.runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "feature/Navision.feature", glue = "test.java.DevOps_recipe01.Steps", format = { "pretty",
		"html:target/site/cucumber-pretty", "json:target/cucumber.json" })
public class TestRunner {

}
