package test.java.Ooyala.Pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import test.java.Ooyala.Steps.CommonUtils;

public class SecureAreaTestPage extends CommonUtils {

	@FindBy(xpath = "//*[@id='content']//h2")
	WebElement pageTitle;

	@FindBy(xpath = "//*[@id='content']//a")
	WebElement lnkLogout;

	@FindBy(xpath = "//a")
	List<WebElement> lnkAll;

	@FindBy(xpath = "//a[@href='#']")
	WebElement closeMsg;

	@FindBy(xpath = "//a[contains(@href,'github.com')]")
	WebElement imggit;

	public SecureAreaTestPage(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public WebElement getPageTitle() {
		return pageTitle;
	}

	public WebElement getLnkLogout() {
		return lnkLogout;
	}

	public List<WebElement> getLnkAll() {
		return lnkAll;
	}

	public WebElement getCloseMsg() {
		return closeMsg;
	}

	public WebElement getImggit() {
		return imggit;
	}

}
