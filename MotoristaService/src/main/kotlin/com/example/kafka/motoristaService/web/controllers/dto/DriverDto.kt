package com.example.kafka.motoristaService.web.controllers.dto

data class DriverDto(
    var id: String,
    var name: String,
    var age: Int,
    var picture: String,
    var car: CarDto
)