package com.cafebabe;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * WebMvcAutoConfiguration 里面有许多spring boot的默认配置（设置了主页、 webjars 配置、静态资源位置等）
 * 想要使用默认配置，无需使用 @EnaleWebMvc 注解。使用了 @EnableWebMvc 注解后 WebMvcAutoConfiguration 提供的默认配置会失效，必须提供全部配置。
 * @author 李德华
 */
@SpringBootApplication
//@MapperScan(basePackages = DruidProperties.PACKAGE)
public class CafebabeApplication extends SpringBootServletInitializer{
	/**
	 * 产生一个可部署war包的第一步是提供一个SpringBootServletInitializer子类，并实现其configure方法。（web.xml）
	 * 第二部，修改pom文件，<packaging>war</packaging>
	 * @param builder a builder for the application context
	 * @return the application builder
	 */
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(CafebabeApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(CafebabeApplication.class, args);
	}
}
