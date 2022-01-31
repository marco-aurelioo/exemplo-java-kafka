package com.example.kafka.motoristaService

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.kafka.annotation.EnableKafka

@EnableKafka
@SpringBootApplication
open class DriverServiceApplication

fun main(args: Array<String>) {
    runApplication<DriverServiceApplication>(*args)
}
