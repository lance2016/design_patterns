package com.lance.design.pattern_01_strategy;

public class ConcreteStrategyB implements Strategy {
    @Override
    public void executeAlgorithm() {
        System.out.println("Executing algorithm B");
    }
}
