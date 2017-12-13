package org.smart4j.framework.bean;

/**
 * 返回数据对象
 * @author AoguInk
 *         2016/2/4
 */
public class Data {

    /**
     * 模型数据
     */
    private Object model;

    public Data(Object object){
        model = object;
    }

    public Object getModel() {
        return model;
    }
}
