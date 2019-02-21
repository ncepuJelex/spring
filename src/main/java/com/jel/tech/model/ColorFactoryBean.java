package com.jel.tech.model;

import org.springframework.beans.factory.FactoryBean;

/**
 * @author jelex.xu
 * @create 2019-02-21 22:49
 **/
public class ColorFactoryBean implements FactoryBean<Color> {

    /**
     * 返回一个对象，它会添加到容器中
     * @return
     * @throws Exception
     */
    public Color getObject() throws Exception {
        System.out.println("factory bean...");
        return new Color();
    }

    public Class<?> getObjectType() {
        return null;
    }

    public boolean isSingleton() {
        return false;
    }
}
