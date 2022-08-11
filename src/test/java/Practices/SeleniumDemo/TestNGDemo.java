//package Practices.SeleniumDemo;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebElement;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.Listeners;
//import org.testng.annotations.Test;
//@Listeners(customListener.class)
//public class TestNGDemo extends Screenshot
//{
//
//	@BeforeMethod
//	public void Setup()
//	{
//		launch();
//
//	}
//
//	@Test
//	public void visitFacebook()
//	{
//		driver.get("https://www.facebook.m/");
//		WebElement locator = driver.findElement(By.cssSelector("input[value='Log In']"));
//		exClickOn(driver, 20, locator);
//
//	}
//
//	@AfterMethod
//	public void tearDown()
//	{
//		driver.quit();
//	}
//}
