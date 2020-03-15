package com.springlearning.utils;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

import java.sql.SQLException;

@Component
@Aspect
//相当于<aop:aspectj-proxy>
@EnableAspectJAutoProxy
public class TransactionManager {

    @Pointcut("execution(* *.*.*.*.AccountServiceImpl.*(..))")
    public void pt1(){}

    @Autowired
    ConnectionUtils connectionUtils;

//    @Before("pt1()")
    public void begainTransaction() {
        System.out.println("begainTransaction");
        try {
            connectionUtils.getConnection().setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

//    @AfterReturning("pt1()")
    public void commitTransaction() {
        System.out.println("commitTransaction");
        try {
            connectionUtils.getConnection().commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

//    @AfterThrowing("pt1()")
    public void rollback() {
        System.out.println("rollback");
        try {
            connectionUtils.getConnection().rollback();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

   // @After("pt1()")
    public void close() {
        try {
            System.out.println("close connection");
            connectionUtils.getConnection().close();
            connectionUtils.remove();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Around("pt1()")
    public Object aroundTransaction(ProceedingJoinPoint joinPoint){

        Object rtValue = null;
        Object[] args = joinPoint.getArgs();
        try {
            begainTransaction();
            rtValue = joinPoint.proceed(args);
            commitTransaction();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            rollback();
        }finally {
            close();
        }
        return rtValue;
    }
}
