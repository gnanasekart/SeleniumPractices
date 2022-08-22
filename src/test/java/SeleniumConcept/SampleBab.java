package SeleniumConcept;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.decorators.Decorated;
import org.openqa.selenium.support.decorators.WebDriverDecorator;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SampleBab extends WebDriverDecorator {

	//EventFiringWebDriver
	int i=0;
	WebDriver driver;
	@Test
	public void highLight() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		//convert driver into decorator driver
		WebDriver decoratorDriver = new SampleBab().decorate(driver);

		decoratorDriver.get("http://leaftaps.com/opentaps");
		WebElement ele = decoratorDriver.findElement(By.id("username"));
		ele.sendKeys("Democsr");
	}

	@Override
	public void beforeCall(Decorated<?> target, Method method, Object[] args) {
		System.out.println("Before calling actions "+method.getName());
	}

	@Override
	public void afterCall(Decorated<?> target, Method method, Object[] args, Object res) {
		System.out.println("After calling actions "+method.getName());

		if(method.getName().equals("findElement")) {
			System.out.println("Highlight the element is "+((WebElement)res).getTagName());

			//Here how to do Highlight for the tag ?
			//1. Need to use JavaScriptExecutor
			//2. For that we need WebDriver instance.
			//How to get the webdriver instance inside this decorator override method

			//Here we got the webdriver instance from geDecorator
			WebDriver driver = target.getDecorator().getDecoratedDriver().getOriginal();

			//Now jumping into another interface(JavaScriptExecutor) from WebDriver(Interface)
			((JavascriptExecutor)driver).executeScript("arguments[0].setAttribute('style', "+"'background: yellow')", ((WebElement)res));
			
			File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			try {
				FileUtils.copyFile(file, new File("./snaps/snap"+i+".jpg"));
			} catch (IOException e) {
				e.printStackTrace();
			}
			i++;
		}
	}
}