package my.webConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/**
 * Created by User on 10.09.2018.
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "my")
@PropertySource(value = {
        "classpath:googleNews.properties",
        "classpath:yandexTranslator.properties",
        "classpath:encrypt.service.properties",
        "classpath:datasource.config.properties",
        "classpath:hibernate.config.properties"},
        encoding = "windows-1251",
        ignoreResourceNotFound = true)
public class WebConfig implements WebMvcConfigurer {

    @Bean
    public InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setViewClass(JstlView.class);
        viewResolver.setPrefix("/WEB-INF/pages/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }

    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/login");
    }

}
