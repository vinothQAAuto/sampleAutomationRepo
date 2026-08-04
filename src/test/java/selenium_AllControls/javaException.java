package selenium_AllControls;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class javaException {

	@Test(enabled =false)
	public static void arithmethicException_withoutHandling()
	{
		System.out.println("Before execution Statement");  //atm card - machine --->> pin --> amount
		
		int a = 99/0;  //this line will give arithmeticExecption while executing this program     //99rs
		
		System.out.println("After execution statement");    //amount 
		
	/*	
Output:
	The below output will be displayed in the Eclipse IDE console. 
	From the output, its very clear that the Program execution stopped due to ArithmeticException and the last statement in the above program didn't get executed
	*/
	}
	

	@Test 
	public static void arithmethicException_withHandling()
	{
		System.out.println("Before execution Statement");
		
		try {
			int a = 99/0;
		} catch (ArithmeticException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("you can't divide a number by 0");
		}  //this line will give arithmeticExecption while executing this program
		
		System.out.println("After execution statement");
		
	/*	
Output:
	The below output will be displayed in the Eclipse IDE console. 
	From the output, its very clear that the Program execution stopped due to ArithmeticException and the last statement in the above program didn't get executed
	
	After using exception handling - 
	Now, execute the Exception handled code and observe that Exception will be handled and program will continue to execute without stopping when the exception occurs.
	*/
	
/*
		Different types of Exceptions in Selenium WebDriver 

		From the above examples, you understand what is an Exception and what happens when it occurs during program execution. Now, I will explain all the different types of Exceptions, we may face while working with Selenium WebDriver.

		Though there are many WebDriver Exceptions in Selenium, the below are the different WebDriver Exceptions that we commonly face while working with Selenium:
		NoSuchElementException
		ElementNotVisibleException
		NoSuchFrameException
		NoAlertPresentException
		NoSuchWindowException
		SessionNotFoundException
		StaleElementReferenceException	
*/
	}
	
	@Test (enabled = false)
	public static void noSuchElementException_withoutHandling()
	{
		 WebDriverManager.chromedriver().setup();
	 	    WebDriver driver = new ChromeDriver();
	 	   driver.get("https://www.selenium.dev/selenium/web/alerts.html#");
	        driver.findElement(By.id("alert1")).click();   //Wrong loctor name give here & getting the noSuchelement Exception
	        driver.quit();
	}
	
	
	@Test (priority=1)
	public static void noSuchElementException_withHandling()
	{
		 WebDriverManager.chromedriver().setup();
	 	    WebDriver driver = new ChromeDriver();
	 	   driver.get("https://www.selenium.dev/selenium/web/alerts.html#");
	        try {
				driver.findElement(By.id("alert1")).click();
			} catch (org.openqa.selenium.NoSuchElementException e) {
				// TODO Auto-generated catch block
				System.err.println("Handled NoSuchElementException");
			}   //Wrong loctor name give here & getting the noSuchelement Exception
	        
	        System.out.println("Executed correctly");
	        driver.quit();
	}
}
