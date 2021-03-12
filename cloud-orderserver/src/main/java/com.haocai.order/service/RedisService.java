package com.haocai.order.service;

public interface RedisService {

    //获取锁
    String lockWithTimeout(String lockName, long acquireTime, long timeout);

    //释放锁
    boolean releaseLock(String lockName, String identifier);
}
