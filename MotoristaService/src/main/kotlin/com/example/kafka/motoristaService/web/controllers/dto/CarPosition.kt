package com.example.kafka.motoristaService.web.controllers.dto

import com.fasterxml.jackson.annotation.JsonProperty

data class CarPosition(
    @JsonProperty("id")
    var id: String,
    @JsonProperty("latitude")
    var latitude: Double,
    @JsonProperty("longitude")
   var longitude: Double
)