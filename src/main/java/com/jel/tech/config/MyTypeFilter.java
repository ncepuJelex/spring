package com.jel.tech.config;

import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

import java.io.IOException;

/**
 * 定制包扫描过滤规则
 * @author jelex.xu
 * @create 2019-02-19 23:08
 **/
public class MyTypeFilter implements TypeFilter {

    public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {

        ClassMetadata classMetadata = metadataReader.getClassMetadata();
        String className = classMetadata.getClassName();
        System.out.println(className + "<<<<");
        if (className.contains("Person")) {
            return true;
        }
        return false;
    }
}
