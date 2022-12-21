package Practices.SeleniumDemo;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class sample {

	
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		
		driver.get("https://www.leafground.com/");
		driver.findElement(By.id("layout-config-button")).click();
		driver.findElement(By.xpath("//label[contains(text(), 'Light')]")).click();
		WebElement chart = driver.findElement(By.xpath("//span[@class=\"ui-panel-title\" and contains(text(), \"Chart\")]"));
		chart.click();
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();", chart);
		WebElement ele = driver.findElement(By.xpath("//canvas[@id='chart']"));
		
		
		int heightAxis = ele.getSize().getHeight();
		double widthaxis = (ele.getSize().getWidth())/6;
		double w = widthaxis*5;
		Actions ac = new Actions(driver);
		ac.moveToElement(ele, (int) w, heightAxis).contextClick().clickAndHold().build().perform();
	}

}
