package com_8.jdbcTemplate;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.sql.DriverManager;

public class jdbcTemplateDemo {
    public static void main(String[] args) {
        // 准备数据源：spring内置的数据源
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost:3306/tclz");
        ds.setUsername("root");
        ds.setPassword("1234");

        // 1.创建jdbcTemplate对象
        JdbcTemplate jt = new JdbcTemplate();

        // 给jt设置数据源
        jt.setDataSource(ds);
        // 2.执行操作
        jt.execute("insert into account(name,money) values('alan',1000)");

    }
}
