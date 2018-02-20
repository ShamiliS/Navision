package test.java.Ooyala;

public class AppProperties {

	public static final String browserType = "Chrome"; // Possible Values: "Chrome", "Firefox", "IE"
	public static final String appURL = "http://the-internet.herokuapp.com/login";

	public static String getBrowsertype() {
		return browserType;
	}

	public static String getAppurl() {
		return appURL;
	}

}
