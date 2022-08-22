package DP_Bridge;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class testBridge {
	WebDriver driver;
	@Test
	public void testColorShape() {
		
		Select select = new Select((WebElement) driver);
		Shape sq = new Square(new Blue());
		System.out.println(sq.fill());
	 }
}
