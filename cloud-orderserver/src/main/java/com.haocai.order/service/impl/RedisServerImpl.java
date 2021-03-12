package com.haocai.order.service.impl;

import com.haocai.base.cloudbase.exception.BusinessException;
import com.haocai.base.cloudbase.util.UuidUtil;
import com.haocai.order.config.RedisPool;
import com.haocai.order.config.RedisUtil;
import com.haocai.order.service.RedisService;
import com.sun.prism.j2d.J2DPipeline;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.jredis.JredisPool;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.Transaction;

import java.util.List;

@Service
@Slf4j
public class RedisServerImpl implements RedisService {

    @Autowired
    private JedisPool jedisPool;

    /**
     * 加锁
     * @param lockName 锁的key
     * @param acquireTime 获取超时时间
     * @param timeout 锁的超时时间
     * @return
     */
    @Override
    public String lockWithTimeout(String lockName, long acquireTime, long timeout){
        Jedis conn = null;

        String retIdentifier = null;

        try {
            //获取连接
            conn = jedisPool.getResource();
            //随机生成一个value(uuid)
            String identifier = UuidUtil.getUuid();
            //锁名
            String lockKey = "lock:"+lockName;

            //超时时间，上锁后超过此时间自动释放锁
            int lockExpire = (int)(timeout /1000);
            //获取锁的超时时间，超过这个时间则自动放弃获取锁
            long end = System.currentTimeMillis() + acquireTime;

            while(System.currentTimeMillis() < end){
                //当key不存在时，返回1
                if(conn.setnx(lockKey, identifier) == 1){
                    conn.expire(lockKey, lockExpire);
                    retIdentifier = identifier;
                    return retIdentifier;
                }

                //返回-1 代表key没有设置超时时间
                if(conn.ttl(lockKey) == -1){
                    //为key设置一个超时时间
                    conn.expire(lockKey, lockExpire);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new BusinessException("redis 异常");
        } finally {
            if(conn != null){
                conn.close();
            }
        }
        return null;
    }

    /**
     * 释放锁
     * @param lockName 锁的key
     * @param identifier 释放锁的标识
     * @return
     */
    @Override
    public boolean releaseLock(String lockName, String identifier){
        Jedis conn = null;
        String lockKey = "lock:"+lockName;
        boolean retFlag = false;

        try {
            conn = jedisPool.getResource();
            while(true){
                conn.watch(lockKey);
                if(identifier.equals(conn.get(lockKey))){
                    Transaction transaction = conn.multi();
                    transaction.del(lockKey);
                    List<Object> results = transaction.exec();
                    if(results == null){
                        continue;
                    }
                    retFlag = true;
                }
                conn.unwatch();
                break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(conn != null){
                conn.close();
            }
        }
        return retFlag;
    }
}
