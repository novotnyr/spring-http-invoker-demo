package sihd.server;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.httpinvoker.HttpInvokerServiceExporter;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.handler.SimpleUrlHandlerMapping;

import sihd.api.FoodService;

@Configuration
@EnableWebMvc
public class ApplicationContextConfiguration {
	@Bean
	public HttpInvokerServiceExporter httpInvokerServiceExporter() {
		HttpInvokerServiceExporter exporter  = new HttpInvokerServiceExporter();
		exporter.setServiceInterface(FoodService.class);
		exporter.setService(foodService());
		
		return exporter;
	}

	@Bean
	public FoodService foodService() {
		return new MemoryFoodService();
	}
	
	@Bean
	public HandlerMapping handlerMapping() {
		SimpleUrlHandlerMapping urlHandlerMapping = new SimpleUrlHandlerMapping();
		Properties properties = new Properties();
		properties.put("/food.service", httpInvokerServiceExporter());
		urlHandlerMapping.setMappings(properties);
		
		return urlHandlerMapping;
	}
}
