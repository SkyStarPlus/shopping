package com.netease.zzw.shopping.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.io.File;

/**
 * 资源映射路径
 */
@Configuration
public class MyWebAppConfigurer implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        String imageRealPath = new File("images").getAbsolutePath();
        registry.addResourceHandler(GoodsConst.relativePath + "**").addResourceLocations("file:" + imageRealPath + "\\");
    }
}