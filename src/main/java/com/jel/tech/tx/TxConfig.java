package com.jel.tech.tx;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

/**
 * 事务
 *
 * 导入2个组件：AutoProxyRegistrar.class.getName(), ProxyTransactionManagementConfiguration.class.getName()};
 *
 * @author jelex.xu
 * @create 2019-03-06 22:53
 **/
@EnableTransactionManagement
@ComponentScan("com.jel.tech.tx")
@Configuration
public class TxConfig {

    @Bean
    public DataSource dataSource() throws PropertyVetoException {

        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setUser("root");
        dataSource.setPassword("root");
        dataSource.setDriverClass("com.mysql.jdbc.Driver");
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/test");

        return dataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate() throws PropertyVetoException {

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource());

        return jdbcTemplate;
    }

    @Bean
    public PlatformTransactionManager transactionManager() throws PropertyVetoException {

        return new DataSourceTransactionManager(dataSource());
    }
}
