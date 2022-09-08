package TL_Selenium_Practice;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Espn extends TestBase{

	Espn()
	{
		super();
	}
	@BeforeMethod
	public void setup()
	{
		Baseclass("chrome", "https://www.espncricinfo.com/");
	}
	@AfterMethod
	public void teardowns()
	{
		driver.close();
	}
	@Test
	public void manOfTheMatch() throws IOException, InterruptedException
	{
		WebElement ipl2020 = driver.findElement(By.xpath("(//span[text()='IPL 2020'])[1]"));
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		js.executeScript("arguments[0].click();", ipl2020);
		driver.findElement(By.xpath("//a[text()='View All Results']")).click();
		List<Integer> arrayList = new ArrayList();
		List<WebElement> array =
				driver.findElements(By.xpath("//span[@class='extra-score']/following-sibling::span"));
		for(int i=0; i<array.size(); i++)
		{
			String run = array.get(i).getText().trim().replaceAll("[^0-9]\\d", "");
			int intrun = Integer.parseInt(run);
			arrayList.add(intrun);
		}
		Integer max = Collections.max(arrayList);
		System.out.println("highest scrore: "+max);
		int matches = driver.findElements(By.xpath("//div[@class='row no-gutters']/div")).size();
		driver.findElement(By.xpath("//div[@class='row no-gutters']/div["+matches+"]//a[text()='Summary']")).click();
		String playername = driver.findElement(By.xpath("//div[@class='best-player-name']/a")).getAttribute("data-hover");
		System.out.println("best player of the match is goes to : " +playername);
	}
}