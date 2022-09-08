package TL_Selenium_Practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Amazonfurniture extends TestBase {

	Amazonfurniture()
	{
		super();
	}

	@BeforeMethod
	public void setup()
	{
		Baseclass("chrome", "https://www.amazon.in/");
	}

	//@AfterMethod
	public void teardowns()
	{
		driver.close();
	}

	@Test
	public void furniture() {
		WebElement choose = driver.findElement(By.id("searchDropdownBox"));

		Select select = new Select(choose);
		select.selectByValue("search-alias=furniture");
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("chairs for computer table");
		driver.findElement(By.xpath("(//input[@type='submit'])[1]")).click();

		//gathering price values in Arraylist
		List<Integer> pricelist = new ArrayList<>();
		List<WebElement> price = driver.findElements(By.xpath("(//span[@class='a-price-symbol']/following-sibling::span)"));
		String prices;
		int intprice;

		//converting the string into integer datatype
		for(WebElement ele : price)
		{
			prices = ele.getText().trim().substring(0).replace(",", "");
			intprice = Integer.parseInt(prices);
			pricelist.add(intprice);
		}
		
		//Instead of using sort I used collection max method
		System.out.println("Size "+pricelist.size());
		System.out.println("Price "+pricelist);
		int maxprice = Collections.max(pricelist);
		for (int list: pricelist)
		{
			if(maxprice == list)
			{
				System.out.println("highest price : "+list);
			}
		}
		WebElement dropdown = driver.findElement(By.xpath("(//i[@class='a-icon a-icon-popover'])[1]"));
		dropdown.click();
		Actions action = new Actions(driver);
		WebElement second = driver.findElement(By.xpath("(//a[@class='a-link-normal 5star'])[1]"));
		action.moveToElement(second);
		action.build().perform();
		
		String star = second.getText();
		String percentage = driver.findElement(By.xpath("(//a[@title='5 stars represent 46% of rating'])[3]")).getText();
		String webdetails = driver.findElement(By.xpath("(//a[@title='5 stars represent 46% of rating'])[3]")).getAttribute("title");
		System.out.println("Webpage title shown as : "+webdetails);
		System.out.println("No of "+star+" valued custemer count is "+percentage);
		driver.close();
	}
}