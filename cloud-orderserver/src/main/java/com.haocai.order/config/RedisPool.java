package com.haocai.order.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

@Slf4j
@Configuration
public class RedisPool {

/*    private static Integer maxTotal = Integer.parseInt(PropertiesUtil.getProperty("redis.max.total","20")); //最大连接数
    private static Integer maxIdle = Integer.parseInt(PropertiesUtil.getProperty("redis.max.idle","20"));//在jedispool中最大的idle状态(空闲的)的jedis实例的个数
    private static Integer minIdle = Integer.parseInt(PropertiesUtil.getProperty("redis.min.idle","20"));//在jedispool中最小的idle状态(空闲的)的jedis实例的个数

    private static Boolean testOnBorrow = Boolean.parseBoolean(PropertiesUtil.getProperty("redis.test.borrow","true"));//在borrow一个jedis实例的时候，是否要进行验证操作，如果赋值true。则得到的jedis实例肯定是可以用的。
    private static Boolean testOnReturn = Boolean.parseBoolean(PropertiesUtil.getProperty("redis.test.return","true"));//在return一个jedis实例的时候，是否要进行验证操作，如果赋值true。则放回jedispool的jedis实例肯定是可以用的。

    private static String redisIp = PropertiesUtil.getProperty("redis1.ip");
    private static Integer redisPort = Integer.parseInt(PropertiesUtil.getProperty("redis1.port"));*/

    @Value("${spring.redis.pool.max-active}")
    private Integer maxTotal; //最大连接数

    @Value("${spring.redis.pool.max-idle}")
    private Integer maxIdle;//在jedispool中最大的idle状态(空闲的)的jedis实例的个数

    @Value("${spring.redis.pool.min-idle}")
    private Integer minIdle;//在jedispool中最小的idle状态(空闲的)的jedis实例的个数

    //private static Boolean testOnBorrow;//在borrow一个jedis实例的时候，是否要进行验证操作，如果赋值true。则得到的jedis实例肯定是可以用的。
    //private static Boolean testOnReturn;//在return一个jedis实例的时候，是否要进行验证操作，如果赋值true。则放回jedispool的jedis实例肯定是可以用的。

    @Value("${spring.redis.host}")
    private String redisIp;

    @Value("${spring.redis.port}")
    private Integer redisPort ;

    @Value(("${spring.redis.password}"))
    private String password;

    @Bean(name = "jedisPool")
    public JedisPool redisPool(){
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(maxTotal);
        config.setMaxIdle(maxIdle);
        config.setMinIdle(minIdle);
        //config.setTestOnBorrow(testOnBorrow);
        //config.setTestOnReturn(testOnReturn);
        config.setBlockWhenExhausted(true);//连接耗尽的时候，是否阻塞，false会抛出异常，true阻塞直到超时。默认为true。

        return new JedisPool(config,redisIp,redisPort,1000*2);
    }

    public static void close(Jedis jedis){
        try {
            if (jedis != null) {
                jedis.close();
            }
        } catch (Exception e) {
            log.error("return redis resource exception", e);
        }
    }

}
