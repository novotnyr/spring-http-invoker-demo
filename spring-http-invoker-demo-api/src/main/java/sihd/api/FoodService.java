package sihd.api;

import java.util.List;

public interface FoodService {
	public List<Food> list();
	
	public void add(Food food);
}
