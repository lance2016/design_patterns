package com.lance.service.impl;

import com.lance.service.AnimalService;
import org.springframework.stereotype.Service;

@Service("dog")
public class Dog implements AnimalService {
    @Override
    public void say() {
        System.out.println("I am dog");
    }
}
