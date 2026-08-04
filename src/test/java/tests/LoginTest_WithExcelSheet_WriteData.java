package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.TestBase;
import page.LoginPage;
import utils.ExcelUtils_WriteData;

public class LoginTest_WithExcelSheet_WriteData extends TestBase {
	

	@DataProvider(name = "LoginData")
    public Object[][] getData() throws Exception {
        String excelPath = System.getProperty("user.dir") + "/src/test/java/resources/Login_TestData_WriteData.xlsx";
        String sheetName = "Sheet1";

        ExcelUtils_WriteData.setExcelFile(excelPath, sheetName);
        int rowCount = ExcelUtils_WriteData.getRowCount(sheetName);

        Object[][] data = new Object[rowCount][2];

        for (int i = 0; i < rowCount; i++) {
            data[i][0] = ExcelUtils_WriteData.getCellData(i, 0, sheetName); // Username
            data[i][1] = ExcelUtils_WriteData.getCellData(i, 1, sheetName); // Password
        }
        return data;
    }

    @Test(dataProvider = "LoginData")
    public void loginTest(String username, String password) throws Exception {
        LoginPage login = new LoginPage(driver);

        login.enterUsername(username);
        login.enterPassword(password);
        login.clickLogin();

        boolean result;
        try {
            // Example: check if login success by verifying page title
            result = driver.getTitle().contains("Swag Labs");
        } catch (Exception e) {
            result = false;
        }

        // ✅ Write result back into Excel (column index 2 → third column)
        String sheetName = "Sheet1";
        int currentRow = findRowByUsername(sheetName, username); // helper method
        ExcelUtils_WriteData.setCellData(sheetName, currentRow, 2, result ? "Passed" : "Failed");

        Assert.assertTrue(result, "Login test failed for user: " + username);
    }

    // Helper method to find row by username
    private int findRowByUsername(String sheetName, String username) {
        int rowCount = ExcelUtils_WriteData.getRowCount(sheetName);
        for (int i = 0; i < rowCount; i++) {
            if (ExcelUtils_WriteData.getCellData(i, 0, sheetName).equals(username)) {
                return i;
            }
        }
        return -1;
    }


}
