package Practices.SeleniumDemo;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class googleSearch {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(20));
		driver.manage().window().maximize();

		driver.get("https://www.google.com/");
		driver.findElement(By.cssSelector("[name='q']")).sendKeys("testing");
		WebElement ele = driver.findElement(By.xpath("//ul[@role=\"listbox\"]//li/following::div[@class='wM6W7d']//b[contains(text(),'courses')]"));
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", ele);
//		
//		
//		List<WebElement> search= driver.findElements(By.xpath("//ul[@role='listbox']//li/following::div[@class='wM6W7d']//b"));
//		for(WebElement x  : search) {
//			System.out.println("gnana Text = " +x.getText());
//			if(x.getText().trim().equals("courses")) {
//				
//				js.executeScript("arguments[0].click();", x);
//			}
//		}
		driver.quit();
	}

}
