package test.java.DevOps_recipe01.Steps;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class CommonUtils /* extends cusRunner2 */ {

	protected static WebDriver driver;

	public static WebDriver setDriver(String bType, String appURL) {

		switch (bType) {
		case "Firefox":
			System.out.println("Launching Firefox browser..");
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\lib\\geckodriver.exe");
			driver = new FirefoxDriver();
			break;

		case "Chrome":
			System.out.println("Launching Google Chrome..");
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\lib\\chromedriver.exe");
			driver = new ChromeDriver();
			break;

		case "IE":
			System.out.println("Launching Internet Explorer..");
			System.setProperty("webdriver.ie.driver",
					System.getProperty("user.dir") + "\\lib\\iedriver\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			break;

		default:
			System.out.println("browser : " + bType + " is invalid");
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.navigate().to(appURL);
		return driver;
	}

	public static Map<String, String> readDatafromXMLFile() throws Exception {

		Map<String, String> userdet = new HashMap<String, String>();

		/*
		 * File file = new File(System.getProperty("user.dir") +
		 * "\\TestData\\testdata.xml"); DocumentBuilderFactory dbFactory =
		 * DocumentBuilderFactory.newInstance(); DocumentBuilder dBuilder =
		 * dbFactory.newDocumentBuilder(); Document doc = dBuilder.parse(file);
		 * 
		 * doc.getDocumentElement().normalize(); NodeList nList = doc.getChildNodes();
		 * for (int temp = 0; temp < nList.getLength(); temp++) { Node nNode =
		 * nList.item(temp); if (nNode.getNodeType() == Node.ELEMENT_NODE) { Element
		 * eElement = (Element) nNode; userdet.put("ExpectedURL",
		 * eElement.getElementsByTagName("ExpectedURL").item(0).getTextContent().
		 * toString()); } }
		 */
		return userdet;
	}

	public void Validate_click(WebElement EleName, String EleValue) {
		try {
			EleName.isDisplayed();
			System.out.println(EleName.isDisplayed());
			EleName.click();
		} catch (Exception e) {
			Reporter.log("Unable to find an Element " + EleValue);
		}
	}

	public void waitforelement(WebElement ele) {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOf(ele));
	}

	public void takeScreenshot() {
		String dest = System.getProperty("user.dir") + "/Screenshots";
		File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(file, new File(dest + "/screen" + ".jpg"));
		} catch (Exception e) {

		}
	}

}
