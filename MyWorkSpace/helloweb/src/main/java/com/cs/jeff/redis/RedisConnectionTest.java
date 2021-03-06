package com.cs.jeff.redis;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPoolConfig;

public class RedisConnectionTest {

    private RedisConnection redisConnection;

    @Before
    public void before() {

        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        // 设置 redis 连接池最大连接数量
        jedisPoolConfig.setMaxTotal(50);
        // 设置 redis 连接池最大空闲连接数量
        jedisPoolConfig.setMaxIdle(10);
        // 设置 redis 连接池最小空闲连接数量
        jedisPoolConfig.setMinIdle(1);
        this.redisConnection = new RedisConnection();
        this.redisConnection.setIp("10.39.201.26");
        this.redisConnection.setPort(6379);
        this.redisConnection.setPwd("123456");
        this.redisConnection.setClientName(Thread.currentThread().getName());
        this.redisConnection.setTimeOut(600);
        this.redisConnection.setJedisPoolConfig(jedisPoolConfig);
    }

    @Test
    public void testPutGet() {

        Jedis jedis = this.redisConnection.getJedis();
        try {
            //jedis.select(1);
            jedis.set("name", "grace");
            jedis.set("abc", "abccc");
            Assert.assertTrue("grace".equals(jedis.get("name")));
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }
}
