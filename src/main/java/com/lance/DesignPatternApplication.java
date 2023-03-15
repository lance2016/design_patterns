package com.lance;

import com.lance.event.UserRegisterEvent;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.DefaultSingletonBeanRegistry;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.lang.reflect.Field;
import java.util.Map;


@SpringBootApplication(scanBasePackages = "com.lance.**")
public class DesignPatternApplication {

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
//        SpringApplication.run(DesignPatternApplication.class, args);

        ConfigurableApplicationContext context = SpringApplication.run(DesignPatternApplication.class, args);

        Field singletonObjects = DefaultSingletonBeanRegistry.class.getDeclaredField("singletonObjects");
        singletonObjects.setAccessible(true);
        ConfigurableListableBeanFactory beanFactory = context.getBeanFactory();
        Map<String, Object> map = (Map<String, Object>) singletonObjects.get(beanFactory);
//        过滤map，输出key以cat开头的
        map.entrySet().stream().filter(entry -> entry.getKey().startsWith("cat")).forEach(entry -> {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        });

        context.publishEvent(new UserRegisterEvent(context));
    }

}
