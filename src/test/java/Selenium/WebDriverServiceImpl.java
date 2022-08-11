package Selenium;

import Listener.ExtendReportListener;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WebDriverServiceImpl extends ExtendReportListener implements WebDriverService {


    public WebElement locateElement(String locator, String locatorValue) {
        try {
            switch (locator) {
                case "id":
                    return driver.findElement(By.id(locatorValue));
                case "className":
                    return driver.findElement(By.className(locatorValue));
                case "cssSelector":
                    return driver.findElement(By.cssSelector(locatorValue));
                case "xpath":
                    return driver.findElement(By.xpath(locatorValue));
                case "tag":
                    return driver.findElement(By.tagName(locatorValue));
                case "name":
                    return driver.findElement(By.name(locatorValue));
                case "link":
                    return driver.findElement(By.linkText(locatorValue));
                default: break;
            }
        } catch (NoSuchElementException e) {
            System.err.println("the element with locator " + locator + " not found");
        } catch (WebDriverException e) {
            System.err.println("unknown exception occured while finding " + locator + " with the value" + locatorValue);
        }
        return  null;
    }

    public WebElement type(String locator, String locatorValue) {
        try {
            switch (locator) {
                case "id":
                    return driver.findElement(By.id(locatorValue));
                case "className":
                    return driver.findElement(By.className(locatorValue));
                case "cssSelector":
                    return driver.findElement(By.cssSelector(locatorValue));
                case "xpath":
                    return driver.findElement(By.xpath(locatorValue));
                case "tag":
                    return driver.findElement(By.tagName(locatorValue));
                case "name":
                    return driver.findElement(By.name(locatorValue));
                case "link":
                    return driver.findElement(By.linkText(locatorValue));
                default: break;
            }
        } catch (NoSuchElementException e) {
            System.err.println("the element with locator " + locator + " not found");
        } catch (WebDriverException e) {
            System.err.println("unknown exception occured while finding " + locator + " with the value" + locatorValue);
        }
        return  null;
    }

    public WebElement locateId(String locator){
        return driver.findElement(By.id(locator));
    }

    public WebElement locateCssSelector(String locator){
        return driver.findElement(By.cssSelector(locator));
    }

    public WebElement locateXpath(String locator){
        return driver.findElement(By.xpath(locator));
    }

    public WebElement type(WebElement ele, String content){
        try{
            waitForClickability(ele);
            ele.clear();
            ele.sendKeys(content);
        }catch (InvalidElementStateException e) {
            System.err.println("the data "+content+" could not entered into the field");
        } catch (WebDriverException e) {
            System.err.println("unknown exception occured while entering " + content + " in the locator" + ele);
        }
        return null;
    }

    public void waitForClickability(WebElement ele){
        new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions.elementToBeClickable(ele));
    }
}
