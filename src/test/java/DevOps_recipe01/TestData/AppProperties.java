package test.java.DevOps_recipe01.TestData;

public class AppProperties {

	/*
	 * Possible Values: "Chrome", "Firefox", "IE"
	 */
	static String browserType = "Chrome";
	static String appURL = "https://talent.capgemini.com/uk";

	public static String getBrowsertype() {
		return browserType;
	}

	public static String getAppurl() {
		return appURL;
	}

}
