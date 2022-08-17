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
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class HyperLinkTest {

	public static RemoteWebDriver driver;
	public static WebDriverWait wait;

	@BeforeMethod
	public void beforeMethod() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.leafground.com/link.xhtml");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		//wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	//@Test
	public void counWithoutClick() {
		String text = driver.findElement(By.xpath("(//*[contains(text(), 'Find my ')]//following::a)[1]")).getAttribute("href").split(";")[0];
		driver.navigate().to(text);
		Assert.assertEquals(driver.getCurrentUrl(), text);
	}

	//@Test
	public void duplicateLink() {
		List<WebElement> url = driver.findElements(By.xpath("//*[@href='/dashboard.xhtml'][@class='ui-link ui-widget']"));

		Assert.assertEquals(url.size(), 2);
	}

	@Test
	public void totalLink() {
		int htmlCount = driver.findElements(By.xpath("//*[contains(@href, 'html')]")).size();
		int aTagLinkCount = driver.findElements(By.xpath("//a[contains(@href, 'html')]")).size();
		System.out.println("total html links = "+htmlCount+", and which include <a> tag links are = "+aTagLinkCount);
	}
	
	@Test
	public void totaLayoutlLink() {
		driver.findElement(By.linkText("How many links in this layout?")).click();
		
		//boolean ele = driver.findElement(By.tagName("a")).getAttribute("href");
		
		int htmlCount = driver.findElements(By.xpath("//*[contains(@href, 'html')]")).size();
		int aTagLinkCount = driver.findElements(By.xpath("//a[contains(@href, 'html')]")).size();
		System.out.println("total html links = "+htmlCount+", and which include <a> tag links are = "+aTagLinkCount);
	}
	//

	@AfterMethod
	public void afterMethod() {
		driver.close();
	}
}
