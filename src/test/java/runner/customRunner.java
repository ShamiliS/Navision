package test.java.runner;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.testng.ITestContext;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Factory;

import cucumber.api.testng.AbstractTestNGCucumberTests;

public class customRunner extends AbstractTestNGCucumberTests{

	private static String browserType, type;
	private static Map<String, String> browsers = new LinkedHashMap();
	static List<String> strListBrowsers = new ArrayList<String>();
	
	@Factory
	public Object[] executefirst(ITestContext context){
		
		browserType = (String) context.getCurrentXmlTest().getTestParameters().get("browser");
		browsers.put(context.getCurrentXmlTest().getName(), browserType);
		strListBrowsers.add(browserType);
		System.out.println(browserType);
		return new Object[] {};
	}

	@SuppressWarnings("unchecked")
	public static String getBrowser() {
		return browserType;
	}
	
	public static Map<String, String> getBrowsers() {
		return browsers;
	}
	
	
	@BeforeTest
	public static String getBrowserType(ITestContext test){
		type = customRunner.getBrowsers().get(test.getName());
		return customRunner.getBrowsers().get(test.getName());
	}
//
//	@Parameters("browser")
//	@Test(groups = { "cucumber" }, description = "Runs Cucumber Features")
//	public void run_cukes(String browser) {
//		browserType = browser;
//		System.out.println(browser);
//		new TestRun(this.getClass());
//	}

	// public static String getBrowser(){
	// return browserType;
	// }

	// public customRunner(){
	//
	// }

	/*@Override
	public void run(IHookCallBack callBack, ITestResult testResult) {
		// IHookCallBack.runTestMethod(iTestResult);

	}*/

}
