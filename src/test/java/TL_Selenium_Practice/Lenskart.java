package TL_Selenium_Practice;

import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class Lenskart extends TestBase{

	public Lenskart() {
		super();
	}

	@BeforeMethod
	public void startup()
	{
		Baseclass("chrome", "https://www.lenskart.com/");
	}

	@AfterMethod
	public void teardown()
	{
		//d.close();
	}

	@Test
	public void lens() throws InterruptedException {
		driver.findElement(By.xpath("//button[@class='No thanks']")).click();
		WebElement main = driver.findElement(By.xpath("//a[text()='Computer Glasses']"));
		
		Actions action = new Actions(driver);
		action.moveToElement(main).build().perform();
		
		WebElement men = driver.findElement(By.xpath("(//div[@class='gender_info']//following::span[text()='men'])[1]"));
		action.moveToElement(men).build().perform();
		
		WebElement range = driver.findElement(By.xpath("(//span[text()='PREMIUM RANGE'])[1]"));
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		js.executeScript("arguments[0].click();", range);
		
		WebElement round = driver.findElement(By.xpath("(//span[text()='Round'])"));
		action.doubleClick(round).build().perform();
		
		List<WebElement> color = driver.findElements(By.xpath("//div[contains(text(),'FRAME COLOR')]//following::ul//li[@class='list-checkbox']//span"));
		Thread.sleep(2000);
		List<Integer> count = new ArrayList<>();
		
		String number ="";
		for(int i = 0; i<color.size(); i++)
		{
			number = color.get(i).getText().toString().replaceAll("[^0-9]", "");
			int parseInt = Integer.parseInt(number);
			count.add(parseInt);
		}
		int top = count.get(0);
		System.out.println("max count = "+top);
		for(int j=1; j<=color.size(); j++)
		{
			String text = driver.findElement(By.xpath("(//div[contains(text(),'FRAME COLOR')]//following::ul//li[@class='list-checkbox']//span)["+j+"]")).getText();
			String t = text.replaceAll("[^0-9]", "");
			int tt = Integer.parseInt(t);
			System.out.println("value = " +tt);
			if(top == tt)
			{
				WebElement tick = driver.findElement(By.xpath("(//div[contains(text(),'FRAME COLOR')]//following::ul//li[@class='list-checkbox']//input)["+j+"]"));
				action.click(tick).build().perform();
			}
			break;
		}
		String result = driver.findElement(By.xpath("//div[@class='show_count']")).getText().replaceAll("[^0-9]", "").substring(1);
		System.out.println(result);
		int resulttop = Integer.parseInt(result);
		if(resulttop == top)
		{
			System.out.println("correct count");
		}else
		{
			System.out.println("wrong count");
		}
	}
}