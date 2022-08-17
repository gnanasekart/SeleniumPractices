package SeleniumConcept;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;

public class IFrameClass {

	public static WebDriver driver;
	public static Actions action;

	@BeforeMethod
	public void beforeMethod() {
		WebDriverManager.chromiumdriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().deleteAllCookies();
		driver.get("https://leafground.com/frame.xhtml");
	}

	@Test
	public void example1() {
		WebElement frameone = driver.findElement(By.xpath("//h5[contains(text(), 'Inside frame')]//following::iframe"));
		driver.switchTo().frame(frameone);
		driver.findElement(By.id("Click")).click();
		
		driver.switchTo().defaultContent();
		driver.findElement(By.className("card"));
	}

	@Test
	public void example2() {
		WebElement frametwo = driver.findElement(By.xpath("(//h5[contains(text(), 'Inside Nested frame')]//following::iframe)[1]"));
		driver.switchTo().frame(frametwo).switchTo().frame(driver.findElement(By.xpath("//iframe[@name='frame2']")));
		driver.findElement(By.id("Click")).click();
	}

	@AfterMethod
	public void afterMethod() {
		//driver.quit();
	}
}