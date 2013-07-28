package sihd.server;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] { ApplicationContextConfiguration.class };
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] { "*.service" };
	}

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return null;
	}

}
