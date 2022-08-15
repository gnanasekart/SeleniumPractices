package TestNG;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;

public class NewTest {

	RemoteWebDriver driver;
	
	@BeforeMethod()
	public void beforeMethod() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.google.co.in");
		System.out.println("Before method = "+Thread.currentThread().getId());
	}

	@Test(groups={"demo"})
	@Parameters({"First1"})
	public void first(String First1) {
		System.out.println("First method = "+Thread.currentThread().getId());
		System.out.println("First method = "+First1);
//		System.out.println("First method = "+Thread.currentThread().hashCode());
	}

	@Test(groups={"demo1", "demo"})
	public void Second() {
		System.out.println("Second method = "+Thread.currentThread().getId());
//		System.out.println("Second method = "+Thread.currentThread().getName());
//		System.out.println("Second method = "+Thread.currentThread().hashCode());
	}

	//@Test(threadPoolSize = 2, invocationCount = 4, timeOut = 2000)
	public void Third() {
		System.out.println("Third method = "+Thread.currentThread().getId());
//		System.out.println("Third method = "+Thread.currentThread().getName());
//		System.out.println("Third method = "+Thread.currentThread().hashCode());
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("After method = "+Thread.currentThread().getId());
		driver.quit();
	}
}