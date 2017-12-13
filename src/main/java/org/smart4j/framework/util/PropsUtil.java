package org.smart4j.framework.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by thinkpad on 2016/1/27.
 */
public final class PropsUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(PropsUtil.class);

    /**
     * 加载属性文件
     * @param fileName
     * @return
     */
    public static Properties loadProps(String fileName){
        Properties props = null;
        InputStream is = null;
        try{
            is = Thread.currentThread().getContextClassLoader().getResourceAsStream(fileName);
            if(is == null){
                throw new FileNotFoundException(fileName + " file is not found");
            }
            props = new Properties();
            props.load(is);
        } catch (IOException e) {
            LOGGER.error("load properties file failure",e);
        }finally {
            if(is != null){
                try {
                    is.close();
                } catch (IOException e) {
                    LOGGER.error("close input stream failure",e);
                }
            }
        }
        return props;
    }


    /**
     * 获取字符型属性（可指定默认值）
     * @param prop
     * @param key
     * @param defalueValue
     * @return
     */
    public static String getString(Properties prop,String key,String defalueValue){
        String value = defalueValue;
        if(prop.containsKey(key)){
            value = prop.getProperty(key);
        }
        return value;
    }

    /**
     * 获取字符串（默认值为空）
     * @param props
     * @param key
     * @return
     */
    public static String getString(Properties props,String key){
        return getString(props,key,"");
    }

    /**
     * 获取数字类型属性
     * @param props
     * @param key
     * @param defaultValue
     * @return
     */
    public static int getInt(Properties props,String key,int defaultValue){
        int value = defaultValue;
        if(props.containsKey(key)){
            value = Integer.valueOf(props.getProperty(key));
        }
        return defaultValue;
    }

    /**
     * 获取数字属性，默认0
     * @param props
     * @param key
     * @return
     */
    public static int getInt(Properties props , String key){
        return getInt(props,key,0);
    }

    /**
     * 获取布尔属性，可指定默认值
     * @param props
     * @param key
     * @param defaultValue
     * @return
     */
    public static boolean getBoolean(Properties props,String key,boolean defaultValue){
        boolean value = defaultValue;
        if(props.containsKey(key)){
            value = Boolean.valueOf(props.getProperty(key));
        }
        return value;
    }

    /**
     * 获取布尔属性，默认值false
     * @param props
     * @param key
     * @return
     */
    public static boolean getBoolean(Properties props,String key){
        return getBoolean(props,key,false);
    }
}
