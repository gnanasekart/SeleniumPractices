package SeleniumConcept;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class dropdown {
    WebDriver driver;
    @BeforeMethod
    public void startUp() {

        WebDriverManager.chromiumdriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(20));
        driver.manage().deleteAllCookies();
        driver.get("http://leafground.com/select.xhtml");
    }

    @Test(priority = 0)
    public void selectTool() throws IOException {
        WebElement forSelect = driver.findElement(By.xpath("//div/h5[contains(text(),' UI Automation tool')]//parent::div//following-sibling::select"));
        new Select(forSelect).selectByVisibleText("Selenium");
        WebElement box = driver.findElement(By.xpath("//h5[contains(text(), 'UI Automation tool')]/parent::div"));

        //captureScreenshot(box);
    }

    @Test(priority = 1, dependsOnMethods = "selectTool")
    public void clickByTag() throws IOException {
        //Dropdown is not configured as select. Hence, two clicks are expected
        driver.findElement(By.xpath("//label[text()='Select Country']")).click();
        driver.findElement(By.xpath("//li[text()='India']")).click();
        WebElement box = driver.findElement(By.xpath("//h5[contains(text(), 'Choose your preferred country')]/parent::div"));
        //captureScreenshot(box);
    }

    @Test(priority = 2, dependsOnMethods = "clickByTag", expectedExceptions = IndexOutOfBoundsException.class)
    public void clickCity() throws IOException {
        //Identifying Select City dropdown and clicking. Selecting relevant city
        driver.findElement(By.xpath("//label[text()='Select City']")).click();

        List<WebElement> lst = driver.findElements(By.xpath("//ul[contains(@id,'city_items')]//li"));
        WebElement box = driver.findElement(By.xpath("//h5[contains(text(), 'Confirm Cities belongs to Country is loaded')]/parent::div"));
        lst.get(1).click();
        //captureScreenshot(box);
    }

    @Test(priority = -1)
    public void chooseCourse() throws IOException {
        driver.findElement(By.xpath("//button[@aria-label='Show Options']")).click();
        driver.findElement(By.xpath("//li[@data-item-label='Appium']")).click();
        WebElement box = driver.findElement(By.xpath("//h5[contains(text(),'Choose the Course')]//parent::div"));
        //captureScreenshot(box);
    }

    public static void captureScreenshot(WebElement ele) throws IOException {
        File screenshotFile = ele.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshotFile, new File(System.getProperty("user.dir") + "/target/screenShot/" + System.currentTimeMillis() + ".jpeg"));
    }

    @AfterMethod
    public void teamDown() {
        driver.quit();
    }

}

