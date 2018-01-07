package Ooyala.Steps;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebElement;
//import org.testng.Reporter;

import Ooyala.Steps.CommonUtils;
import Ooyala.Pages.CommonTestPage;
import Ooyala.Pages.SecureAreaTestPage;
import cucumber.api.java.en.Then;

public class SecureAreaPage extends CommonUtils {

	SecureAreaTestPage Securepage = new SecureAreaTestPage(driver);
	int nooflinks;
	Map<String, String> inputdata;
	CommonTestPage commonpage = new CommonTestPage(driver);
	String ActualURL, ExpectedURL;
	List<WebElement> links;

	@Then("^I Logout from the application$")
	public void i_Logout_from_the_application() throws Throwable {

		Securepage.getLnkLogout().isDisplayed();
		Securepage.getLnkLogout().click();
	}

	@Then("^I navigate and validate all links in the Secure Area page$")
	public void i_navigate_and_validate_all_links_in_the_Secure_Area_page()
			throws Throwable {
		inputdata = CommonUtils.readDatafromXMLFile();
		links = Securepage.getLnkAll();
		nooflinks = links.size();

		// Close FlashMessage
		Securepage.getCloseMsg().click();
		boolean isenab = commonpage.getLblFlashMsg().isDisplayed();
		if (!isenab) {
			// Reporter.log("Flash Message is closed successfully");
		} else {
			// Reporter.log("Flash Message is not closed..");
		}

		// Click Fork me on GitHub

		commonpage.getLnkGitHub().isDisplayed();
		commonpage.getLnkGitHub().click();
		ActualURL = driver.getCurrentUrl();
		ExpectedURL = inputdata.get("ExpectedURL");

		if (ActualURL.contains(ExpectedURL)) {
			// Reporter.log("GitHub page is displayed as expected");
		} else {
			// Reporter.log("GitHub page is not displayed");
		}

		// Navigate to back to Secure Area Page
		driver.navigate().back();
	}

}
