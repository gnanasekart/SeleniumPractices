package TestNG;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProvidersClassTestNG {

	@DataProvider(name="loginDetails")
	public static Object[][] getData(){
		return new Object[][] {
			{"Gnana", "123"},
			{"sekar", "234"}
		};
	}
}

 class LoginClass{
	 @Test(dataProvider="loginDetails", dataProviderClass=DataProvidersClassTestNG.class)	
	public void LoginScreen(String name, String id) {
		System.out.println(name+" "+id);
	}
}
