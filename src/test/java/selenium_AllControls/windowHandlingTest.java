package selenium_AllControls;

import static org.junit.Assert.assertNotNull;
import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class windowHandlingTest {
	static WebDriver driver;

	@Test
	public static void window() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
		// Navigate to Url
		driver.get("https://www.selenium.dev/selenium/web/window_switching_tests/page_with_frame.html");
		// fetch handle of this
		String currHandle = driver.getWindowHandle(); // current window
		assertNotNull(currHandle);

		// click on link to open a new window
						driver.findElement(By.linkText("Open new window")).click();
		// fetch handles of all windows, there will be two, [0]- default, [1] - new
		// window
		Object[] windowHandles = driver.getWindowHandles().toArray(); // multiple window handlinh
		driver.switchTo().window((String) windowHandles[1]); // 1 is the new window. 0 is default window
		// assert on title of new window
		String title = driver.getTitle();
		assertEquals("Simple Page", title);

		// System.out.println(title);

		// closing current windo
						driver.close();
		// Switch back to the old tab or window
		driver.switchTo().window((String) windowHandles[0]);

		// Opens a new tab and switches to new tab
		driver.switchTo().newWindow(WindowType.TAB);
		// assertEquals("",driver.getTitle());

		// System.out.println(driver.getTitle());

		// Opens a new window and switches to new window
		driver.switchTo().newWindow(WindowType.WINDOW);
		// assertEquals("",driver.getTitle());

		Thread.sleep(2000);
		// quitting driver
		driver.close(); // close all windows

	}
}
