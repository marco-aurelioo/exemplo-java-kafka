package com.example.kafka.motoristaService.resources.listeners

import org.springframework.kafka.core.KafkaTemplate
import org.springframework.kafka.support.SendResult
import org.springframework.stereotype.Service
import org.springframework.util.concurrent.ListenableFutureCallback

import org.springframework.util.concurrent.ListenableFuture



@Service
class SendCarPositionProducer(var kafkaTemplate: KafkaTemplate<String, String> ) {

    var topicName = "car-position"

    fun sendMessage(message: String) {
        kafkaTemplate.send(topicName,message)
    }
}