package DP_Observer;

import org.testng.annotations.Test;

public class Test_Validate {

	@Test
	public void validateNews() {
		String news = "New limit increased to 10000";

		NewsAgency bbc = new NewsAgency();
		NewsChannel sunTv = new NewsChannel();
		NewsChannel ndtv = new NewsChannel();

		bbc.addPropertyChangeListener(sunTv);
		bbc.addPropertyChangeListener(ndtv);
		bbc.setNews(news);

		System.out.println("sun = "+sunTv.getNews());
		System.out.println("ndtv = "+ndtv.getNews()); 

		bbc.removePropertyChangeListener(ndtv);
		bbc.setNews("increased by 1000");
		
		System.out.println("sun = "+sunTv.getNews());
		System.out.println("ndtv = "+ndtv.getNews());
	}
}
