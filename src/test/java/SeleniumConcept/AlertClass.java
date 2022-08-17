package SeleniumConcept;

import java.time.Duration;

import Selenium.WebDriverServiceImpl;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AlertClass extends WebDriverServiceImpl {

	public static WebDriver driver;
	public static Actions action;

	@BeforeMethod
	public void startUp() {
		WebDriverManager.chromiumdriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().deleteAllCookies();
		driver.get("https://leafground.com/alert.xhtml");
		//driver.get("http://www.leafground.com/dashboard.xhtml");
		//WebElement global = driver.findElement(By.cssSelector(".pi.pi-globe.layout-menuitem-icon"));
		//WebElement alerttxt = driver.findElement(By.xpath("//span[text()='Alert']"));
		//action.moveToElement(global).click().moveToElement(alerttxt).click().build().perform();
	}

	@Test
	public void ActionsClass() {
		action = new Actions(driver);
		//Accept Alert box
		//actionSimpleDialogAccept();

		//Send prompt msg
		//actionPromptDialogOk();
		//actionPromptDialogCancel();

		actionConfirmDialogOk();
	}

	private void actionSimpleDialogAccept() {
		//click("(//h5[text()=' Alert (Simple Dialog)']//following::span[text()='Show'][1])");
		//driver.findElement(By.xpath("(//h5[text()=' Alert (Simple Dialog)']//following::span[text()='Show'][1])")).click();
		driver.switchTo().alert().accept();
		String txt = driver.findElement(By.id("simple_result")).getText();
		Assert.assertEquals(txt, "You have successfully clicked an alert");
	}

	private void actionPromptDialogOk() {
		driver.findElement(By.xpath("(//h5[text()=' Alert (Prompt Dialog)']//following::span[text()='Show'][1])")).click();
		driver.switchTo().alert().sendKeys("Hi Sekar");
		driver.switchTo().alert().accept();

		String txt = driver.findElement(By.id("confirm_result")).getText();
		Assert.assertEquals(txt, "User entered name as: Hi Sekar");
	}

	private void actionPromptDialogCancel() {
		driver.findElement(By.xpath("(//h5[text()=' Alert (Prompt Dialog)']//following::span[text()='Show'][1])")).click();
		driver.switchTo().alert().sendKeys("Hi Sekar");
		driver.switchTo().alert().dismiss();
		String txt = driver.findElement(By.id("confirm_result")).getText();
		Assert.assertEquals(txt, "User cancelled the prompt.");
	}

	private void actionConfirmDialogOk() {
		driver.findElement(By.xpath("(//h5[text()=' Alert (Confirm Dialog)']//following::span[text()='Show'][1])")).click();
		driver.switchTo().alert().accept();
		String txt = driver.findElement(By.id("result")).getText();
		Assert.assertEquals(txt, "User Clicked : OK");
	}

	private void actionSweetAlertDelete() {
		driver.findElement(By.xpath("(//span[text()='Delete'])")).click();
		driver.switchTo().alert().accept();
		String txt = driver.findElement(By.id("result")).getText();
		Assert.assertEquals(txt, "User Clicked : OK");
	}

	@AfterMethod
	public void tearDown() {
		driver.close();
	}
}