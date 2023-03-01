package com.lance.design.pattern_02_proxy;

// 代理类，用于控制对远程服务的访问
class RemoteServiceProxy implements RemoteService {
    private RemoteService remoteService;

    public RemoteServiceProxy(RemoteService remoteService) {
        this.remoteService = remoteService;
    }

    @Override
    public void operation() {
        // 在执行远程服务操作之前，执行一些附加操作，例如验证用户权限等
        System.out.println("Performing some additional operations before executing remote operation");

        // 调用远程服务对象的操作方法
        this.remoteService.operation();

        // 在执行远程服务操作之后，执行一些附加操作，例如记录访问日志等
        System.out.println("Performing some additional operations after executing remote operation");
    }
}