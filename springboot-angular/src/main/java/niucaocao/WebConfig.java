package niucaocao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.handler.MappedInterceptor;

@Configuration
public class WebConfig extends  WebMvcConfigurerAdapter {
	   @Override
	    public void addResourceHandlers(ResourceHandlerRegistry registry) {
		   System.out.println("configgggggggg");
	        registry.addResourceHandler("/movie/**")
	                .addResourceLocations("file:/C:/Resources/");
	        super.addResourceHandlers(registry);
	    }
	   
	    @Autowired
	    HandlerInterceptor loggingIntercepter;
	
	    @Override
	    public void addInterceptors(InterceptorRegistry registry) {
	        registry.addInterceptor(loggingIntercepter);
	    }
}
