package test.java.Ooyala.Steps;

import java.util.List;
import java.util.Map;

import org.testng.Reporter;

import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import test.java.Ooyala.AppProperties;
import test.java.Ooyala.Pages.CommonTestPage;
import test.java.Ooyala.Pages.LoginTestPage;

public class LoginPage extends CommonUtils {

	List<Map<String, String>> data;
	String Uname, Passw, msg;
	static String type;

	/*@Before
	@BeforeTest
	public void initalize() {
		System.out.println("Opening Application..");
	}*/
	
/*	@Before
	@BeforeTest
	public static String getBrowserType(ITestContext test){
		type = customRunner.getBrowsers().get(test.getName());
		return customRunner.getBrowsers().get(test.getName());
	}*/
	
	@Given("^launch an application URL$")
	public void launch_an_application_URL() throws Throwable {
		
		String browserType;
		//= customRunner.getBrowser();
		
		browserType = AppProperties.getBrowsertype();
		String appURL = AppProperties.getAppurl();
		
		CommonUtils.setDriver(browserType, appURL);
	    
	}
	@When("^I should see Login Page$")
	public void i_navigate_to_Login_Page() throws Throwable {
		LoginTestPage loginpage = new LoginTestPage(driver);

		boolean lblLoginpage = loginpage.getPageTitle().isDisplayed();
		if (!lblLoginpage) {
			Reporter.log("Login page is not displayed successfully");
		} else {
			Reporter.log("Login page is displayed successfully");
		}
	}

	@Then("^I enter username and password with valid credential$")
	public void i_enter_username_and_password_with_valid_credential()
			throws Throwable {
		LoginTestPage loginpage = new LoginTestPage(driver);

		Uname = loginpage.getLblusername().getText();
		Passw = loginpage.getLblpassword().getText();

		loginpage.getTxtusername().sendKeys(Uname);
		loginpage.getTxtpassword().sendKeys(Passw);
	}

	@Then("^I click Login button$")
	public void i_click_Login_button() throws Throwable {
		LoginTestPage loginpage = new LoginTestPage(driver);

		loginpage.getBntLogin().isDisplayed();
		loginpage.getBntLogin().click();
	}

	@Then("^I validate flash message after logged in successfully$")
	public void i_see_application_logged_in_successfully() throws Throwable {
		CommonTestPage commonpage = new CommonTestPage(driver);

		msg = commonpage.getLblFlashMsg().getText();

		if (msg.equals(" You logged into a secure area!")) {
			Reporter.log("Logged into the application successfully");
		} else {
			Reporter.log("problem!!Logging into the application");
		}
	}

	@When("^I enter \"(.*?)\" and \"(.*?)\" with invalid credential$")
	public void i_enter_and_with_invalid_credential(String Username,
			String Password) throws Throwable {
		LoginTestPage loginpage = new LoginTestPage(driver);

		loginpage.getTxtusername().sendKeys(Username);
		loginpage.getTxtpassword().sendKeys(Password);
	}

	@Then("^I validate Login page with valid \"(.*?)\"$")
	public void i_see_Login_page_with_valid(String Message) throws Throwable {
		CommonTestPage commonpage = new CommonTestPage(driver);

		msg = commonpage.getLblFlashMsg().getText();
		if (msg.equals(Message)) {
			Reporter.log("Logged into the application successfully");
		} else {
			Reporter.log("problem!!Logging into the application");
		}
	}

	@After
	public void teardown() {
		System.out.println("Quiting Application..");
		try {
			driver.close();
		} catch (Exception e) {
			
		}
		try {
			driver.quit();
		} catch (Exception e) {
			
		}
	}
	
}
