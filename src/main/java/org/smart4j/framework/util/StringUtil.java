package org.smart4j.framework.util;

import org.apache.commons.lang3.StringUtils;

/**
 * Created by thinkpad on 2016/1/27.
 */
public final class StringUtil {

    /**
     * 判断字符串是否为空
     * @param str
     * @return
     */
    public static boolean isEmpty(String str){
        if(str != null){
            str = str.trim();
        }
        return StringUtils.isEmpty(str);
    }

    /**
     * 判断是否不为空
     * @param str
     * @return
     */
    public static boolean isNotEmpty(String str){
        return !isEmpty(str);
    }


    public static String[] splitString(String str,String separator){
        return StringUtils.split(str,separator);
    }
}
