package com.cafebabe.autoconfigure.web;


import com.cafebabe.interceptor.UtilInterceptor;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.annotation.Resource;
import javax.servlet.MultipartConfigElement;

/**
 * webMvc基础配置，有注册拦截器、配置静态资源路径、视图解析器配置等方法提供。
 * <p>createDate: 2017/10/23 16:39
 * <p>blog: <a href=http://www.cnblogs.com/koala2016/>喝咖啡的考拉</a>
 * <p>author: 李德华 
 * <p>version: 1.0 2017/10/23
 */
@Configuration
public class CafebabeWebMvcAutoConfiguration extends WebMvcConfigurerAdapter {
    @Resource
    private UtilInterceptor utilInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 多个拦截器组成一个拦截器链
        // addPathPatterns 用于添加拦截规则
        // excludePathPatterns 用户排除拦截
        registry.addInterceptor(utilInterceptor).addPathPatterns("/**");
        //registry.addInterceptor(utilInterceptor).addPathPatterns("/**");
        super.addInterceptors(registry);
    }

    //文件上传
//    @Bean
//    public MultipartConfigElement multipartConfigElement() {
//        MultipartConfigFactory factory = new MultipartConfigFactory();
//        //文件最大
//        factory.setMaxFileSize("2048KB"); //KB,MB
//        /// 设置总上传数据总大小
//        factory.setMaxRequestSize("20480KB");
//        return factory.createMultipartConfig();
//    }
//    @Override
//    public void addViewControllers(ViewControllerRegistry registry) {
//        registry.addViewController("/").setViewName("forward:/login");
//    }

    //    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/webjars/**")
//                .addResourceLocations("classpath:/META-INF/resources/webjars/"); //优先添加的高于后添加的，可利用动态参数传入
//    }


}
