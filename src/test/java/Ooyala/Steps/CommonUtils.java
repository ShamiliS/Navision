package Ooyala.Steps;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class CommonUtils {

	protected static WebDriver driver;

	public static WebDriver setDriver(String bType, String appURL) {

		switch (bType) {
		case "Firefox":
			System.out.println("Launching Firefox browser..");
			System.setProperty("webdriver.gecko.driver",
					System.getProperty("user.dir")
							+ "\\lib\\gechodriver\\geckodriver.exe");
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.navigate().to(appURL);
			break;

		case "Chrome":
			System.out.println("Launching Google Chrome..");
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "\\lib\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.navigate().to(appURL);
			break;

		case "IE":
			System.out.println("Launching Internet Explorer..");
			System.setProperty("webdriver.ie.driver",
					System.getProperty("user.dir")
							+ "\\lib\\iedriver\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			driver.manage().window().maximize();
			driver.navigate().to(appURL);
			break;
		default:
			System.out.println("browser : " + bType + " is invalid");
		}
		return driver;
	}

	public static Map<String, String> readDatafromXMLFile() throws Exception {

		Map<String, String> userdet = new HashMap<String, String>();

		File file = new File(System.getProperty("user.dir")
				+ "\\TestData\\testdata.xml");
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(file);

		doc.getDocumentElement().normalize();
		NodeList nList = doc.getChildNodes();
		for (int temp = 0; temp < nList.getLength(); temp++) {
			Node nNode = nList.item(temp);
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
				Element eElement = (Element) nNode;
				userdet.put("ExpectedURL",
						eElement.getElementsByTagName("ExpectedURL").item(0)
								.getTextContent().toString());
			}
		}
		return userdet;

	}

}
