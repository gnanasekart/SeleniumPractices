package TestNG;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TestNgParams {

    @Test(singleThreaded = true)
    public void addToCartTest(){
        System.out.println("addToCartTest");
        int i=9/0;
    }

    @Test(enabled=false, alwaysRun = true, dependsOnMethods="addToCartTest")
    public void paymentTest(){
        System.out.println("paymentTest");
    }

    /*
1. @Test(enabled=true, alwaysRun=true, dependsOnMethods="addToCartTest")

TC 1 fails
TC2 pass

2. @Test(enabled=true, dependsOnMethods="addToCartTest")

TC 1 fails - ArithmeticException
TC2 Skipped/ignored

3. @Test(enabled=false, dependsOnMethods="addToCartTest")
@Test(enabled=false, alwaysRun = true, dependsOnMethods="addToCartTest")

TC 1 fails - ArithmeticException
Execution does not consider tc2

     */

    public static void main(String[] args) {


        Runtime rt = Runtime.getRuntime();
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        JavascriptExecutor d = (JavascriptExecutor) driver;


    }


}
