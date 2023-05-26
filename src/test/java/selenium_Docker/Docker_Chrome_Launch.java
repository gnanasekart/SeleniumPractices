package selenium_Docker;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Docker_Chrome_Launch {

	public static void main(String[] args) {

		DesiredCapabilities cap = new DesiredCapabilities();
		ChromeOptions option = new ChromeOptions();

		//option.setBrowserVersion("110");
		option.merge(cap);

		System.out.println("Browser version "+option.getBrowserVersion());

		try {
			//WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), cap);
			WebDriverManager.chromedriver().setup();
			WebDriver driver = new ChromeDriver();
			driver.get("https://www.google.com");

			System.out.println("browser title: ="+driver.getTitle());
			driver.quit();

		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
