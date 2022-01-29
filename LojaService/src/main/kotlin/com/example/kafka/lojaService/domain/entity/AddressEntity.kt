package com.example.kafka.lojaService.domain.entity

import javax.persistence.Entity
import javax.persistence.Id

@Entity
data class AddressEntity(
    @Id
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