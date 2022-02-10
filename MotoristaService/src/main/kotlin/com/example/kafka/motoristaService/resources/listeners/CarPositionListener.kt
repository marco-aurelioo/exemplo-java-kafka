package com.example.kafka.motoristaService.resources.listeners

import com.example.kafka.motoristaService.domain.service.CarService
import com.example.kafka.motoristaService.resources.assembler.convertToCarPositionDto
import org.slf4j.LoggerFactory
import org.springframework.data.redis.core.RedisTemplate
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.messaging.handler.annotation.Payload
import org.springframework.stereotype.Service
import java.time.Duration

@Service
class CarPositionListener(var carService: CarService,
var redisTemplate: RedisTemplate<String,String>
) {

    var log = LoggerFactory.getLogger(this::class.java)

    @KafkaListener(topics = arrayOf("car-position"))
    fun readCarPosition(@Payload msg: String) {
        val carPosition = msg.convertToCarPositionDto()
        if (readCache(carPosition.id)) {
            log.info("atualizando posicao: $msg")
            carService.setCarPosition(carPosition.id, carPosition.latitude, carPosition.longitude)
            setToCache(carPosition.id)
        }else{
            log.info("descarta atualizacao: $msg")
        }
    }

    private fun readCache(id: String): Boolean{
        return redisTemplate.opsForValue().get(id).isNullOrBlank()
    }

    private fun setToCache(id: String){
        redisTemplate.opsForValue().set(id,id, Duration.ofSeconds(5))
    }

}