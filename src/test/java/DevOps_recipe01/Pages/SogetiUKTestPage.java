package test.java.DevOps_recipe01.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import test.java.DevOps_recipe01.Steps.CommonUtils;

public class SogetiUKTestPage extends CommonUtils {

	@FindBy(xpath = "//*[text()='Navision']")
	WebElement lnkNavision;

	public SogetiUKTestPage() {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public WebElement getLnkNavision() {
		return lnkNavision;
	}
	
}
