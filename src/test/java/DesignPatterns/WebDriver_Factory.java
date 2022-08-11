package DesignPatterns;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import ru.stqa.selenium.factory.ThreadLocalSingleWebDriverPool;
import ru.stqa.selenium.factory.WebDriverPool;

public class WebDriver_Factory {

	@Test
	public void LaunchBrowser( ) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = WebDriverPool.DEFAULT.getDriver(new ChromeOptions());
		driver.get("https://google.com");
		System.out.println(((RemoteWebDriver) driver).getSessionId());
		
		WebDriverManager.firefoxdriver().setup();
		 driver = WebDriverPool.DEFAULT.getDriver(new FirefoxOptions());
		driver.get("https://google.in");
		System.out.println(((RemoteWebDriver) driver).getSessionId());
		WebDriverPool.DEFAULT.dismissDriver(driver);
		
	}
	
	//@Test
	public void LaunchBrowser1( ) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = ThreadLocalSingleWebDriverPool.DEFAULT.getDriver(new ChromeOptions());
		driver.get("https://google.com");
		System.out.println(((RemoteWebDriver) driver).getSessionId());
		
		WebDriverManager.firefoxdriver().setup();
		 driver = ThreadLocalSingleWebDriverPool.DEFAULT.getDriver(new FirefoxOptions());
		driver.get("https://google.in");
		System.out.println(((RemoteWebDriver) driver).getSessionId());
		
		ThreadLocalSingleWebDriverPool.DEFAULT.dismissDriver(driver);
		
	}
}
