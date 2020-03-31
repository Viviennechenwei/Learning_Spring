package com.springlearning.postprocessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessorAdapter;

import java.beans.PropertyDescriptor;

public class MyInstantiationAwareBeanPostProcessorAdapter extends InstantiationAwareBeanPostProcessorAdapter {

    public MyInstantiationAwareBeanPostProcessorAdapter(){
        super();
        System.out.println("这是InstantiationAwareBeanPostProcessorAdapter的实现类构造器。。。");
    }

    @Override
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
        if("account".equals(beanName)){
            System.out.println("InstantiationAwareBeanPostProcessorAdapter 的 postProcessBeforeInstantiation 方法正在执行 bean name是： " + beanName);
        }
        return null;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if("account".equals(beanName)){
            System.out.println("InstantiationAwareBeanPostProcessorAdapter 的 postProcessAfterInitialization 方法正在执行 bean name是： " + beanName);
        }
        return bean;
    }

    @Override
    public PropertyValues postProcessPropertyValues(
            PropertyValues pvs, PropertyDescriptor[] pds, Object bean, String beanName) throws BeansException {

        if("account".equals(beanName)){
            System.out.println("InstantiationAwareBeanPostProcessorAdapter 的 postProcessPropertyValues 方法正在执行 bean name是： " + beanName);
        }
        return pvs;
    }
}
