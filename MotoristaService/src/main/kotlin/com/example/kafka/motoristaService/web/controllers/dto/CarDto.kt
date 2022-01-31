package com.example.kafka.motoristaService.web.controllers.dto

data class CarDto(
    var id: String,
    var licensePlate: String,
    var position: PositionDto
)