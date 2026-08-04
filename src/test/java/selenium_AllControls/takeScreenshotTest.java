package selenium_AllControls;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class takeScreenshotTest {
	
	static WebDriver driver;
	
	@Test
	public static void sampleScreenshotWithoutElement() throws IOException
	{
		WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();
        driver.get("http://www.example.com");
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File("./image.png"));
        driver.quit();
	}

	
	@Test
	public static void sampleScreenshotWithElement() throws IOException
	{
		WebDriverManager.chromedriver().setup();
		driver.get("https://www.example.com");
	    WebElement element = driver.findElement(By.cssSelector("h1"));
	    File scrFile = element.getScreenshotAs(OutputType.FILE);
	    FileUtils.copyFile(scrFile, new File("./image.png"));
	    driver.quit();
	}

}
