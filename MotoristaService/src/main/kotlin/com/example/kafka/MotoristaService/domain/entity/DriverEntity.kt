package com.example.kafka.MotoristaService.domain.entity

import javax.persistence.*

@Entity
data class DriverEntity (
    @Id
    var id: String,
    var name: String,
    var age: Int,
    var picture: String,
    @OneToOne(cascade = arrayOf(CascadeType.ALL))
    @JoinColumn(name = "car_id", referencedColumnName = "id")
    var car: CarEntity
        )