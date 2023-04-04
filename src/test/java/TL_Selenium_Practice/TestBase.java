package TL_Selenium_Practice;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	/*
	 *  1. start-maximized: Opens Chrome in maximize mode
		2. incognito: Opens Chrome in incognito mode
		3. headless: Opens Chrome in headless mode
		4. disable-extensions: Disables existing extensions on Chrome browser
		5. disable-popup-blocking: Disables pop-ups displayed on Chrome browser
		6. make-default-browser: Makes Chrome default browser
		7. version: Prints chrome browser version
		8. disable-infobars: Prevents Chrome from displaying the notification 
		‘Chrome is being controlled by automated software
	 * 
	 */
	public static WebDriver driver;
	public TestBase()
	{
	}
	public static void Baseclass(String browser, String URL)
	{
		if(browser == "chrome")
		{
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--incognito", "start-maximized", "--log-level=3");
			options.addArguments("disable-infobars", "--disable-popup-blocking", "disable-extensions");
			options.addArguments("--headless", "--disable-gpu");
			DesiredCapabilities cap = new DesiredCapabilities();
			cap.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, false);
			cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, false);
			options.merge(cap);
			driver = new ChromeDriver(options);
		}
		else if(browser == "ff")
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else if(browser == "edge")
		{
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		else if(browser == "safari")
		{
			System.getProperty("webdriver.safari,driver", "");
			driver = new SafariDriver();
		}
//		else if(browser == "opera")
//		{
//			WebDriverManager.operadriver().setup();
//			driver = new OperaDriver();
//		}
		else if(browser == "ie")
		{
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		}
		//driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().deleteAllCookies();
		driver.get(URL);
	}
}
