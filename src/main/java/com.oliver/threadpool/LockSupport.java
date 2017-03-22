package com.oliver.threadpool;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by oliver on 2017/2/28.
 */
public enum  LockSupport {

    INSTANCE;

    private static Logger logger = LoggerFactory.getLogger(LockSupport.class);

    public static final int DEFAULT_LOCK_COUNT = 4096;

    private int lockCount = DEFAULT_LOCK_COUNT;

    private ReentrantLock[] locks = new ReentrantLock[lockCount];


    LockSupport() {
        System.out.println("lock init");
        for (int i = 0; i < lockCount; i++) {
            locks[i] = new ReentrantLock();
        }
    }

    public ReentrantLock getLock(Object key) {
        if (key == null) throw new NullPointerException();
        int index = Math.abs(key.hashCode()) % lockCount;
        if (logger.isDebugEnabled()) logger.debug("get lock index:{}", index);
        return locks[index];
    }
}

