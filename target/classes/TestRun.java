package test.java.runner;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features = "feature", glue = { "test.java.Ooyala" })
public class TestRun extends customRunner {

	public TestRun(Class<? extends customRunner> class1) {
//	String br = null;
//		run_cukes(br);
//		new customRunner();
	}

	public TestRun() {
		// TODO Auto-generated constructor stub
		System.out.println("Am here");
	}

	
	

	
	
	
	
}