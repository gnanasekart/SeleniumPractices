package SeleniumConcept;

import java.time.Duration;
import java.util.Date;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Wait_types {
	public static RemoteWebDriver driver;
	Date date;
	WebElement ele;

	@BeforeMethod
	public void Startup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		date = new Date();
		driver.get("https://www.google.com");
		ele = driver.findElement(By.xpath("(//input[@value=\"I'm Feeling Lucky\"])[2]"));
	}

	@Test
	public void implicity() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}
	
	@Test
	public void pageLoad() {
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(2));
	}
	
	@Test
	public void scriptLoad() {
		driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(5));
	}

	@Test
	public void explicity() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(ele));
	}

	@Test
	public void fluent() {
		//Declare and initialize a fluent wait
		FluentWait wait = new FluentWait(driver);

		//Specify the timeout of the wait
		wait.withTimeout(Duration.ofSeconds(30));

		//Specify polling time
		wait.pollingEvery(Duration.ofSeconds(5));

		//Specify what exceptions to ignore
		wait.ignoring(NoSuchElementException.class);

		wait.until(ExpectedConditions.elementToBeClickable(ele));
	}

	@AfterMethod
	public void teardown() {
		driver.close();
	}
}