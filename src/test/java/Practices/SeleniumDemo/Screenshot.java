package Practices.SeleniumDemo;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.StaleElementReferenceException;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Screenshot
{
	public static WebDriver driver;

	public static void main(String[] args) throws IOException
	{


		driver.get("https://www.facebook.com/");

		takeScreenshot("facebook");
		WebElement locator = driver.findElement(By.cssSelector("input[value='Log In']"));

		//WebDriverWait wait = new WebDriverWait(driver, 30);
		//wait.until(ExpectedConditions.elementToBeClickable(locator));
		exClickOn(driver, 20, locator);
		//navigate();
		driver.close();
	}

	public static void launch()
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.google.co.in");
	}

	public static void exClickOn(WebDriver driver, Duration duration, WebElement locator)
	{
		new WebDriverWait(driver, timeout).ignoring(StaleElementReferenceException.class)
		.until(ExpectedConditions.elementToBeClickable(locator));
		locator.click();
	}

	public static void takeScreenshot(String fileName) throws IOException
	{
		File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file, new File("./Screenshot/"+fileName+".jpg"));

	}


	public static String getScreenshot(WebDriver driver, String ssname) throws IOException
	{
		String datename = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String destpath = System.getProperty("user.dir") + "/FailedTestScreenShot/" + ssname + datename + ".png";
		File finalpath = new File(destpath);
		FileUtils.copyFile(file, finalpath);
		return destpath;
	}

	public static void navigate()
	{
		driver.navigate().refresh();
		//Load a new web page in the current browser window
		driver.navigate().to("https://www.google.com");
		driver.navigate().back();
		driver.navigate().forward();
		driver.navigate().back();
	}

}
