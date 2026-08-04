package selenium_AllControls;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class iframesTest {
	
	static WebDriver driver;
	
	@Test(priority =1)
	public static void UsingWebElement()
	{
		WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
       
        // Navigate to Url
        driver.get("https://www.selenium.dev/selenium/web/iframes.html");
       
        
        //switch To IFrame using Web Element
        WebElement iframe = driver.findElement(By.id("iframe1"));
        //Switch to the frame
        driver.switchTo().frame(iframe);
        assertEquals(true, driver.getPageSource().contains("We Leave From Here"));
        //Now we can type text into email field
        WebElement emailE = driver.findElement(By.id("email"));
        emailE.sendKeys("admin@selenium.dev");
        emailE.clear();
        driver.switchTo().defaultContent();
      
        
        //switch To IFrame using name or id
        WebElement iframe1=driver.findElement(By.name("iframe1-name"));
        //Switch to the frame
        driver.switchTo().frame(iframe1);
        assertEquals(true, driver.getPageSource().contains("We Leave From Here"));
        WebElement email = driver.findElement(By.id("email"));
        //Now we can type text into email field
        email.sendKeys("admin@selenium.dev");
        email.clear();
        driver.switchTo().defaultContent();
    
        
        //switch To IFrame using index
        driver.switchTo().frame(0);
        assertEquals(true, driver.getPageSource().contains("We Leave From Here"));
        
        //leave frame
        driver.switchTo().defaultContent();
        assertEquals(true, driver.getPageSource().contains("This page has iframes"));
        
        //quit the browser
        driver.quit();
	}

}
