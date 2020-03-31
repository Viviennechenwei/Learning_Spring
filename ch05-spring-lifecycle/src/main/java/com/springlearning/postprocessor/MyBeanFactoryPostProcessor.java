package com.springlearning.postprocessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    public MyBeanFactoryPostProcessor(){
        super();
        System.out.println("这是BeanFactoryPostProcessor的实现类构造器。。。");
    }
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println("BeanFactoryPostProcessor 的 postProcessBeanFactory 正在执行。。。");
        BeanDefinition beanDefinition = beanFactory.getBeanDefinition("account");
        MutablePropertyValues propertyValues = beanDefinition.getPropertyValues();
        System.out.println("account 为： "+ propertyValues.toString());
        if(propertyValues.contains("name")){
            propertyValues.addPropertyValue("name", "Sam");
        }
        beanDefinition.setScope(BeanDefinition.SCOPE_SINGLETON);
    }
}
