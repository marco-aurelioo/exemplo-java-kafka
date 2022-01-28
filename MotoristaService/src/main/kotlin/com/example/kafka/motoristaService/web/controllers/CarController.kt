package com.example.kafka.motoristaService.web.controllers

import com.example.kafka.motoristaService.domain.service.CarService
import com.example.kafka.motoristaService.web.controllers.assembler.convertToDto
import com.example.kafka.motoristaService.web.controllers.dto.CarDto
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class CarController(var carService: CarService) {

    @GetMapping("/car/{id}")
    fun findCarPosition(@PathVariable("id") id: String): ResponseEntity<CarDto> {
        return ResponseEntity.ok(carService.findCarPositionByCarId(id).convertToDto())
    }

    @GetMapping("/car")
    fun findCarPositionByDriver(@RequestParam("driver") driver: String): ResponseEntity<CarDto> {
        return ResponseEntity.ok(carService.findCarPositionByDriver(driver).convertToDto())
    }

}