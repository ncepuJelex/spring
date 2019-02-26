package com.jel.tech.config;

import com.jel.tech.model.Yellow;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
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
 *  指定组件在哪个环境的情况下才能注入到容器中
 *
 *   加了环境标识的bean，只有这个环境被激活才会注入到容器中
 *      默认default环境生效
 *
 *  @Profile 可以写在类上，只有指定环境的时候，整个类中配置才能生效
 *
 *  没有标注环境的bean都是加载的
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


    @Bean
    public Yellow yellow() {
        return new Yellow();
    }


//    @Profile("default")
    @Profile("dev")
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

    @Profile("test")
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

    @Profile("prod")
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
