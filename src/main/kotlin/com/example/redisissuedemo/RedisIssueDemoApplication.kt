package com.example.redisissuedemo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.data.redis.connection.RedisConnectionFactory
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory
import org.springframework.data.redis.core.RedisTemplate
import org.springframework.data.redis.serializer.StringRedisSerializer

@SpringBootApplication
class RedisIssueDemoApplication {

    @Bean
    fun redisConnectionFactory() = LettuceConnectionFactory()

    @Bean
    fun redisTemplate(redisConnectionFactory: RedisConnectionFactory) = RedisTemplate<String, String>().apply {
		setConnectionFactory(redisConnectionFactory)
		setEnableTransactionSupport(true)
        afterPropertiesSet()
    }
}

fun main(args: Array<String>) {
    runApplication<RedisIssueDemoApplication>(*args)
}
