package SeleniumConcept;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.openqa.selenium.support.locators.RelativeLocator.*;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Version4 {
	public static WebDriver driver;
	
	@BeforeMethod
	public void beforeTest() {
		WebDriverManager.chromiumdriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().deleteAllCookies();
		driver.get("http://leaftaps.com/opentaps/control/main");
	}
	
	@Test
	public void relativeLocator() {
		WebElement ele = driver.findElement(By.xpath("//label[@for='username']"));
//		//driver.findElement(By.id("username")).sendKeys("democsr");
		String name = driver.findElement(with(By.id("username")).toRightOf(ele)).getText();
		System.out.println("Text = "+name);
//		driver.findElement(By.id("password")).sendKeys("crmsfa");
//		driver.findElement(By.className("decorativeSubmit")).click();
//		driver.findElement(By.xpath("//div[@for='crmsfa']")).click();
//		driver.findElement(By.linkText("Create Lead")).click();
		
		//driver.findElement(with(By.xpath(null)))
		
//		driver.get("https://rahulshettyacademy.com/angularpractice/");
//		WebElement nameEditBox =driver.findElement(By.cssSelector("[name='name']"));
//		System.out.println(driver.findElement(with(By.tagName("label")).above(nameEditBox)).getText());
//		WebElement dateofBirth = driver.findElement(By.cssSelector("[for='dateofBirth']"));
//		driver.findElement(with(By.tagName("input")).below(dateofBirth)).click();
//		WebElement iceCreamLabel =driver.findElement(By.xpath("//label[text()='Check me out if you Love IceCreams!']"));
//		driver.findElement(with(By.tagName("input")).toLeftOf(iceCreamLabel)).click();
//		WebElement rdb = driver.findElement(By.id("inlineRadio1"));
//		System.out.println(driver.findElement(with(By.tagName("label")).toRightOf(rdb)).getText());
	}
}