package tests;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.TestBase;
import page.LoginPage;
import utils.ExcelUtils_ReadData;

public class LoginTest_WithExcelSheet_DataProvider extends TestBase {

	private static Workbook workbook;
	private static String excelFilePath;

	public static void setExcelFile(String excelPath, String sheetName) throws IOException {
		excelFilePath = excelPath;
		FileInputStream fis = new FileInputStream(excelPath);
		workbook = new XSSFWorkbook(fis);
	}

	public static String getCellData(int rowNum, int colNum, String sheetName) {
		Sheet sheet = workbook.getSheet(sheetName);
		Row row = sheet.getRow(rowNum);
		Cell cell = row.getCell(colNum);
		return cell.getStringCellValue();
	}

	public static int getRowCount(String sheetName) {
		Sheet sheet = workbook.getSheet(sheetName);
		return sheet.getLastRowNum() + 1;
	}

	// ✅ New method to write results back
	public static void setCellData(String sheetName, int rowNum, int colNum, String value) throws IOException {
		Sheet sheet = workbook.getSheet(sheetName);
		Row row = sheet.getRow(rowNum);
		Cell cell = row.getCell(colNum);

		if (cell == null) {
			cell = row.createCell(colNum);
		}
		cell.setCellValue(value);

		FileOutputStream fos = new FileOutputStream(excelFilePath);
		workbook.write(fos);
		fos.close();

	}
}
