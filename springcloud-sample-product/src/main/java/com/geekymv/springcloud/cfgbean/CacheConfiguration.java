package com.geekymv.springcloud.cfgbean;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;

/**
 * 缓存配置管理类
 */
@Configuration
@EnableCaching
@ConditionalOnProperty(prefix = "spring.cache.ehcache", name = "enabled", havingValue = "true")
public class CacheConfiguration {

}
