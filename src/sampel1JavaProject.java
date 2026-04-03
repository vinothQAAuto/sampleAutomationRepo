import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class sampel1JavaProject {

	WebDriver driver;

	public static void main(String[] args) {

		// Required software need to download

		// 1)download the browser--- firefox
		// 2)Which laung --- seleuim - java, python -- Selenium + java jar download

		System.setProperty("webdriver.firefox.driver",
				"C:\\Users\\Vinothkumar\\Downloads\\geckodriver-v0.36.0-win32 (1)\\geckdriver.exe");

		WebDriver driver = new FirefoxDriver();

	

		// driver.getTitle();

	
		
		
		driver.get("https://www.saucedemo.com/"); //url of the application
		
		System.out.println(driver.getTitle()); //title of the application
		
		
		/*
		 * //Correct Username and Correct password
		 * 
		 * driver.findElement(By.id("user-name")).sendKeys("standard_user"); //username
		 * 
		 * driver.findElement(By.xpath(
		 * "/html/body/div/div/div[2]/div[1]/div/div/form/div[2]/input")).sendKeys(
		 * "secret_sauce"); //password
		 * 
		 * driver.findElement(By.id("login-button")).click(); //login button
		 */
		
		
		//correct username and wrong password
	    driver.findElement(By.id("user-name")).sendKeys("standard_user");	//username
		
		driver.findElement(By.xpath("/html/body/div/div/div[2]/div[1]/div/div/form/div[2]/input")).sendKeys("23243242"); //password
		
		driver.findElement(By.id("login-button")).click();   //login button
		
		
	
		

		/*
		 * 
		 * driver.get("https://www.saucedemo.com/");
		 * 
		 * 
		 * driver.get("https://www.flipkart.com/");
		 * 
		 * 
		 * 
		 * driver.get("https://www.amazon.in/");
		 */

		// multiple line of code -- Ctrl + Shift + //
		// single line of code --- //

		// driver.close();

	}

}
