package com.lance.design.pattern_02_proxy;

// 客户端
public class Main {
    public static void main(String[] args) {
        RemoteService remoteServiceProxy = new RemoteServiceProxy(new RemoteServiceImpl());
        remoteServiceProxy.operation();
    }
}