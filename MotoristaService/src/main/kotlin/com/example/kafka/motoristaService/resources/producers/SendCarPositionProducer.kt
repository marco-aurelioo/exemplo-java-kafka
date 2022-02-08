package com.example.kafka.motoristaService.resources.producers

import com.example.kafka.motoristaService.domain.entity.CarEntity
import com.example.kafka.motoristaService.resources.assembler.convertToJson
import com.example.kafka.motoristaService.web.controllers.dto.CarPosition
import com.example.kafka.motoristaService.web.controllers.dto.PositionDto
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.kafka.support.SendResult
import org.springframework.stereotype.Service
import org.springframework.util.concurrent.ListenableFutureCallback

import org.springframework.util.concurrent.ListenableFuture



@Service
class SendCarPositionProducer(var kafkaTemplate: KafkaTemplate<String, String> ) {

    var topicName = "car-position"

    fun sendMessage(message: CarPosition) {
        kafkaTemplate.send(topicName,message.convertToJson())
    }
}