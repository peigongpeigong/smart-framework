package org.smart4j.framework.util;

/**
 * Created by thinkpad on 2016/1/27.
 */
public final class CastUtil {

    /**
     * 转为String类型，可指定默认值
     * @param obj
     * @param defalueValue
     * @return
     */
    public static String castString(Object obj,String defalueValue){
        return obj != null?String.valueOf(obj):defalueValue;
    }

    /**
     * 转为String类型，默认值空
     * @param obj
     * @return
     */
    public static String castString(Object obj){
        return castString(obj,"");
    }

    /**
     * 转为Double类型，需指定默认值
     * @param obj
     * @param defaultValue
     * @return
     */
    public static double castDouble(Object obj,double defaultValue){
        double doubleValue = defaultValue;
        if(obj != null){
            String strValue = castString(obj);
            if(StringUtil.isNotEmpty(strValue)){
                try{
                    doubleValue = Double.parseDouble(strValue);
                }catch (NumberFormatException e){
                    doubleValue = defaultValue;
                }
            }
        }
        return doubleValue;
    }

    /**
     * 转为double类型，默认0
     * @param obj
     * @return
     */
    public static double castDouble(Object obj){
        return castDouble(obj,0);
    }

    /**
     * 转为long类型，需提供默认值
     * @param obj
     * @param defaultValue
     * @return
     */
    public static long castLong(Object obj,long defaultValue){
        long longValue = defaultValue;
        if(null != obj){
            String strValue = castString(obj);
            if(StringUtil.isNotEmpty(strValue)){
                try {
                    longValue = Long.parseLong(strValue);
                }catch (NumberFormatException e){
                    longValue = defaultValue;
                }
            }
        }
        return longValue;
    }

    /**
     * 转为long类型，默认0
     * @param obj
     * @return
     */
    public static long castLong(Object obj){
        return castLong(obj,0);
    }

    /**
     * 转为int类型，需指定默认值
     * @param obj
     * @param defaultValue
     * @return
     */
    public static int castInt(Object obj,int defaultValue){
        int intValue = defaultValue;
        if(null != obj){
            String strValue = castString(obj);
            if(StringUtil.isNotEmpty(strValue)){
                try{
                    intValue = Integer.parseInt(strValue);
                }catch (NumberFormatException e){
                    intValue = defaultValue;
                }
            }
        }
        return intValue;
    }

    /**
     * 转为int类型，默认值0
     * @param obj
     * @return
     */
    public static int castInt(Object obj){
        return  castInt(obj,0);
    }

    /**
     * 转为boolean类型，需指定默认值
     * @param obj
     * @param defaultValue
     * @return
     */
    public static boolean castBoolean(Object obj,boolean defaultValue){
        boolean booleanValue = defaultValue;
        if(null !=obj){
            booleanValue = Boolean.parseBoolean(castString(obj));
        }
        return booleanValue;
    }

    /**
     * 转为boolean类型，默认false
     * @param obj
     * @return
     */
    public static boolean castBoolean(Object obj){
        return castBoolean(obj,false);
    }
}
