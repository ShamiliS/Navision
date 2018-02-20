package test.java.Ooyala.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import test.java.Ooyala.Steps.CommonUtils;

public class LoginTestPage extends CommonUtils{

	@FindBy(xpath = "//*[@id='content']//h2")
	WebElement pageTitle;

	@FindBy(xpath = "//*[@id='content']//em[1]")
	WebElement lblusername;

	@FindBy(xpath = "//*[@id='content']//em[2]")
	WebElement lblpassword;

	@FindBy(id = "username")
	WebElement txtusername;

	@FindBy(name = "password")
	WebElement txtpassword;
	
	@FindBy(xpath = "//*[@id='login']/button")
	WebElement bntLogin;
	
	public LoginTestPage(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public WebElement getPageTitle() {
		return pageTitle;
	}

	public WebElement getLblusername() {
		return lblusername;
	}

	public WebElement getLblpassword() {
		return lblpassword;
	}

	public WebElement getTxtusername() {
		return txtusername;
	}

	public WebElement getTxtpassword() {
		return txtpassword;
	}

	public WebElement getBntLogin() {
		return bntLogin;
	}
	
}
