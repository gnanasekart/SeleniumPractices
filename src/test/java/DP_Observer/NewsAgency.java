package DP_Observer;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class NewsAgency {

	private String olderNews;

	
	private PropertyChangeSupport support;
	
	public NewsAgency() {
		support = new PropertyChangeSupport(this);
	}
	
	public void addPropertyChangeListener(PropertyChangeListener pcl) {
		support.addPropertyChangeListener(pcl);
	}

	public void removePropertyChangeListener(PropertyChangeListener pcl) {
		support.removePropertyChangeListener(pcl);
	}
	
	public void setNews(String news) {
		support.firePropertyChange("news", olderNews, news);
	} 
	
}
