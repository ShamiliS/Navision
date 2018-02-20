package test.java.Ooyala.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import test.java.Ooyala.Steps.CommonUtils;

public class CommonTestPage extends CommonUtils {

	@FindBy(xpath = "//*[@id='flash']")
	WebElement lblFlashMsg;
	
	@FindBy(xpath="//*[@alt='Fork me on GitHub']")
	WebElement lnkGitHub;

	public CommonTestPage(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public WebElement getLblFlashMsg() {
		return lblFlashMsg;
	}
	
	public WebElement getLnkGitHub() {
		return lnkGitHub;
	}

}
