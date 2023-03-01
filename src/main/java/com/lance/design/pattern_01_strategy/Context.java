package com.lance.design.pattern_01_strategy;

// 定义上下文类
class Context {
    private Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    public void execute() {
        this.strategy.executeAlgorithm();
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }
}

