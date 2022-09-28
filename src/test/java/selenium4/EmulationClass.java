package selenium4;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v104.emulation.Emulation;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EmulationClass {
	ChromeDriver driver;
	
	@BeforeMethod
	public void beforeTest() {
		WebDriverManager.chromiumdriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().deleteAllCookies();
	}
	
	//@Test
	public void seleniumCommand() {	
		DevTools devtool = driver.getDevTools();
		devtool.createSession();
		
		devtool.send(Emulation.setDeviceMetricsOverride(360, 640, 50, true, Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty()));
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.findElement(By.id("username")).sendKeys("democsr");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.xpath("//div[@for='crmsfa']")).click();
		driver.findElement(By.linkText("Create Lead")).click();
	}
	
	@Test
	public void executeCDPcmd() {
		DevTools devtool = driver.getDevTools();
		devtool.createSession();
		
		Map<String, Object> map = new HashMap<>();
		map.put("width", 360);
		map.put("height", 640);
		map.put("deviceScaleFactor", 50);
		map.put("mobile", true);
		
		driver.executeCdpCommand("Emulation.setDeviceMetricsOverride", map);
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.findElement(By.id("username")).sendKeys("democsr");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.xpath("//div[@for='crmsfa']")).click();
		driver.findElement(By.linkText("Create Lead")).click();
	}
	
	@AfterMethod
	public void teradown() {
		driver.quit();
	}

}
