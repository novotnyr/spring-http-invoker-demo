package sihd.server;

import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CopyOnWriteArrayList;

import sihd.api.Chocolate;
import sihd.api.Food;
import sihd.api.FoodService;

public class MemoryFoodService implements FoodService {
	private List<Food> foodList = new CopyOnWriteArrayList<Food>();

	public MemoryFoodService() {
		add(new Chocolate(75, "Lindt"));
		add(new Chocolate(12, "Poor man's nonchocolate"));
	}
	
	public List<Food> list() {
		return foodList;
	}

	public void add(Food food) {
		foodList.add(food);
	}

}
