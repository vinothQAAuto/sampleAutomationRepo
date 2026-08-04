package selenium_AllControls;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class allActions {
	
	static WebDriver driver;
	
	@Test(enabled = false)
	public static void interactWithElements()
	{
	WebDriverManager.chromedriver().setup();
	 driver = new ChromeDriver();
	 
     driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
     // Navigate to Url
     driver.get("https://www.selenium.dev/selenium/web/inputs.html");

     // Click on the element
     WebElement checkInput = driver.findElement(By.name("checkbox_input"));
     checkInput.click();
     Boolean isChecked = checkInput.isSelected();
     assertEquals(isChecked, false);

     // SendKeys
     // Clear field to empty it from any previous data
     WebElement emailInput = driver.findElement(By.name("email_input"));
     emailInput.clear();
     // Enter Text
     String email = "admin@localhost.dev";
     emailInput.sendKeys(email);
     // Verify
     String data = emailInput.getAttribute("value");
     assertEquals(data, email);

     // Clear Element
     // Clear field to empty it from any previous data
     emailInput.clear();
     data = emailInput.getAttribute("value");
     assertEquals(data, "");

     driver.quit();
     
	}
	
	@Test(enabled = false)
	public static void informationWithElements_WithoutContionalStatement() throws InterruptedException
	{
	WebDriverManager.chromedriver().setup();
	 driver = new ChromeDriver();
	 
	 driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
     // Navigate to Url
     driver.get("https://www.selenium.dev/selenium/web/inputs.html");
     Thread.sleep(2000); // pause for demo


     // isDisplayed
     // Get boolean value for is element display
     boolean isEmailVisible = driver.findElement(By.name("email_input")).isDisplayed();
     assertTrue(isEmailVisible);
     
     Thread.sleep(2000); // pause for demo


     // isEnabled
     // returns true if element is enabled
     boolean isEnabledButton = driver.findElement(By.name("button_input")).isEnabled();
     assertTrue(isEnabledButton);
     
     Thread.sleep(2000); // pause for demo


     // isSelected
     // returns true if element is checked
     boolean isSelectedCheck = driver.findElement(By.name("checkbox_input")).isSelected();
     assertTrue(isSelectedCheck);
     
     Thread.sleep(2000); // pause for demo


     // TagName
     // returns TagName of the element
     String tagNameInp = driver.findElement(By.name("email_input")).getTagName();
     assertEquals("input", tagNameInp);

     // GetRect
     // Returns height, width, x and y coordinates referenced element
     Rectangle res = driver.findElement(By.name("range_input")).getRect();
     // Rectangle class provides getX,getY, getWidth, getHeight methods
     assertEquals(10, res.getX());

     // Retrieves the computed style property 'font-size' of field
     String cssValue = driver.findElement(By.name("color_input")).getCssValue("font-size");
     assertEquals(cssValue, "13.3333px");


     // GetText
     // Retrieves the text of the element
     String text = driver.findElement(By.tagName("h1")).getText();
     assertEquals(text, "Testing Inputs");


     // FetchAttributes
     // identify the email text box
     WebElement emailTxt = driver.findElement(By.name(("email_input")));
     // fetch the value property associated with the textbox
     String valueInfo = emailTxt.getAttribute("value");
     assertEquals(valueInfo, "admin@localhost");

     driver.quit();

	}
	
	@Test(enabled = false)
	public static void informationWithElements_ContionalStatements() throws InterruptedException {
	    WebDriverManager.chromedriver().setup();
	    driver = new ChromeDriver();
	    driver.get("https://www.selenium.dev/selenium/web/inputs.html");

	    // Example 1: isDisplayed with conditional
	    WebElement emailInput = driver.findElement(By.name("email_input"));
	    if (emailInput.isDisplayed()) {
	        System.out.println("Email input is visible");
	        assertTrue(true);   // pass
	    } else {
	        System.out.println("Email input is NOT visible");
	        assertTrue(false);  // fail
	    }

	    // Example 2: isEnabled with conditional
	    WebElement buttonInput = driver.findElement(By.name("button_input"));
	    if (buttonInput.isEnabled()) {
	        System.out.println("Button is enabled");
	        assertTrue(true);
	    } else {
	        System.out.println("Button is disabled");
	        assertTrue(false);
	    }

	    // Example 3: isSelected with conditional
	    WebElement checkBox = driver.findElement(By.name("checkbox_input"));
	    if (checkBox.isSelected()) {
	        System.out.println("Checkbox is selected");
	        assertTrue(true);
	    } else {
	        System.out.println("Checkbox is not selected");
	        assertTrue(false);
	    }

	    // Example 4: TagName check
	    String tagName = emailInput.getTagName();
	    if ("input".equals(tagName)) {
	        System.out.println("Tag name is correct: " + tagName);
	        assertTrue(true);
	    } else {
	        System.out.println("Tag name mismatch: " + tagName);
	        assertTrue(false);
	    }

	    // Example 5: Attribute check
	    String valueInfo = emailInput.getAttribute("value");
	    if ("admin@localhost".equals(valueInfo)) {
	        System.out.println("Email value is correct: " + valueInfo);
	        assertTrue(true);
	    } else {
	        System.out.println("Email value mismatch: " + valueInfo);
	        assertTrue(false);
	    }

	    driver.quit();
	}
	
	@Test(enabled = false)
	public static void fileUpload() throws InterruptedException {
	    WebDriverManager.chromedriver().setup();
	    driver = new ChromeDriver();
	   // driver.get("https://www.selenium.dev/selenium/web/inputs.html");

	    driver.get("https://the-internet.herokuapp.com/upload");
	    File uploadFile = new File("src/test/java/resources/testFile.png");

	    WebElement fileInput = driver.findElement(By.cssSelector("input[type=file]"));
	    fileInput.sendKeys(uploadFile.getAbsolutePath());
	    driver.findElement(By.id("file-submit")).click();
	    
	    
	 // Wait until the uploaded file name is visible
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    WebElement fileName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("uploaded-files")));

	    Assert.assertEquals(fileName.getText(), "testFile.png");


//	    //Without wait getting error
//	    WebElement fileName = driver.findElement(By.id("uploaded-files"));
//	    Assert.assertEquals("testFile.png", fileName.getText());

	    driver.quit();
	}
	
	@Test(enabled = false)
	public static void InteractionsTest() throws InterruptedException {
	    WebDriverManager.chromedriver().setup();
	    driver = new ChromeDriver();
	    driver.get("https://www.selenium.dev/");
        
	    // get title
        String title = driver.getTitle();
        Assert.assertEquals(title, "Selenium");
        System.out.println("verified title successfully");
        
        //get Current URL
        String url = driver.getCurrentUrl();
        Assert.assertEquals(url, "https://www.selenium.dev/");
        System.out.println("verified Current URL successfully");

	    driver.quit();
	}
	
	@Test(enabled = false)
	public static void BrowserNavigation() throws InterruptedException {
	    WebDriverManager.chromedriver().setup();
	    driver = new ChromeDriver();
	    
	  //Convenient
        driver.get("https://selenium.dev");
            
        //Longer way
        driver.navigate().to("https://selenium.dev");
        String title = driver.getTitle();
        assertEquals(title, "Selenium");
        
        driver.findElement(By.xpath("//a[@id=\"navbarDropdown\"]")).click();
        driver.findElement(By.xpath("(//a[contains(text(),'About Selenium')])[1]")).click();
        Thread.sleep(2000); // pause for demo
        
        
        //Back
        driver.navigate().back();   // having issue in website
        driver.navigate().back();
        title = driver.getTitle();
        assertEquals(title, "Selenium");
        Thread.sleep(2000); // pause for demo
        
        //Forward
        driver.navigate().forward();
        title = driver.getTitle();
        assertEquals(title, "Selenium");
        Thread.sleep(2000); // pause for demo

        //Refresh
        driver.navigate().refresh();
        title = driver.getTitle();
        assertEquals(title, "Selenium");
        Thread.sleep(2000); // pause for demo

	    driver.quit();
	}
	
	
	
}
