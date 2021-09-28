package com.geekymv.springcloud.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RuleConfig {

    /**
     * 全局策略设置
     * @return
     */
    @Bean
    public IRule rule() {
        return new RandomRule();
    }
}
