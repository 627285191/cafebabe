package com.cafebabe.autoconfigure.logback;

import ch.qos.logback.access.ViewStatusMessagesServlet;
import ch.qos.logback.access.tomcat.LogbackValve;
import org.apache.catalina.Valve;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashSet;
import java.util.Set;

/**
 * <p>createDate: 2017/11/17 0:09
 * <p>blog: <a href=http://www.cnblogs.com/koala2016/>喝咖啡的考拉</a>
 * <p>author: 李德华 
 * <p>version: 1.0 2017/11/17
 */
@Configuration
public class LogbackAccessConfiguration {

    /**
     * 配置logback access servlet
     * @return 注册servlet
     */
    @Bean
    public ServletRegistrationBean servletRegistration() {
        ServletRegistrationBean servletRegistration = new ServletRegistrationBean(new ViewStatusMessagesServlet());
        servletRegistration.addUrlMappings("/lbAccessStatus");
        return servletRegistration;
    }

    /**
     * 将logback自定义的ValveBase配置到tomcat容器中
     * @return tomcat
     */
    @Bean
    public EmbeddedServletContainerFactory servletContainer() {
        TomcatEmbeddedServletContainerFactory tomcat = new TomcatEmbeddedServletContainerFactory();
        Set<Valve> set=new HashSet<>();
        LogbackValve logbackValve=new LogbackValve();
        logbackValve.setFilename(LogbackValve.DEFAULT_FILENAME);
        set.add(logbackValve);
        tomcat.setEngineValves(set);
        return tomcat;
    }
}
