package niucaocao;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.HandlerInterceptor;

@EnableTransactionManagement
@Configuration
public class AppConfig{
     @Bean
    HandlerInterceptor loggingIntercepter(){
        return new LoggingIntercepter();
    }
}