package TL_Selenium_Practice;

import java.awt.image.BufferedImage;
import java.awt.image.DataBuffer;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import javax.imageio.ImageIO;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JewelleryRoom extends TestBase {

	JewelleryRoom()
	{
		super();
	}

	@BeforeMethod
	public void setup()
	{
		Baseclass("chrome", "https://thejewelleryroom.com/");
	}

	//@AfterMethod
	public void teardowns()
	{
		driver.close();
	}
	
	@Test
	public void room() throws IOException {
		driver.findElement(By.className("recommendation-modal__close-button")).click();
		driver.findElement(By.xpath("(//a[contains(text(),'Bracelets')])[1]")).click();
//		Actions act = new Actions(driver);
//		act.moveToElement(link).build().perform();

		driver.findElement(By.xpath("(//a[contains(text(),'Bangles')])[1]")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		JavascriptExecutor js = ((JavascriptExecutor) driver);

		WebElement dd = driver.findElement(By.xpath("(//span[contains(text(),'Sorby')]//span)[1]"));
		js.executeScript("arguments[0].click();", dd);
		WebElement dd1 = driver.findElement(By.xpath("//div[@class='dropdown-content']//following-sibling::a[c	ontains(text(),'Price (high-low)')]"));
		js.executeScript("arguments[0].click();", dd1);
		List<WebElement> names = driver.findElements(By.xpath("//div[@class='product-information has-text-centered']//div[@class='product-name']"));
		List<WebElement> prices = driver.findElements(By.xpath("//span[@class='currency-dkk']"));
		Map<String, Integer> map = new LinkedHashMap<>();
		for(int i=0; i<names.size(); i++)
		{
			String name = names.get(i).getText().toString().trim();
			String price = prices.get(i).getText().toString().replaceAll("[^0-9]", "");
			int intprice = Integer.parseInt(price);
			map.put(name, intprice);
		}
		
		Set<Entry<String, Integer>> entry = map.entrySet();
		for(Entry<String, Integer> es: entry)
		{
			System.out.println(es.getKey()+" = "+es.getValue());
		}
		
		driver.findElement(By.xpath("(//div[@class='product-information has-text-centered']//div[@class='product-name'])[1]")).click();
		
		//------------------------------------------------------------------------
		File screenshotAs = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		// Convert the screenshot into BufferedImage
		BufferedImage fullScreen = ImageIO.read(screenshotAs);
		WebElement image = driver.findElement(By.xpath("(//div[@class='glide__slide glide__slide--active']//a/div)"));
		
		int x = image.getLocation().getX();
		int y = image.getLocation().getY();
		int width = image.getSize().getWidth();
		int height = image.getSize().getHeight();
		//cropping the full image to get only the logo screenshot
		BufferedImage logoImage = fullScreen.getSubimage(x, y, width, height);
		ImageIO.write(logoImage, "png", screenshotAs);
		//Save cropped Image at destination location physically.
		File f1 = new File("./TestleafCodePractices/start.PNG");
		FileUtils.copyFile(screenshotAs, f1);
		
		//------------------------------------------------------------------------
		String beforename = driver.findElement(By.xpath("//h1[@class='title']//a")).getText().trim();
		String beforeprice = driver.findElement(By.xpath("(//div[@class='product-price']//span[@class='currency-dk k'])[1]")).getText().replaceAll("[^0-9]", "").trim();
		driver.findElement(By.xpath("//div[@class='language-switcher flags-only']//a[2]")).click();
		String enabled = driver.findElement(By.xpath("//div[@class='language-switcher flags-only']//a[2]")).getAttribute("aria-selected").trim();
		if(enabled.equals("true")==true)
		{
			System.out.println("Confirm page in Dutch language");
		}else
		{
			System.out.println("Still in English language");
		}

		//------------------------------------------------------------------------
		File screenshotAs1 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		// Convert the screenshot into BufferedImage
		BufferedImage fullScreen1 = ImageIO.read(screenshotAs);
		WebElement image1 = driver.findElement(By.xpath("(//div[@class='glide__slide	glide__slide--active']//a/div)"));
		int x1 = image.getLocation().getX();
		int y1 = image.getLocation().getY();
		int width1 = image.getSize().getWidth();
		int height1 = image.getSize().getHeight();
		//cropping the full image to get only the logo screenshot
		BufferedImage logoImage1 = fullScreen.getSubimage(x1, y1, width1, height1);
		ImageIO.write(logoImage1, "png", screenshotAs1);
		File f2 = new File("./TestleafCodePractices/end.PNG");
		FileUtils.copyFile(screenshotAs, f2);
		
		//------------------------------------------------------------------------
		BufferedImage bufferfileInput = ImageIO.read(f1);
		DataBuffer bufferfileInput1 = (bufferfileInput).getData().getDataBuffer();
		int sizefileInput = bufferfileInput1.getSize();
		BufferedImage bufferfileOutPut = ImageIO.read(f2);
		DataBuffer datafileOutPut = bufferfileOutPut.getData().getDataBuffer();
		int sizefileOutPut = datafileOutPut.getSize();
		Boolean matchFlag = true;
		if(sizefileInput == sizefileOutPut) {
			for(int i=0; i<sizefileInput; i++) {
				if(bufferfileInput1.getElem(i) != datafileOutPut.getElem(i)) {
					matchFlag = false;
					break;
				}
			}
		}else {
			matchFlag = false;
			Assert.assertTrue(matchFlag, "Images are not same");
		}

		//------------------------------------------------------------------------
		String aftername = driver.findElement(By.xpath("//h1[@class='title']//a")).getText().trim();
		String afterprice = driver.findElement(By.xpath("(//div[@class='product-price']//span[@class='currency-dkk'])[1]"))
				.getText().replaceAll("[^0-9]", "").trim();
		if(beforename.equals(aftername) && beforeprice.equals(afterprice))
		{
			System.out.println("product and price are same after language changes");
		}
	}
}