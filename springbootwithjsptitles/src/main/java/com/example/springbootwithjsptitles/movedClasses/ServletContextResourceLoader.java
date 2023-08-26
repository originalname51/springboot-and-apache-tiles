package com.example.springbootwithjsptitles.movedClasses;
//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//


import jakarta.servlet.ServletContext;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.web.context.support.ServletContextResource;

public class ServletContextResourceLoader extends DefaultResourceLoader {
    private final ServletContext servletContext;

    public ServletContextResourceLoader(ServletContext servletContext) {
        this.servletContext = servletContext;
    }

    protected Resource getResourceByPath(String path) {
        return new ServletContextResource(this.servletContext, path);
    }
}
