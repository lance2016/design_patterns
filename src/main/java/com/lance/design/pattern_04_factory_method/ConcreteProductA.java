package com.lance.design.pattern_04_factory_method;

public class ConcreteProductA implements Product {
    @Override
    public void operation() {
        System.out.println("ConcreteProductA operation.");
    }
}
