package af.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

	@Autowired
    private Environment env;

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")// 1 设置访问源地址
                .allowCredentials(true)// 2 设置访问源请求头
                .allowedMethods("GET", "POST", "DELETE", "PUT") // 3 设置访问源请求方法
                .maxAge(3600);
    }
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/videos/**")
        		.addResourceLocations("file:" + env.getProperty("file.upload.video"));

        registry.addResourceHandler("/photos/**")
        		.addResourceLocations("file:" + env.getProperty("file.upload.photo"));
    }
//    @Bean
//    public CorsFilter corsFilter() {
//        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//        source.registerCorsConfiguration("/**", buildConfig()); // 4 对接口配置跨域设置
//        return new CorsFilter(source);
//    }

}
