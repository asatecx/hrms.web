package af;


import java.util.Locale;
import java.util.ResourceBundle;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.EnableAsync;

import af.base.other.OtherMessageSource;
import af.base.util.ApplicationContextUtil;
import af.base.util.MessageUtil;

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

    @Bean
    @Autowired
    public MessageSource messageSource() {
        MyResourceBundleMessageSource messageSource = new MyResourceBundleMessageSource();
        messageSource.setBasenames("af/messages/message", "xxx/messages/message", "hrms/messages/message");
        messageSource.setCacheSeconds(600);
        messageSource.setDefaultEncoding("UTF-8");
        messageSource.setUseCodeAsDefaultMessage(true);
        MessageUtil.setMessageSource(messageSource);

        OtherMessageSource mongoSource = new OtherMessageSource();
        return mongoSource;
    }

    public static class MyResourceBundleMessageSource extends ResourceBundleMessageSource {
        public ResourceBundle getResourceBundle(String basename, Locale locale) {
            return super.getResourceBundle(basename, locale);
        }
    }
}
