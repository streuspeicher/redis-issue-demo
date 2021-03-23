package com.example.redisissuedemo

import org.springframework.data.redis.core.RedisTemplate
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import java.time.Instant
import javax.transaction.Transactional

@RestController
class DemoController(
    private val redisTemplate: RedisTemplate<String, String>
) {

    @GetMapping("/")
    @Transactional
    fun root(): String {

        val value = Instant.now().toString()

        try {
            redisTemplate.opsForValue().set("Value", value)
            return value
        } catch (err: Throwable) {
            return err.stackTraceToString()
        }
    }
}