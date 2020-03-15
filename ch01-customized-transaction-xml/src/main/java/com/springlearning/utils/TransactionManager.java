package com.springlearning.utils;

import org.springframework.beans.factory.annotation.Autowired;

import java.sql.SQLException;

public class TransactionManager {

    ConnectionUtils connectionUtils;

    public void setConnectionUtils(ConnectionUtils connectionUtils) {
        this.connectionUtils = connectionUtils;
    }

    public void begainTransaction(){
        System.out.println("begainTransaction");
        try {
            connectionUtils.getConnection().setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void commitTransaction(){
        System.out.println("commitTransaction");
        try {
            connectionUtils.getConnection().commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void rollback(){
        System.out.println("rollback");
        try {
            connectionUtils.getConnection().rollback();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void close(){
        try {
            System.out.println("close connection");
            connectionUtils.getConnection().close();
            connectionUtils.remove();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



}
