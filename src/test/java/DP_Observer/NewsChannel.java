package DP_Observer;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class NewsChannel implements PropertyChangeListener {

	private String news;
	
	@Override
	public void propertyChange(PropertyChangeEvent evt) {
	news = (String) evt.getNewValue();	
		
	}
	
	public String getNews() {
		return news;
	}

}
