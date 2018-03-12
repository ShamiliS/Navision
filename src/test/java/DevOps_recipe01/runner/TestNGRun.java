package test.java.DevOps_recipe01.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features = "feature", glue = { "test.java.DevOps_recipe01.Steps" })

public class TestNGRun extends AbstractTestNGCucumberTests/* extends customRunner */ {

	/*
	 * public TestRun(Class<? extends customRunner> class1) { String br = null;
	 * run_cukes(br); new customRunner(); }
	 */

	public TestNGRun() {

	}

}