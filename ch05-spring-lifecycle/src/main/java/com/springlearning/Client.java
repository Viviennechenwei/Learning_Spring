package com.springlearning;

import com.springlearning.entity.Account;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {


    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
        Account account = context.getBean(Account.class);
        System.out.println(account.toString());

        context.registerShutdownHook();
    }
}
