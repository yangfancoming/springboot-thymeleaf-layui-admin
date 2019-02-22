package com.chang.config;

import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.util.ResourceUtils;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Created by chang .
 * Date: 2019/2/8
 * Time: 18:27
 * Description: To change this template use File | Settings | File Templates.
 */
@Configuration
public class MyMvcConfig implements WebMvcConfigurer {

//    @Bean
//    public WebServerFactoryCustomizer<ConfigurableWebServerFactory> webServerFactoryCustomizer() {
//        return factory -> {
//            factory.addErrorPages(new ErrorPage(HttpStatus.BAD_REQUEST, "/error/400"));
//            factory.addErrorPages(new ErrorPage(HttpStatus.UNAUTHORIZED, "/error/401"));
//            factory.addErrorPages(new ErrorPage(HttpStatus.METHOD_NOT_ALLOWED, "/error/405"));
//            factory.addErrorPages(new ErrorPage(HttpStatus.NOT_FOUND, "/error/404"));
//            factory.addErrorPages(new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/error/500"));
//            factory.addErrorPages(new ErrorPage(Throwable.class, "/error/500"));
//        };
//    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/layuiadmin/**").addResourceLocations(ResourceUtils.CLASSPATH_URL_PREFIX + "/static/layuiadmin/"); //layuiadmin的样式以及插件
        registry.addResourceHandler("/static/attachment/**").addResourceLocations(ResourceUtils.CLASSPATH_URL_PREFIX + "/static/attachment/"); //附件存放的位置 例: 图片，文件等
    }
}
