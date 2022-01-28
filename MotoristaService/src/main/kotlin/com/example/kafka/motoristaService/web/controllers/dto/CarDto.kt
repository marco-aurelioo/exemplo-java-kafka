package com.example.kafka.motoristaService.web.controllers.dto

data class CarDto(
    var id: String,
    var licensePlate: String,
    var latitude: Double,
    var longitude: Double
)