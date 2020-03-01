package af;


import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.EnableAsync;

import af.base.util.ApplicationContextUtil;

@EnableAsync
@SpringBootApplication
@ComponentScan("af")
@ComponentScan("hrms")
//@MapperScan(basePackages ={"af.itt.sc.mapper"})
public class ApplicationStarter  {

    private static Log logger = LogFactory.getLog(ApplicationStarter.class);

    @Autowired
    protected Environment environment;

    public static Environment getEnvironment() {
        return ((ApplicationStarter)ApplicationContextUtil.getObject(ApplicationStarter.class)).environment;
    }

    public static void main(String[] args) {
    	SpringApplication.run(ApplicationStarter.class, args);
    }

    @Bean
    protected ServletContextListener listener() {
        return new ServletContextListener() {
            @Override
            public void contextInitialized(ServletContextEvent sce) {
                logger.info("AppContext initialized");
            }
            @Override
            public void contextDestroyed(ServletContextEvent sce) {
                logger.info("AppContext destroyed");
            }
        };
    }
}
