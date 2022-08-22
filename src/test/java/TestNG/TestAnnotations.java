package TestNG;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class TestAnnotations {



	@BeforeSuite
	public void beforeSuite() {
		System.out.println("before suite1");
	}

	@BeforeTest
	public void beforeTest() {
		System.out.println("before test1");
	}

	@BeforeClass
	public void beforeClass() {
		System.out.println("before class1");
	}

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("before method1");
	}

	@Test
	public void f1() {
		System.out.println("test1");
	}

	@Test
	public void f2() {
		System.out.println("test2");
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("after method1");
	}

	@AfterClass
	public void afterClass() {
		System.out.println("after class1");
	}

	@AfterTest
	public void afterTest() {
		System.out.println("after test1");
	} 

	@AfterSuite
	public void afterSuite() {
		System.out.println("after suite1");
	}

}
