package com.example.springbootwithjsptitles.config;

import com.example.springbootwithjsptitles.movedClasses.SimpleSpringPreparerFactory;
import com.example.springbootwithjsptitles.movedClasses.TilesConfigurer;
import com.example.springbootwithjsptitles.movedClasses.TilesView;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.UrlBasedViewResolver;
@Configuration
public class tilesConfig implements WebMvcConfigurer {
    @Bean
    public TilesConfigurer tilesConfigurer() {
        TilesConfigurer tilesConfigurer = new TilesConfigurer();
        String[] tilesXml = { "WEB-INF/tiles.xml" };
        tilesConfigurer.setDefinitions(tilesXml);
        tilesConfigurer.setPreparerFactoryClass(SimpleSpringPreparerFactory.class);
        return tilesConfigurer;
    }
    @Bean(name = "viewResolver")
    public ViewResolver getViewResolver() {
        UrlBasedViewResolver viewResolver = new UrlBasedViewResolver();
        viewResolver.setViewClass(TilesView.class);
        return viewResolver;
    }
}
