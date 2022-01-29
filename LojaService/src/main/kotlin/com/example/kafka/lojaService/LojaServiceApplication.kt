package com.example.kafka.lojaService

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
open class LojaServiceApplication

fun main(args: Array<String>) {
	runApplication<LojaServiceApplication>(*args)
}
