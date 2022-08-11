//package Practices.SeleniumDemo;
//import java.io.IOException;
//import org.testng.Assert;
//import org.testng.ITestResult;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.AfterTest;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.BeforeTest;
//import org.testng.annotations.Test;
//
//import com.relevantcodes.extentreports.ExtentReports;
//import com.relevantcodes.extentreports.ExtentTest;
//import com.relevantcodes.extentreports.LogStatus;
//
//public class ExtentReportdemo extends Screenshot
//{
//	static ExtentTest test;
//	static ExtentReports report;
//
//	@BeforeMethod
//	public void startTest()
//	{
//		report = new ExtentReports(System.getProperty("user.dir")+"/test-output/ExtentReport.html", true);
//		report.addSystemInfo("user Name", "Demo report");
//	}
//
//	@BeforeTest
//	public void setup()
//	{
//		Screenshot.launch();
//	}
//
//	@Test
//	public void extendReportfail()
//	{
//		test = report.startTest("extentReport");
//		Assert.assertEquals(driver.getTitle(), "google", "wrong title");
////		if(driver.getTitle().equals("Gogole"))
////		{
////			test.log(LogStatus.PASS,"Navigate to google page");
////		}
////		else
////		{
////			test.log(LogStatus.FAIL, "Test failed");
////		}
//	}
//
//	@Test
//	public void extendReportpass()
//	{
//		test = report.startTest("extentReportpass");
//		String title = driver.getTitle();
//		System.out.println(title);
//		Assert.assertEquals(title, "Google", "wrong title");
//	}
//
//	@Test(enabled=false)
//	public void extendReportskip()
//	{
//		test = report.startTest("extentReportskip");
//		String title = driver.getTitle();
//		System.out.println(title);
//		Assert.assertEquals(title, "google", "wrong title");
//	}
//
//	@AfterMethod
//	public void tearDown(ITestResult result) throws IOException
//	{
//		if(result.getStatus()==ITestResult.FAILURE)
//		{
//			test.log(LogStatus.FAIL, "Failed test case is "+result.getName());//to add the test case method name
//			test.log(LogStatus.FAIL, "Failed test case is "+result.getThrowable());//to add error/exception details
//
//			String screenshotpath = Screenshot.getScreenshot(driver, result.getName());//screenshot name as method name
//			test.log(LogStatus.FAIL, test.addScreenCapture(screenshotpath));
//			//to add screenshot in extent report
//		}
//		else if(result.getStatus()==ITestResult.SKIP)
//		{
//			test.log(LogStatus.SKIP, "Test case is skipped" +result.getName());
//		}
//		else if(result.getStatus()==ITestResult.SUCCESS)
//		{
//			test.log(LogStatus.PASS, "Test case is Passed " +result.getName());
//		}
//	}
//
//	@AfterTest
//	public void endTest()
//	{
//		report.endTest(test);
//		report.flush();
//		driver.quit();
//	}
//}
