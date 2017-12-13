package org.smart4j.framework.helper;

import org.smart4j.framework.util.ReflectionUtil;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Bean助手类
 * @author AoguInk
 * 2016/2/2
 */
public final class BeanHelper {

    /**
     * 定义Bean映射（用于存放Bean类与实例的映射关系）
     */
    private static final Map<Class<?>,Object> BEAN_MAP = new HashMap<Class<?>, Object>();

    static {
        Set<Class<?>> classSet = ClassHelper.getBeanClassSet();
        for(Class clazz : classSet){
            Object obj = ReflectionUtil.newInstance(clazz);
            BEAN_MAP.put(clazz,obj);
        }
    }

    /**
     * 获取Bean映射
     * @return
     */
    public static Map<Class<?>,Object> getBeanMap(){
        return BEAN_MAP;
    }

    /**
     * 从映射中获取Bean实例
     * @param tClass
     * @param <T>
     * @return
     */
    public static <T> T getBean(Class<T> tClass){
        if(!BEAN_MAP.containsKey(tClass)){
            throw new RuntimeException("can not get bean by blass :" + tClass);
        }
        return (T)BEAN_MAP.get(tClass);
    }
}
