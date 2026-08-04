package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import org.testng.annotations.Test;

import base.TestBase;
import page.LoginPage;

public class LoginTest extends TestBase{
	
	
	
//	@BeforeTest
//    public void testValidBefore() {
//        
//       System.out.println("Goign to login the application");
//    }
	
	
	
	
	@Test
    public void ValidUserName_ValidPassword() {
        LoginPage login = new LoginPage(driver);
                
        login.enterUsername("standard_user");
        login.enterPassword("secret_sauce");
        login.clickLogin();
        
        
        
        System.out.println("User Logged in successfully - 1st test cases");
        
        //driver.close();
        // Assertion logic here
       
    }
	
	@Test
    public void InValidUserName_InValidPassword1() {
        LoginPage login = new LoginPage(driver);
                
        login.enterUsername("admin");
        login.enterPassword("password123");
        login.clickLogin();
        
        
        
        System.out.println("User Logged in successfully - 1st test cases");
        
        //driver.close();
        // Assertion logic here
       
    }
	
	
	
	@Test
    public void ValidUserName_InValidPassword() {
        
		
	       LoginPage login = new LoginPage(driver);
           
	        login.enterUsername("standard_user");
	        login.enterPassword("password12333333333");
	        login.clickLogin();
	        
	        WebElement element = driver.findElement(By.xpath("//button[@class=\"error-button\"]"));
	        
	        element.getText();
	        
	        System.out.println(element.getText());
	        
	        
        System.out.println("User Logged in successfully - 2nd test cases");
        
        //driver.close();
        // Assertion logic here
       
    }
	
	
	@Test
    public void InValidUserName_InValidPassword() {
        
		
	       LoginPage login = new LoginPage(driver);
           
	        login.enterUsername("admin");
	        login.enterPassword("password12333333333");
	        login.clickLogin();
	        
	        WebElement element = driver.findElement(By.xpath("//button[@class=\"error-button\"]"));
	        
	        element.getText();
	        
	        System.out.println(element.getText());
	        
	        
        System.out.println("User Logged in successfully - 2nd test cases");
        
        //driver.close();
        // Assertion logic here
       
    }
	
//	
//	@Test
//    public void InValidUserName_InValidPassword() {
//        
//        System.out.println("User Logged in successfully - 3rd test cases");
//        
//        //driver.close();
//        // Assertion logic here
//       
//    }
//	
//	
//	@Test
//    public void InValidUserName_ValidPassword() {
//        
//        System.out.println("User Logged in successfully - 4th test cases");
//        
//        //driver.close();
//        // Assertion logic here
//       
//    }
//	
//	@Test
//    public void testValidLogin1() {
//        LoginPage login = new LoginPage(driver);
//                
//        login.enterUsername("admin");
//        login.enterPassword("password123");
//        login.clickLogin();
//        
//        //driver.close();
//        // Assertion logic here
//       
//    }
	
	
	
//	@AfterTest
//    public void testValidAfter() {
//        
//       System.out.println("Application is logged out successfully");
//    }


}
