package com.example.kafka.MotoristaService.domain.entity

import javax.persistence.Entity
import javax.persistence.Id

@Entity
data class CarEntity (
    @Id
    var id: String,
    var licensePlate: String,
    var latitude: Double,
    var longitude: Double
        )