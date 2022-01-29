package com.example.kafka.lojaService.web.controller.assembler

import com.example.kafka.lojaService.domain.entity.AddressEntity
import com.example.kafka.lojaService.domain.entity.StoreEntity
import com.example.kafka.lojaService.web.controller.dto.AddressDto
import com.example.kafka.lojaService.web.controller.dto.StoreDto

fun AddressEntity.convertToDto(): AddressDto {
    return AddressDto(
        this.id,
        this.zipCode,
        this.street,
        this.neighbors,
        this.city,
        this.stateUf,
        this.number,
        this.latitude,
        this.longitude
    )
}

fun AddressDto.convertToEntity(): AddressEntity{
    return AddressEntity(
        this.id,
        this.zipCode,
        this.street,
        this.neighbors,
        this.city,
        this.stateUf,
        this.number,
        this.latitude,
        this.longitude
    )
}

fun StoreEntity.convertToDto(): StoreDto{
    return StoreDto(
        this.id,
        this.name,
        this.doc
    )
}

fun StoreDto.convertToEntity(): StoreEntity{
    return StoreEntity(
        this.id,
        this.name,
        this.doc,
        mutableListOf()
    )
}

fun Array<AddressEntity>.convertToDto(): Array<AddressDto> {
    return this.toList().map { it.convertToDto() }.toTypedArray()
}