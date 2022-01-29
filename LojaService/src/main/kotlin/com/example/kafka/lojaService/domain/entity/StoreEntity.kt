package com.example.kafka.lojaService.domain.entity

import javax.persistence.*

@Entity
data class StoreEntity(
    @Id
    var id: String,
    var name: String,
    var doc: String,
    @OneToMany(cascade = arrayOf(CascadeType.ALL), orphanRemoval = true)
    @OrderColumn
    var distributionCenter: MutableList<AddressEntity>
)