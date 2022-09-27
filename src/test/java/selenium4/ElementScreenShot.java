package selenium4;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ElementScreenShot {
	public static WebDriver driver;

	@BeforeMethod
	public void beforeTest() {
		WebDriverManager.chromiumdriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().deleteAllCookies();
		
	}

	//@Test
	public void elementSS() throws IOException {
		driver.get("http://leaftaps.com/opentaps/control/main");

		driver.findElement(By.id("username")).sendKeys("democsr");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		WebElement button = driver.findElement(By.className("crmsfa"));
		File file = button.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file, new File("new.png"));
		button.click();
		driver.findElement(By.linkText("Create Lead")).click();
	}
	
	@Test
	public void elementDimension() {
		driver.get("http://leaftaps.com/opentaps/control/main");

		driver.findElement(By.id("username")).sendKeys("democsr");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		WebElement button = driver.findElement(By.className("crmsfa"));
		System.out.println(button.getRect().getDimension().getHeight());
		System.out.println(button.getRect().getDimension().getWidth());
		button.click();
		driver.findElement(By.linkText("Create Lead")).click();
	}
}
