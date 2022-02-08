package com.example.kafka.motoristaService.resources.config

import org.springframework.context.annotation.Configuration
import com.fasterxml.jackson.databind.ObjectMapper

import com.fasterxml.jackson.annotation.JsonAutoDetect
import com.fasterxml.jackson.annotation.PropertyAccessor
import org.springframework.context.annotation.Bean
import org.springframework.data.redis.connection.RedisConnectionFactory
import org.springframework.data.redis.core.RedisTemplate
import org.springframework.data.redis.core.StringRedisTemplate
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer


@Configuration
class RedisConfig {

    @Bean
    fun redisTemplate(factory: RedisConnectionFactory): RedisTemplate<String, String> {
        val om = ObjectMapper()
        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY)
        om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL)
        // redis serialize
        val jackson2JsonRedisSerializer = Jackson2JsonRedisSerializer(Any::class.java)
        jackson2JsonRedisSerializer.setObjectMapper(om)
        val template = StringRedisTemplate(factory)
        template.setValueSerializer(jackson2JsonRedisSerializer)
        template.setHashKeySerializer(jackson2JsonRedisSerializer)
        template.setHashValueSerializer(jackson2JsonRedisSerializer)
        template.setValueSerializer(jackson2JsonRedisSerializer)
        template.afterPropertiesSet()
        return template
    }

}