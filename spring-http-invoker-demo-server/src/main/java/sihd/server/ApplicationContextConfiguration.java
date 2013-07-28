package sihd.server;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.httpinvoker.HttpInvokerServiceExporter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import sihd.api.FoodService;

@Configuration
@EnableWebMvc
public class ApplicationContextConfiguration {
	@Bean(name="/food.service")
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

}
