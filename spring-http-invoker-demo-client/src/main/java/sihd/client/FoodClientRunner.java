package sihd.client;

import java.util.List;

import org.springframework.remoting.httpinvoker.HttpInvokerProxyFactoryBean;

import sihd.api.Food;
import sihd.api.FoodService;

public class FoodClientRunner {
	public static void main(String[] args) {
		HttpInvokerProxyFactoryBean httpInvokerProxyFactoryBean = new HttpInvokerProxyFactoryBean();
		httpInvokerProxyFactoryBean.setServiceUrl("http://localhost:8080/food.service");
		httpInvokerProxyFactoryBean.setServiceInterface(FoodService.class);
		httpInvokerProxyFactoryBean.afterPropertiesSet();
		
		FoodService foodService = (FoodService) httpInvokerProxyFactoryBean.getObject();
		List<Food> foodList = foodService.list();
		for (Food food : foodList) {
			System.out.println(food);
		}
	}
}
