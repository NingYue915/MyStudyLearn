package com.cs.jeff.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class RedisConnection {

    /**
     * redis 连接池配置信息
     */
    private JedisPoolConfig jedisPoolConfig;

    /**
     * redis 服务器地址
     */
    private String ip;

    /**
     * redis 服务器端口
     */
    private Integer port;

    /**
     * redis 服务器密码
     */
    private String pwd;

    /**
     * redis 服务器连接超时时间
     */
    private Integer timeOut;

    /**
     * redis 连接客户端名称
     */
    private String clientName = null;

    private JedisPool jedisPool;

    public void setJedisPoolConfig(final JedisPoolConfig jedisPoolConfig) {

        this.jedisPoolConfig = jedisPoolConfig;
    }

    public void setIp(final String ip) {

        this.ip = ip;
    }

    public void setPort(final Integer port) {

        this.port = port;
    }

    public void setPwd(final String pwd) {

        this.pwd = pwd;
    }

    public void setTimeOut(final Integer timeOut) {

        this.timeOut = timeOut;
    }

    public void setClientName(final String clientName) {

        this.clientName = clientName;
    }

    private void buildConnection() {

        if (this.jedisPool == null) {
            if (this.jedisPoolConfig == null) {
                this.jedisPool = new JedisPool(new JedisPoolConfig(), this.ip, this.port, this.timeOut, this.pwd, 0, this.clientName);
            } else {
                this.jedisPool = new JedisPool(this.jedisPoolConfig, this.ip, this.port, this.timeOut, this.pwd, 0, this.clientName);
            }
        }
    }

    public Jedis getJedis() {

        buildConnection();
        if (this.jedisPool != null) {
            return this.jedisPool.getResource();
        }
        return null;
    }
}
