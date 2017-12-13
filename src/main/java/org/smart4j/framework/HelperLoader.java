package org.smart4j.framework;

import org.smart4j.framework.annotation.Controller;
import org.smart4j.framework.helper.BeanHelper;
import org.smart4j.framework.helper.ClassHelper;
import org.smart4j.framework.helper.ControllerHelper;
import org.smart4j.framework.helper.IocHelper;
import org.smart4j.framework.util.ClassUtil;

/**
 * 加载相应的Helper类
 * @author AoguInk
 *         2016/2/2
 */
public final class HelperLoader {

    public static void init(){
        Class<?>[] classList = {
                ClassHelper.class,
                BeanHelper.class,
                ControllerHelper.class,
                IocHelper.class
        };
        for(Class cls : classList){
            ClassUtil.loadClass(cls.getName());
        }
    }


}
