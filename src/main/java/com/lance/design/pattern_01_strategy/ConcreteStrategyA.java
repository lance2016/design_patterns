package com.lance.design.pattern_01_strategy;

public class ConcreteStrategyA implements Strategy {
    @Override
    public void executeAlgorithm() {
        System.out.println("Executing algorithm A");
    }
}
