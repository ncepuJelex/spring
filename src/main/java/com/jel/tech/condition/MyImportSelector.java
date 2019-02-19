package com.jel.tech.condition;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * 自定义逻辑返回导入的组件
 * @author jelex.xu
 * @create 2019-02-19 23:50
 **/
public class MyImportSelector implements ImportSelector {

    public String[] selectImports(AnnotationMetadata importingClassMetadata) {

        importingClassMetadata.getClassName();
        importingClassMetadata.getClass();
        return new String[]{"com.jel.tech.model.Blue"};
    }
}
