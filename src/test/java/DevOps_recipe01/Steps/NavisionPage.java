package test.java.DevOps_recipe01.Steps;

import java.io.File;

import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import cucumber.api.java.en.Then;
import org.apache.commons.io.FileUtils;

import test.java.DevOps_recipe01.Pages.NavisionTestPage;

public class NavisionPage extends CommonUtils {

	@Then("^I click link Activity Card$")
	public void i_click_link_Activity_Card() {
		NavisionTestPage navisionpage = new NavisionTestPage();

		navisionpage.getLnkActivityCard().isDisplayed();
		navisionpage.getLnkActivityCard().click();
	}

	@Then("^I enter data into navision page$")
	public void i_enter_data_into_navision_page() throws Exception {
		NavisionTestPage navisionpage = new NavisionTestPage();
		String data[][] = fetchdata();

		int rows = navisionpage.getTblCalender().size();

		for (int i = 1; i < rows; i++) {
			int cols = navisionpage.coldata(i);
			int colsExist = navisionpage.colsExist(i);
			for (int k = cols - colsExist; k < cols - 2; k++) {
				WebElement dataenter = navisionpage.enterdata(i, k + 1);
				dataenter.sendKeys(String.valueOf(data[0][k]));
			}
		}

		takeScreenshot();
	}

	public String[][] fetchdata() throws Exception {
		int i, j;

		String val[][] = null;
		String excelFilePath = System.getProperty("user.dir")
				+ "\\src\\test\\java\\DevOps_recipe01\\Testdata\\Navision.xlsx";
		System.out.println(excelFilePath);
		OPCPackage pkg = OPCPackage.open(new File(excelFilePath));

		XSSFWorkbook workbook = new XSSFWorkbook(pkg);
		XSSFSheet sheet = workbook.getSheetAt(0);

		int rowCount = sheet.getPhysicalNumberOfRows();
		int colCount = sheet.getRow(0).getPhysicalNumberOfCells();

		val = new String[rowCount][colCount];

		for (i = 0; i < rowCount - 1; i++) {

			Row row = sheet.getRow(i + 1);

			for (j = 0; j < row.getLastCellNum(); j++) {

				Cell cell1 = sheet.getRow(i + 1).getCell(j);

				switch (cell1.getCellType()) {

				case Cell.CELL_TYPE_STRING:
					val[i][j] = cell1.getStringCellValue();
					break;

				case Cell.CELL_TYPE_NUMERIC:
					/*
					 * if (DateUtil.isCellDateFormatted(cell1)) { val[i][j] =
					 * cell1.getDateCellValue(); } else {
					 */
					val[i][j] = Double.toString(cell1.getNumericCellValue());

					break;

				case Cell.CELL_TYPE_BOOLEAN:
					val[i][j] = Boolean.toString(cell1.getBooleanCellValue());
					break;

				case Cell.CELL_TYPE_FORMULA:
					val[i][j] = cell1.getCellFormula();
					break;

				default:
					System.out.println();
				}
			}
		}

		workbook.close();
		return val;
	}

}
