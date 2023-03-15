package com.lance.util;

import com.lance.annotation.MyAnno;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class BeanUtil {


    // 1. 通过反射获取类的实例
    // 2. 遍历类的属性，通过注解获取默认值，然后赋值给属性
    // 3. 返回赋值后的对象
    public static <T> T getBean(Class<T> clazz){
        // 1. 通过反射获取类的实例
        try {
            T t = clazz.newInstance();
            // 2. 遍历类的属性，通过注解获取默认值，然后赋值给属性
            Field[] fields = clazz.getDeclaredFields();
            for (Field field : fields) {
                // 获取属性的注解
                MyAnno myAnno = field.getAnnotation(MyAnno.class);
                if (myAnno != null) {
                    // 通过反射方式获取注解的值
                    Method method = myAnno.getClass().getMethod("value");
                    String value = (String) method.invoke(myAnno);
                    // 通过反射方式给属性赋值
                    field.setAccessible(true);
                    field.set(t, value);
                }
            }
            return t;
        } catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            e.printStackTrace();
        }

        // 3. 返回赋值后的对象
        return null;
    }


}
