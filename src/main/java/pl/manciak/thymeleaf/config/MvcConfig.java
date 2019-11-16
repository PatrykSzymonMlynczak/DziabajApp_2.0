package pl.manciak.thymeleaf.config;

import org.springframework.context.annotation.Configuration;

import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.math.BigDecimal;
import java.util.Arrays;


@Configuration
public class MvcConfig implements WebMvcConfigurer {

    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/start").setViewName("start");
        registry.addViewController("/").setViewName("start");
        registry.addViewController("/hello").setViewName("hello");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/prod").setViewName("prod");

    }
    public static Iterable<Object[]> testData(){
        return Arrays.asList(new Object[][] {
                {2, BigDecimal.valueOf(123.456), BigDecimal.valueOf(123.45)},
                {0, BigDecimal.valueOf(123.456), BigDecimal.valueOf(123)},
                {1, BigDecimal.valueOf(123.4), BigDecimal.valueOf(123.4)}
        });
    }
}