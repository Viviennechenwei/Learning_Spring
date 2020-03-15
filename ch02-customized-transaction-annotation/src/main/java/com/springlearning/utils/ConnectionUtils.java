package com.springlearning.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@Component
public class ConnectionUtils{

    ThreadLocal<Connection> tl = new ThreadLocal<Connection>();

    @Autowired
    DataSource dataSource;

    public Connection getConnection() {
        Connection conn = tl.get();
        if (conn == null) {
            try {
                conn = dataSource.getConnection();
                tl.set(conn);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return conn;
    }

    public void remove() {
        //将connection移除，此时connection已经被关掉如果不从线程中移除connection，那么下次就会拿到带有无效connection的线程
        tl.remove();
    }
}
