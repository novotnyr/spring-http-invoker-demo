package sihd.api;

import java.io.Serializable;

public class Chocolate implements Food, Serializable {
	protected int percentage;
	
	protected String title;

	public Chocolate(int percentage, String title) {
		this.percentage = percentage;
		this.title = title;
	}

	public int getPercentage() {
		return percentage;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void eat() {
		System.out.println("Om nom nom, chocolate " + toString() + " eaten");
	}

	@Override
	public String toString() {
		return "Chocolate [percentage=" + percentage + ", title=" + title + "]";
	}
	
}
