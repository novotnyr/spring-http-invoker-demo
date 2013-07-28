package sihd.server;

import java.io.IOException;
import java.net.InetSocketAddress;

import org.springframework.remoting.httpinvoker.SimpleHttpInvokerServiceExporter;

import sihd.api.FoodService;

import com.sun.net.httpserver.HttpServer;

public class JDkServerRunner {
	public static void main(String[] args) throws IOException {
		HttpServer httpServer = HttpServer.create(new InetSocketAddress(8080), 0);
		
		FoodService foodService = new MemoryFoodService();
		
		SimpleHttpInvokerServiceExporter serviceExporter = new SimpleHttpInvokerServiceExporter();
		serviceExporter.setServiceInterface(FoodService.class);
		serviceExporter.setService(foodService);

		serviceExporter.afterPropertiesSet();
		
		httpServer.createContext("/food.service", serviceExporter);
		httpServer.start();
	}
}
