package com.example.kafka.lojaService.web.controller.dto

data class AddressDto (
    var id: String,
    var zipCode: String,
    var street: String,
    var neighbors: String,
    var city: String,
    var stateUf: String,
    var number: String,
    var latitude: Double,
    var longitude: Double
        )