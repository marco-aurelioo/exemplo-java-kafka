package com.example.kafka.motoristaService.resources.listeners

import com.example.kafka.motoristaService.resources.assembler.convertToCarEntity
import com.example.kafka.motoristaService.resources.repository.CarRepository
import org.slf4j.LoggerFactory
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.messaging.handler.annotation.Payload
import org.springframework.stereotype.Service

@Service
class CarPositionListener(var repository: CarRepository) {

    var log = LoggerFactory.getLogger(this::class.java)

    @KafkaListener(topics = arrayOf("car-position"))
    fun readCarPosition(@Payload msg: String){
        log.info("atualizando posicao: $msg" )
        var carEntity = msg.convertToCarEntity()
        repository.save(carEntity)
    }

}