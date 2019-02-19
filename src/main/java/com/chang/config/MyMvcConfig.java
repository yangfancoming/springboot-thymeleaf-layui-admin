package com.chang.config;

import org.springframework.context.annotation.Configuration;
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

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/layuiadmin/**").addResourceLocations(ResourceUtils.CLASSPATH_URL_PREFIX + "/static/layuiadmin/"); //layuiadmin的样式以及插件
//        registry.addResourceHandler("/attachment/**").addResourceLocations("/attachment/"); //附件存放的位置 例: 图片，文件等
    }
}
