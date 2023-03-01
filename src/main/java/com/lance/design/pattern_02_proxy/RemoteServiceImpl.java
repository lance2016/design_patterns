package com.lance.design.pattern_02_proxy;

// 实际的远程服务对象
class RemoteServiceImpl implements RemoteService {
    @Override
    public void operation() {
        System.out.println("Executing operation on remote service");
    }
}
