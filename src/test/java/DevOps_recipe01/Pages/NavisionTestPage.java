package test.java.DevOps_recipe01.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import test.java.DevOps_recipe01.Steps.CommonUtils;

public class NavisionTestPage extends CommonUtils {

	@FindBy(id = "ctl00_ContentPlaceHolder1_Hl_CardActivity")
	WebElement lnkActivityCard;

	public NavisionTestPage() {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public WebElement getLnkActivityCard() {
		return lnkActivityCard;
	}

	public List<WebElement> getTblCalender() {
		List<WebElement> rows = driver
				.findElements(By.xpath("//*[@id=\"TableCalendarLeft\"]/tbody/tr[@class='Calendar_Line']"));
		return rows;
	}

	public int coldata(int line) {
		int cols = driver
				.findElements(
						By.xpath("//*[@id='TableCalendarLeft']/tbody/tr[@class='Calendar_Line'][" + line + "]/td"))
				.size();
		return cols;
	}

	public int colsExist(int row) {
		int flag = driver.findElements(By.xpath("//*[@id='TableCalendarLeft']/tbody/tr[@class='Calendar_Line'][" + row
				+ "]/td/*[contains(@id,'Tbx_Calendar')]")).size();
		return flag;
	}

	public WebElement enterdata(int row, int col) {
		WebElement eledata = driver
				.findElement(By.xpath("//*[@id='TableCalendarLeft']/tbody/tr[@class='Calendar_Line'][" + row + "]/td["
						+ col + "]/input[contains(@id,'Tbx_Calendar')]"));
		return eledata;
	}

}
