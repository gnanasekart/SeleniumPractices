package Practices.SeleniumDemo;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class sampleRUnselenium {

	@Test
	public void startUp() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\t.gnanasekar\\Downloads\\chromedriver_win32.exe");
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		//driver.get("https://www.google.com");
		//driver.wait(4000);
		//driver.close();
	}
	
	@Test
	public void runTestOnDocker() throws MalformedURLException {
		DesiredCapabilities dcap = new DesiredCapabilities();
		dcap.setBrowserName("chrome");
		dcap.setVersion("101");
		//dcap.set(new RemoteWebDriver(new URL("http://localhost:4444")), dcap);
		
        //String driverPath = System.getProperty("user.dir") + "/exe/chromedriver";
        //System.setProperty("webdriver.chrome.driver", driverPath);

        // Hub Port at 4444
        URL gamelan = new URL("http://localhost:4444/wd/hub");
        WebDriver driver = new RemoteWebDriver(gamelan, dcap);
        // Get URL
        driver.get("https://www.google.com/");
        // Print Title
        System.out.println(driver.getTitle());
	}
}