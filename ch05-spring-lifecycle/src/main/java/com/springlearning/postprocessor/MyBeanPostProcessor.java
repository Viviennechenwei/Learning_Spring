package com.springlearning.postprocessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class MyBeanPostProcessor implements BeanPostProcessor {


    public MyBeanPostProcessor() {
        super();
        System.out.println("这是BeanPostProcessor的实现类构造器。。。");
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if ("account".equals(beanName)) {
            System.out.println("BeanPostProcessor的postProcessBeforeInitialization方法， bean name 是： " + beanName);
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if ("account".equals(beanName)) {
            System.out.println("BeanPostProcessor的postProcessAfterInitialization， bean name 是： " + beanName);
        }
        return bean;
    }
}
