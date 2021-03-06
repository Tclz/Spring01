package com_4.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;

/**
 * 连接的工具类，它用于从数据源中获取一个连接，并且实现和线程的绑定
 */
public class ConnectionUtils {
    /**
     * 使用ThreadLocal对象把connection和当前线程绑定，从而使一个线程中只有一个能控制事务的对象
     */
    private ThreadLocal<Connection>tl = new ThreadLocal<Connection>();

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    private DataSource dataSource;

    /**
     * 获取当前线程上的连接
     */
    public Connection getThreadConnection(){
        try {
            // 1.先从ThreadLocal上获取
            Connection conn = tl.get();
            //2.判断当前线程上是否有连接
            if(conn==null){
                //3.从数据源中获取一个连接，并且存入ThreadLocal
                conn = dataSource.getConnection();
                tl.set(conn);
            }
                //4.返回当前线程上的连接
                return conn;

            }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    /**
     * 把连接和线程解绑
     */
    public void  removeConnection(){
        tl.remove();
    }
}
