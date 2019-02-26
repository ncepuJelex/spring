package com.jel.tech.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringValueResolver;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

/**
 * Profile:
 *  Spring可以根据当前环境动态切换、激活一系列组件
 *      开发环境：
 *      测试环境：
 *      生产环境：
 *   数据源 ： dev, test, prod
 *
 * @author jelex.xu
 * @create 2019-02-27 00:06
 **/
@PropertySource("classpath:/dbconfig.properties")
@Configuration
public class MainConfigProfile implements EmbeddedValueResolverAware  {

    @Value("${db.user}")
    private String user;

    private StringValueResolver resolver;
    private String driverClass;

    @Bean("dsDev")
    public DataSource dataSourceDev() throws PropertyVetoException {

        ComboPooledDataSource source = new ComboPooledDataSource();
//        source.setUser("root");
        source.setUser(user);
        source.setPassword("root");
        source.setJdbcUrl("jdbc:mysql://localhost:3306/goods");
        source.setDriverClass("com.mysql.jdbc.Driver");

        return source;
    }

    @Bean("dsTest")
    public DataSource dataSourceTest(@Value("${db.password}") String pwd) throws PropertyVetoException {

        ComboPooledDataSource source = new ComboPooledDataSource();
        source.setUser("root");
//        source.setPassword("root");
        source.setPassword(pwd);
        source.setJdbcUrl("jdbc:mysql://localhost:3306/orm");
        source.setDriverClass("com.mysql.jdbc.Driver");

        return source;
    }

    @Bean("dsProd")
    public DataSource dataSourceProd() throws PropertyVetoException {

        ComboPooledDataSource source = new ComboPooledDataSource();
        source.setUser("root");
        source.setPassword("root");
        source.setJdbcUrl("jdbc:mysql://localhost:3306/readinglist");
//        source.setDriverClass("com.mysql.jdbc.Driver");
        source.setDriverClass(driverClass);

        return source;
    }

    public void setEmbeddedValueResolver(StringValueResolver resolver) {
        this.resolver = resolver;
        this.driverClass = resolver.resolveStringValue("${db.driverClass}");
    }
}
