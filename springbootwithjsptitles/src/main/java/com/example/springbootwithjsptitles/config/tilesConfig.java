package com.example.springbootwithjsptitles.config;

import com.example.springbootwithjsptitles.movedClasses.TilesConfigurer;
import com.example.springbootwithjsptitles.movedClasses.TilesView;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.UrlBasedViewResolver;
// import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
// import org.springframework.web.servlet.view.tiles3.TilesView;

import jakarta.servlet.ServletContext;
import org.thymeleaf.spring6.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.templateresolver.AbstractTemplateResolver;

@Configuration
@EnableWebMvc
public class tilesConfig {

    @Bean(name = "viewResolver")
    public ViewResolver getViewResolver() {
        UrlBasedViewResolver viewResolver = new UrlBasedViewResolver();

        // TilesView 3
        viewResolver.setViewClass(TilesView.class);
    //    viewResolver.setPrefix("/WEB-INF/views");
    //    viewResolver.setSuffix(".jsp");
        return viewResolver;
    }

    @Bean
    public SpringResourceTemplateResolver templateResolver(ApplicationContext applicationContext) {
        var resolver = new SpringResourceTemplateResolver();
        resolver.setApplicationContext(applicationContext);
        resolver.setPrefix("WEB-INF/views/_");
        resolver.setSuffix(".jsp");
        return resolver;
    }

    @Bean(name = "tilesConfigurer")
    public TilesConfigurer getTilesConfigurer() {
        TilesConfigurer tilesConfigurer = new TilesConfigurer();

        // TilesView 3
        tilesConfigurer.setDefinitions(new String[]{"/WEB-INF/tiles.xml"});

        return tilesConfigurer;
    }
}
