package com.springlearning.entity;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;

public class Account implements  BeanNameAware, BeanFactoryAware, InitializingBean, DisposableBean{
    private int id;
    private String name;
    private float money;

    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("BeanFactoryAware -- beanFactory is: " + beanFactory);
    }

    public void setBeanName(String name) {
        System.out.println("BeanNameAware -- beanName is: " + name);
    }

    public void destroy() throws Exception {
        System.out.println("DisposableBean -- 正在执行。。。");
    }


    public void afterPropertiesSet() throws Exception {
        System.out.println("InitializingBean -- 正在执行。。。");
    }

    public Account() {
        System.out.println("Account 的无参构造函数正在执行。。。");
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        System.out.println("注入属性 -- 正在执行set方法 set Id。。。");
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        System.out.println("注入属性 -- 正在执行set方法 set name。。。");
        this.name = name;
    }

    public float getMoney() {
        return money;
    }

    public void setMoney(float money) {
        System.out.println("注入属性 -- 正在执行set方法 set money。。。");
        this.money = money;
    }

    public void myInit(){
        System.out.println("init-method -- 正在执行init-method 方法。。。");
    }

    public void myDestory(){
        System.out.println("destory-method -- 正在执行destory-method方法。。。");
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", money=" + money +
                '}';
    }
}
