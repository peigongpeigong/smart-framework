package org.smart4j.framework.util;


import org.apache.commons.lang3.ArrayUtils;

/**
 * 数组工具类
 * @author AoguInk
 *         2016/2/2
 */
public final class ArrayUtil {

    public static boolean isEmpty(Object[] array){
        return ArrayUtils.isEmpty(array);
    }

    public static boolean isNotEmpty(Object[] array){
        return !ArrayUtils.isEmpty(array);
    }
}
