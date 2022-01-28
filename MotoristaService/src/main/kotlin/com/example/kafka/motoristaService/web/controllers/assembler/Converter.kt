package com.example.kafka.motoristaService.web.controllers.assembler

import com.example.kafka.motoristaService.domain.entity.CarEntity
import com.example.kafka.motoristaService.domain.entity.DriverEntity
import com.example.kafka.motoristaService.web.controllers.dto.CarDto
import com.example.kafka.motoristaService.web.controllers.dto.DriverDto


fun DriverDto.convertToEntity(): DriverEntity {
    return DriverEntity(
        this.id,
        this.name,
        this.age,
        this.picture,
        CarEntity(
            this.car.id,
            this.car.licensePlate,
            this.car.latitude,
            this.car.longitude
        )
    )
}

fun DriverEntity.convertToDto(): DriverDto {
    return DriverDto(
        this.id,
        this.name,
        this.age,
        this.picture,
        CarDto(
            this.car.id,
            this.car.licensePlate,
            this.car.latitude,
            this.car.longitude
        )
    )
}

fun CarEntity.convertToDto(): CarDto {
    return CarDto(
        this.id,
        this.licensePlate,
        this.latitude,
        this.longitude
    )
}