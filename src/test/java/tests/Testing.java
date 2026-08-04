package tests;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Testing {

	
		
		WebDriver driver;
		WebDriverWait wait;
		
		@BeforeMethod
	    public void createSession() {
	    	 WebDriverManager.chromedriver().setup();
	 	    driver = new ChromeDriver();
	 	    wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	       //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    }

	    @AfterMethod
	    public void quitSession() {
	        if (driver != null) {
	            driver.quit();
	        }
	    }
		

		  @Test
		    public void alertInformationTest1() {
			  
			  
		        driver.get("https://www.selenium.dev/selenium/web/alerts.html#");
		        driver.findElement(By.id("alert")).click();   //click me link

		        
		        //implicit wait
		        
		        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		        
		        //explict wait
		       // WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		       wait.until(ExpectedConditions.alertIsPresent());
		       
		       
		       
		       Alert abc = driver.switchTo().alert();
		       
		       Assert.assertEquals(abc.getText(), "cheese");
		       
		       abc.accept();
		       
		    }


	
	

}
