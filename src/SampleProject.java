import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SampleProject {

	WebDriver driver;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		 // Set the path to your browser driver executable
        System.setProperty("webdriver.firefox.driver", "C:\\Users\\Vinothkumar\\Downloads\\geckodriver-v0.36.0-win32 (1)/geckodriver.exe"); 

        WebDriver driver = new FirefoxDriver(); // Initialize the browser

        driver.get("https://www.saucedemo.com/"); // Open a URL

        System.out.println("Page Title: " + driver.getTitle()); // Print the page title

        driver.quit(); // Close the browser


	}

}
