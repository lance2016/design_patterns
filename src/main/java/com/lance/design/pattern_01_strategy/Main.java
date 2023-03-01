package com.lance.design.pattern_01_strategy;

// 使用策略模式
public class Main {
    public static void main(String[] args) {
        Strategy strategyA = new ConcreteStrategyA();
        Context context = new Context(strategyA);
        context.execute();

        Strategy strategyB = new ConcreteStrategyB();
        context.setStrategy(strategyB);
        context.execute();

        Strategy strategyC = new ConcreteStrategyC();
        context.setStrategy(strategyC);
        context.execute();
    }
}
