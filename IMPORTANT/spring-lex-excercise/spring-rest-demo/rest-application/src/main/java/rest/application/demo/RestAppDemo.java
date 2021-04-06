package rest.application.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.util.UrlPathHelper;
import rest.application.demo.template.JpaMongoTemplate;

@SpringBootApplication
public class RestAppDemo implements CommandLineRunner, WebMvcConfigurer {
    private static Logger logger = LoggerFactory.getLogger(RestAppDemo.class);

    @Autowired
    JpaMongoTemplate jpaMongoTemplate;

    public static void main( String[] args )
    {
        SpringApplication.run(RestAppDemo.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        //jpaMongoTemplate.createCollection("product");
        logger.info("Welcome to rest application demo");
    }
    // To support matrix parameters
    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        UrlPathHelper urlPathHelper = new UrlPathHelper();
        urlPathHelper.setRemoveSemicolonContent(false);
        configurer.setUrlPathHelper(urlPathHelper);
    }
}
