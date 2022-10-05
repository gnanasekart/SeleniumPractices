package grid;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RemoteConnectionFirefox {

	@Test
	public void mainFirefox() throws MalformedURLException {
		
		FirefoxOptions options = new FirefoxOptions();
			options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			options.setCapability(CapabilityType.BROWSER_NAME, "firefox");
			options.setCapability(CapabilityType.PLATFORM_NAME, "Windows10");
		WebDriver driver = new RemoteWebDriver(new URL("http://192.168.1.100:5555"), options);
		//WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), options);
		driver.get("https://google.com");
	}
}
