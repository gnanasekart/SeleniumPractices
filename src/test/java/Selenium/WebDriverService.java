package Selenium;

import org.openqa.selenium.WebElement;

public interface WebDriverService {

    public WebElement locateElement(String locator, String locatorValue);

    public WebElement locateId(String locator);
    public WebElement locateCssSelector(String locator);
    public WebElement locateXpath(String locator);

    public WebElement type(String ele, String locator);

    //public void click(WebElement ele);



}
