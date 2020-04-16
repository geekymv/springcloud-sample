package com.geekymv.springcloud.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

@Slf4j
@Service
public class CacheService {

    @Autowired
    private RedisTemplate redisTemplate;

    public void set(String key, Object value) {
        redisTemplate.opsForValue().set(key, value);
    }

    public void set(String key, Object value, long timeout) {
        redisTemplate.opsForValue().set(key, value, timeout, TimeUnit.SECONDS);
    }

    public void set(String key, Object value, Duration timeout) {
        redisTemplate.opsForValue().set(key, value, timeout);
    }

    public Object get(String key) {
        return redisTemplate.opsForValue().get(key);
    }

    public Long decr(String key) {
        return redisTemplate.opsForValue().decrement(key);
    }

    public void leftPushAll(String key, String... values) {
        redisTemplate.opsForList().leftPushAll(key, values);
    }

    public Boolean delete(String key) {
        return redisTemplate.delete(key);
    }

    public Object leftPop(String key) {
        return redisTemplate.opsForList().leftPop(key);
    }

    public Boolean tryLock(String key) {
        return this.tryLock(key, 60);
    }

    public Boolean tryLock(String key, long timeout) {
        return redisTemplate.opsForValue().setIfAbsent(key, "lock", timeout, TimeUnit.SECONDS);
    }

    public Boolean unLock(String key) {
        return redisTemplate.delete(key);
    }

    public Long scard(String key) {
        return this.redisTemplate.opsForSet().size(key);
    }

    /**
     * 判断是否存在集合中
     * @param key
     * @param element
     * @return
     */
    public boolean isMember(String key,String element){
        return this.redisTemplate.opsForSet().isMember(key, element);
    }

    public void saddBatch(String key, Serializable... value) {
        redisTemplate.boundSetOps(key).add(value);
    }

    public Object spop(String key) {
        return redisTemplate.boundSetOps(key).pop();
    }
}
