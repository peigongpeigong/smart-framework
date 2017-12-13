package org.smart4j.framework.bean;

import java.util.Map;

/**
 * 返回视图对象
 * @author AoguInk
 *         2016/2/4
 */
public class View {

    /**
     * 请求路径
     */
    private String path;

    /**
     * 模型数据
     */
    private Map<String,Object> model;

    public View(String path){
        this.path = path;
    }

    public View addModel(String key,Object value){
        model.put(key, value);
        return this;
    }

    public String getPath() {
        return path;
    }

    public Map<String, Object> getModel() {
        return model;
    }
}
