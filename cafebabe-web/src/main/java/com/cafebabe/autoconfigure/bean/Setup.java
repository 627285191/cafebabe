package com.cafebabe.autoconfigure.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.Configuration;

/**
 * beanFactoryPostprocessor的作用是在beanFactory初始化之后提供一个修改的机会。
 * 在Spring实例化bean的前后执行一些附加操作
 */
@Configuration
public class Setup implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
//        BeanDefinition bd = configurableListableBeanFactory.getBeanDefinition("postProcessorBean");
//        //bean中的参数
//        MutablePropertyValues pv =  bd.getPropertyValues();
//        if(pv.contains("username"))
//        {
//            pv.addPropertyValue("username", "xiaojun");
//        }

        System.out.println("beanFactoryPostprocessor的作用是在beanFactory初始化之后提供一个修改的机会。......这时候bean 还没实例化（instance)");
    }
}
