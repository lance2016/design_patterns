package com.lance.web;

import com.lance.annotation.LogExecutionTime;
import com.lance.service.AnimalService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class WebController {

    /**
     * 搭配lobmok RequiredArgsConstructor 通过构造器注入
     * 同时变量名称需要为Service的bean名称，应为有两个类都实现了AnimalService
     * 相当于 @Autowired搭配@Qualifier("cat")
     */
    private final  AnimalService cat;

    @Autowired
    private  Map<String, AnimalService> animalServiceMap;

    @Resource
    private  List<AnimalService> animalServiceList;

    @LogExecutionTime
    @GetMapping("/test")
    public void test(){
        System.out.println("test method");
        cat.say();
        animalServiceMap.get("dog").say();
        animalServiceList.get(0).say();
    }
}
