package sihd.server;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.remoting.httpinvoker.SimpleHttpInvokerServiceExporter;
import org.springframework.remoting.support.SimpleHttpServerFactoryBean;

import sihd.api.FoodService;

import com.sun.net.httpserver.HttpHandler;

public class ServerRunner {
	public static void main(String[] args) throws IOException {
		SimpleHttpServerFactoryBean httpServer = new SimpleHttpServerFactoryBean();
		
		FoodService foodService = new MemoryFoodService();
		
		SimpleHttpInvokerServiceExporter serviceExporter = new SimpleHttpInvokerServiceExporter();
		serviceExporter.setServiceInterface(FoodService.class);
		serviceExporter.setService(foodService);

		serviceExporter.afterPropertiesSet();
		
		Map<String, HttpHandler> contexts = new HashMap<String, HttpHandler>(1);
		contexts.put("/food.service", serviceExporter);
		
		httpServer.setContexts(contexts);
		
		httpServer.afterPropertiesSet();		
		
	}
}
