package com.lingye.demo.config

import com.google.common.cache.Cache
import com.google.common.cache.CacheBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.util.concurrent.TimeUnit

@Configuration
class CacheConfig {

    @Bean
    fun myCache(): Cache<String, Any> =
        CacheBuilder.newBuilder()
            .expireAfterWrite(1, TimeUnit.MINUTES)
            .maximumSize(100)
            .build();
}