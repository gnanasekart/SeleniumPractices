package SeleniumConcept;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Windows {

	public static WebDriver driver;

	@BeforeMethod
	public void beforeMethod() {
		WebDriverManager.chromiumdriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().deleteAllCookies();
		driver.get("https://leafground.com/window.xhtml");
	}

	@Test
	public void example1() {
		driver.findElement(By.xpath("(//span[@class='ui-button-text ui-c'][contains(text(),'Open')])[1]")).click();
		String parent = driver.getWindowHandle();
		Set<String> set = driver.getWindowHandles();

		Iterator<String> it = set.iterator();

		String child ="";
		if(it.hasNext()) {
			child = it.next();
		}

		if(!parent.equals(child)) {
			driver.switchTo().window(child);
			System.out.println("example1 = "+driver.switchTo().window(child).getTitle());
			driver.close();
		}
	}

	@Test
	public void example2() {
		driver.findElement(By.xpath("(//span[@class='ui-button-text ui-c'][contains(text(),'Open Multiple')])")).click();
		String parent = driver.getWindowHandle();
		Set<String> set = driver.getWindowHandles();

		Iterator<String> it = set.iterator();

		String child ="";

		for(String window: set) {
			if(!parent.equals(window)) {
				driver.switchTo().window(window);
				System.out.println("example2 = "+driver.switchTo().window(window).getTitle());
				driver.close();
			}else {
				driver.switchTo().window(window);
				System.out.println("example2 = "+driver.switchTo().window(window).getTitle());
				driver.close();
			}
		}
	}

	@Test
	public void example3() {
		driver.findElement(By.xpath("(//span[@class='ui-button-text ui-c'][contains(text(),'Open with delay')])")).click();
		String parent = driver.getWindowHandle();
		Set<String> set = driver.getWindowHandles();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.numberOfWindowsToBe(3));
		set.forEach(window -> {
			if(!parent.equals(window)) {
				driver.switchTo().window(window);
				System.out.println("example3 = "+driver.switchTo().window(window).getTitle());
				driver.close();
			}else {
				driver.switchTo().window(window);
				System.out.println("example3 = "+driver.switchTo().window(window).getTitle());
				driver.close();
			}
		});
	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}
}