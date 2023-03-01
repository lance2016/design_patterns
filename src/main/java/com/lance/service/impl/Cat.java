package com.lance.service.impl;

import com.lance.service.AnimalService;
import org.springframework.stereotype.Service;


@Service("cat")
public class Cat implements AnimalService {
    @Override
    public void say() {
        System.out.println("I am a cat");
    }
}
