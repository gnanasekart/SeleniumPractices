package SeleniumConcept;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TextField {

	public static RemoteWebDriver driver;
	
	@BeforeMethod
	public void beforeMethod() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.leafground.com/input.xhtml");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	
	@Test
	public void inputType() {
		driver.findElement(By.xpath("//input[@placeholder='Babu Manickam']")).sendKeys("Gnana sekar");
		
		WebElement city = driver.findElement(By.xpath("//input[contains(@class, 'ui-corner-all city ui-state-filled')]"));
		city.clear();
		city.sendKeys("Bangalore");
		
		Boolean status = driver.findElement(By.cssSelector(".ui-corner-all.ui-state-disabled")).isEnabled();
		Assert.assertFalse(status);
		
		String txt = driver.findElement(By.xpath("//input[contains(@value, 'My learning is superb so far.')]")).getAttribute("value");
		Assert.assertEquals(txt, "My learning is superb so far.");
		
		WebElement email = driver.findElement(By.xpath("//input[contains(@placeholder, 'Your email and tab')]"));
		email.sendKeys("gnana@gmail.com");
		email.sendKeys(Keys.TAB);

		driver.findElement(By.xpath("//*[contains(@class, 'ui-state-error')]")).sendKeys(Keys.TAB);
		String errortext = driver.findElement(By.xpath("//div[@class='grid formgrid']//following::span[@class=\"ui-message-error-detail\"]")).getText();
		Assert.assertEquals(errortext, "Age is mandatory");
		
		driver.findElement(By.xpath("(//h5[contains(text(), \"Click and Confirm Label Position Changes\")]//following::span/input)[1]")).click();
		driver.findElement(By.xpath("//input[contains(@class, 'ui-corner-all ui-state-hover ui-state-focus')]")).isSelected();
	
		driver.findElement(By.xpath("//span[contains(@class, 'p-datepicker ui-calendar')]//input")).sendKeys("11/10/1992");
		driver.findElement(By.xpath("//span[contains(@class, 'ui-icon-calendar')]")).click();
		
		String[] date = "11/10/1992".split("/");
		String month = date[0];
		String day = date[1];
		String year = date[2];
		
		String activeDay = driver.findElement(By.xpath("//a[contains(@class, 'ui-state-active')]")).getText();
		Assert.assertEquals(activeDay, day);
	
		WebElement spin = driver.findElement(By.xpath("//input[contains(@class, 'ui-spinner-input')]"));
		spin.sendKeys("1");
		driver.findElement(By.xpath("//a[contains(@class, 'ui-spinner-up')]")).click();
		String one = spin.getAttribute("aria-valuenow");
		Assert.assertEquals(one, "2");
		
		driver.findElement(By.xpath("(//h5[contains(text(), '(1-100)')]//following::input)[1]")).sendKeys("55");
		driver.findElement(By.xpath("//div[contains(@class,'ui-slider-range-min')]")).getAttribute("style");
		
		driver.findElement(By.xpath("//input[contains(@class, 'is-keypad')]")).click();
		driver.findElement(By.xpath("//div[contains(@class, 'ui-shadow keypad-popup')]")).isDisplayed();
	}
	
	
	@AfterMethod
	public void afterMethod() {
		//driver.close();
	}
}
