package Practices.SeleniumDemo;

import java.util.ArrayList;
import java.util.List;

public class foreachlambda {

	public static void main(String[] args) {
//		List<String> name = new ArrayList<>();
//		name.add("delhi");
//		name.add("pune");
//		name.add("mumbai");
//		name.add("chennai");
//		name.add("goa");
//		
//		name.forEach(
//				(names) -> System.out.println(names)
//				);
//			}
	
	
		stateName sa = (state) ->{
	String state1 = "KA";
	String state2 = "UP";
	String track = state+ " this long distance between "+state1 + " and "+state2;
	return track;
	};
System.out.println(sa.names("hi"));
	}
	
}


interface stateName
{
	String names(String state);
}