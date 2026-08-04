package selenium_AllControls;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class alertsTest {
WebDriver driver;
WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	
    @BeforeMethod
    public void createSession() {
    	 WebDriverManager.chromedriver().setup();
 	    driver = new ChromeDriver();
       WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @AfterMethod
    public void quitSession() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test(enabled = false)
    public void alertInformationTest() {
        driver.get("https://www.selenium.dev/selenium/web/alerts.html#");
        driver.findElement(By.id("alert")).click();   //click me link

      
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
       wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        Assert.assertEquals(alert.getText(), "cheese");
        alert.accept();
    }
    
    

    
    @Test(enabled = false)
    public void alertEmptyInformationTest() {
        driver.get("https://www.selenium.dev/selenium/web/alerts.html#");
        driver.findElement(By.id("empty-alert")).click();

        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        Assert.assertEquals(alert.getText(), "");
        alert.accept();
    }

    @Test 
    public void promptDisplayAndInputTest() throws InterruptedException {
        
    	
    	driver.get("https://www.selenium.dev/selenium/web/alerts.html#");
        driver.findElement(By.id("prompt")).click();
        
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        Thread.sleep(2000);
        Assert.assertEquals(alert.getText(), "Enter something");

        alert.sendKeys("Selenium");
        alert.accept();
    }

    @Test (enabled = false)
    public void promptDefaultInputTest() {
        driver.get("https://www.selenium.dev/selenium/web/alerts.html#");
        driver.findElement(By.id("prompt-with-default")).click();

        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        Assert.assertEquals(alert.getText(), "Enter something");
        alert.accept();
    }

    @Test (enabled = false)
    public void multiplePromptInputsTest() {
        driver.get("https://www.selenium.dev/selenium/web/alerts.html#");
        driver.findElement(By.id("double-prompt")).click();

        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert1 = driver.switchTo().alert();
        Assert.assertEquals(alert1.getText(), "First");
        alert1.sendKeys("first");
        alert1.accept();

        Alert alert2 = driver.switchTo().alert();
        Assert.assertEquals(alert2.getText(), "Second");
        alert2.sendKeys("second");
        alert2.accept();
    }

    @Test(enabled = false)
    public void slowAlertTest() {
        driver.get("https://www.selenium.dev/selenium/web/alerts.html#");
        driver.findElement(By.id("slow-alert")).click();

        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        Assert.assertEquals(alert.getText(), "Slow");
        alert.accept();
    }

    @Test(enabled = false)
    public void confirmationAlertTest() {
        driver.get("https://www.selenium.dev/selenium/web/alerts.html#");
        driver.findElement(By.id("confirm")).click();

        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        Assert.assertEquals(alert.getText(), "Are you sure?");
        alert.accept();

        Assert.assertTrue(driver.getCurrentUrl().endsWith("simpleTest.html"));
    }

    @Test(enabled = false)
    public void iframeAlertTest() {
        driver.get("https://www.selenium.dev/selenium/web/alerts.html#");
        WebElement iframe = driver.findElement(By.name("iframeWithAlert"));
        driver.switchTo().frame(iframe);

        driver.findElement(By.id("alertInFrame")).click();
        wait.until(ExpectedConditions.alertIsPresent());

        Alert alert = driver.switchTo().alert();
        Assert.assertEquals(alert.getText(), "framed cheese");
        alert.accept();
    }

    @Test(enabled = false)
    public void nestedIframeAlertTest() {
        driver.get("https://www.selenium.dev/selenium/web/alerts.html#");
        WebElement iframe1 = driver.findElement(By.name("iframeWithIframe"));
        driver.switchTo().frame(iframe1);

        WebElement iframe2 = driver.findElement(By.name("iframeWithAlert"));
        driver.switchTo().frame(iframe2);

        driver.findElement(By.id("alertInFrame")).click();
        wait.until(ExpectedConditions.alertIsPresent());

        Alert alert = driver.switchTo().alert();
        Assert.assertEquals(alert.getText(), "framed cheese");
        alert.accept();
    }

    @Test(enabled = false)
    public void testForAlerts() {
        // Create ChromeOptions directly
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--start-maximized");
        chromeOptions.addArguments("disable-search-engine-choice-screen");

        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));

        driver.get("https://www.selenium.dev/documentation/webdriver/interactions/alerts/");

        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Simple alert
        js.executeScript("alert('Sample Alert');");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        Assert.assertEquals(alert.getText(), "Sample Alert");
        alert.accept();

        // Confirmation alert
        js.executeScript("confirm('Are you sure?');");
        wait.until(ExpectedConditions.alertIsPresent());
        alert = driver.switchTo().alert();
        Assert.assertEquals(alert.getText(), "Are you sure?");
        alert.dismiss();
        
     // Prompt alert
        js.executeScript("prompt('What is your name?');");
        wait.until(ExpectedConditions.alertIsPresent());
        alert = driver.switchTo().alert();
        Assert.assertEquals(alert.getText(), "What is your name?");
        alert.sendKeys("Selenium");
        alert.accept();

        driver.quit();
    }
  
}

