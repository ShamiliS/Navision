package test.java.DevOps_recipe01.Steps;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;

import com.cucumber.listener.Reporter;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import test.java.DevOps_recipe01.Pages.HomeTestPage;
import test.java.DevOps_recipe01.Pages.NavisionTestPage;
import test.java.DevOps_recipe01.Pages.SogetiUKTestPage;
import test.java.DevOps_recipe01.TestData.AppProperties;

public class HomePage extends CommonUtils {

	List<Map<String, String>> data;
	String Uname, Passw, msg;
	static String type;

	@Before
	public void initalize() throws Exception {
		System.out.println("Opening Application..");
		Reporter.assignAuthor("Regression");

	}

	@Given("^launch an application URL$")
	public void launch_an_application_URL() throws Throwable {

		String browserType; // = customRunner.getBrowser();

		browserType = AppProperties.getBrowsertype();
		String appURL = AppProperties.getAppurl();

		CommonUtils.setDriver(browserType, appURL);
	}

	@Given("^I should see Home Page$")
	public void i_should_see_Home_Page() {
		HomeTestPage homepage = new HomeTestPage();

		/*
		 * Handling unexpected Pop-up
		 */
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		// homepage.getImgClose().isDisplayed();
		// homepage.getImgClose().click();

		boolean flag = homepage.getLblWelcome().isDisplayed();
		assertEquals(true, flag);
	}

	@Given("^I validate current tab UK$")
	public void i_validate_current_tab_UK() {
		System.out.println("Need to implement");
	}

	@Then("^I navigate to navision page$")
	public void i_navigate_to_navision_page() {
		HomeTestPage homepage = new HomeTestPage();
		SogetiUKTestPage sogetipage = new SogetiUKTestPage();

		WebElement lnkBUs = homepage.getLnkBUs();
		WebElement lnkSogUK = homepage.getLnkSogUK();
		WebElement lnkNavision = sogetipage.getLnkNavision();

		Validate_click(lnkBUs, "BUs Link");
		Validate_click(lnkSogUK, "Sogeti UK Link");

		String pageTitle = driver.getTitle();
		assertEquals("Sogeti UK | Talent Capgemini", pageTitle);

		Validate_click(lnkNavision, "Navision Link");
	}

	@Then("^I validate navision page$")
	public void i_validate_navision_page() {
		NavisionTestPage navisionpage = new NavisionTestPage();
		Set<String> allWindowHandles = driver.getWindowHandles();

		for (String ele : allWindowHandles) {
			String windowname = driver.switchTo().window(ele).getTitle();
			if (windowname.equals("Summary")) {
				driver.switchTo().window(ele);
			}
		}
		waitforelement(navisionpage.getLnkActivityCard());
		assertEquals("https://navisionuk.sogeti.com/summary.aspx", driver.getCurrentUrl());
	}

	@After
	public void teardown(Scenario scen) {
		System.out.println("Quiting Application..");

		if (scen.isFailed()) {
			takeScreenshot();
		} else {
			System.out.println(scen.getStatus());
		}

		driver.close();
		driver.quit();
	}

}
