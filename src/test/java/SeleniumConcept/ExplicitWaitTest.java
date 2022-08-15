package SeleniumConcept;

import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class ExplicitWaitTest {

	public static RemoteWebDriver driver;
	public static WebDriverWait wait;

	@BeforeMethod
	public void beforeMethod() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.leafground.com/waits.xhtml");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	//@Test
	public void waitForVisibility() {
		String clickbutton = "(//div[@class='card']/h5[contains(text(),'Wait for Visibility')]//following::span[text()='Click'])[1]";
		driver.findElement(By.xpath(clickbutton)).click();

		String hereButton = "(//div[@class='card']/h5[contains(text(),'Wait for Visibility')]//following::span[text()='I am here'])";

		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(hereButton))));
	}
	
	//@Test
	public void waitForInVisibility() {
		String clickbutton = "(//div[@class='card']/h5[contains(text(),'Wait for Invisibility')]//following::span[text()='Click'])[1]";
		driver.findElement(By.xpath(clickbutton)).click();

		String hereButton = "(//div[@class='card']/h5[contains(text(),'Wait for Invisibility')]//following::span[text()='I am about to hide'])";

		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath(hereButton))));
	}
	
	@Test
	public void waitForClickability() {
		String clickbutton = "(//div[@class='card']/h5[contains(text(),'Wait for Clickability')]//following::span[text()='Click First Button'])[1]";
		driver.findElement(By.xpath(clickbutton)).click();
		List<WebElement> ele = driver.findElements(By.className("ui-growl-item"));
		
		//System.out.println(ele.size());
		Assert.assertEquals(ele.size(), 3);
		
		wait.until(ExpectedConditions.visibilityOfAllElements(ele));
	}

	@AfterMethod
	public void afterMethod() {
		driver.close();
	}
}