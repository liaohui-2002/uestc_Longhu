package com.uestc_app.config;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @auther Mr.Liao
 * @date 2022/10/16 17:15
 */
@Configuration
public class RedissonConfig {
    @Bean
    public RedissonClient redissonClient(){
        // 配置
        Config config = new Config();
        config.useSingleServer().setAddress("redis://192.168.3.150:6379")
                .setPassword("250237");
        // 创建RedissonClient对象
        return Redisson.create(config);
    }

    /*@Bean
    public RedissonClient redissonClient2(){
        // 配置
        Config config = new Config();
        config.useSingleServer().setAddress("redis://192.168.1.150:6380");
        // 创建RedissonClient对象
        return Redisson.create(config);
    }

    @Bean
    public RedissonClient redissonClient3(){
        // 配置
        Config config = new Config();
        config.useSingleServer().setAddress("redis://192.168.1.150:6381");

        // 创建RedissonClient对象
        return Redisson.create(config);
    }*/
}
