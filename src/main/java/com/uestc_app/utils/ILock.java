package com.uestc_app.utils;

/**
 * @auther Mr.Liao
 * @date 2022/10/16 10:18
 */
public interface ILock {

    /**
     * 尝试获取锁
     * @param timeoutSec 锁的持有时间，过期自动释放
     * @return true代表获取锁成功
     */
    boolean tryLock(long timeoutSec);


    /**
     * 释放锁
     */
    void unlock();
}
