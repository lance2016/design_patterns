package com.lance.service.impl;

import com.lance.event.UserRegisterEvent;
import com.lance.service.AnimalService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;


@Service("cat")
@Slf4j
public class Cat implements AnimalService {
    @Override
    public void say() {
        System.out.println("I am a cat");
    }

    @EventListener
    public void listen(UserRegisterEvent event) {
        log.info("cat listen to " + event.getSource());
    }
}
