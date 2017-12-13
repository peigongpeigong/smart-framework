package org.smart4j.framework.helper;

import org.smart4j.framework.annotation.Inject;
import org.smart4j.framework.util.ArrayUtil;
import org.smart4j.framework.util.CollectionUtil;
import org.smart4j.framework.util.ReflectionUtil;

import java.lang.reflect.Field;
import java.util.Map;

/**
 * 依赖注入助手
 * @author AoguInk
 *         2016/2/2
 */
public final class IocHelper {
    static{
        //获取所有的Bean类与Bean实例之间的映射关系，即BeanMap
        Map<Class<?>,Object> beanMap = BeanHelper.getBeanMap();
        if(CollectionUtil.isNotEmpty(beanMap)){
            //遍历BeanMap
            for(Map.Entry<Class<?>,Object> entry : beanMap.entrySet()){
                //从BeanMap中获取Bean类和Bean实例
                Class<?> beanClass = entry.getKey();
                Object beanInstance = entry.getValue();
                //获取bean类定义的所有成员变量
                Field[] beanFields = beanClass.getFields();
                if(ArrayUtil.isNotEmpty(beanFields)){
                    //如果Bean有Field,遍历Fields
                    for (Field beanField : beanFields){
                        if(beanField.isAnnotationPresent(Inject.class)){
                            //如果Field有Inject注解，则注入Field实例
                            //获取Field的Class类型
                            Class<?> beanFieldClass = beanField.getType();
                            //
                            Object beanFieldInstance = beanMap.get(beanFieldClass);
                            if(null != beanFieldInstance){
                                ReflectionUtil.setField(beanInstance,beanField,beanFieldInstance);
                            }
                        }
                    }
                }
            }
        }
    }
}
