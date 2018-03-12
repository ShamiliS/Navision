package test.java.DevOps_recipe01.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import test.java.DevOps_recipe01.Steps.CommonUtils;

public class HomeTestPage extends CommonUtils {

	@FindBy(xpath = "//*[starts-with(@title,'Welcome')]")
	WebElement lblWelcome;

	@FindBy(xpath = "//li[@class='current']/a")
	WebElement lblCurrenttab;

	@FindBy(xpath = "//a[@class='megamenu_primary page  carets' and text()='BUs']")
	WebElement lnkBUs;

	@FindBy(xpath = "//a[text()='Sogeti UK']")
	WebElement lnkSogUK;
	
	@FindBy(xpath = "//button[@class='close_popin_btn']")
	WebElement imgClose;

	public HomeTestPage() {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public WebElement getLblWelcome() {
		return lblWelcome;
	}

	public WebElement getLblCurrenttab() {
		return lblCurrenttab;
	}

	public WebElement getLnkBUs() {
		return lnkBUs;
	}

	public WebElement getLnkSogUK() {
		return lnkSogUK;
	}

	public WebElement getImgClose() {
		return imgClose;
	}
	

}
