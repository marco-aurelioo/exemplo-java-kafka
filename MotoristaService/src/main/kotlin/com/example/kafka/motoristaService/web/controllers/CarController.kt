package com.example.kafka.motoristaService.web.controllers

import com.example.kafka.motoristaService.domain.service.CarService
import com.example.kafka.motoristaService.web.controllers.assembler.convertToDto
import com.example.kafka.motoristaService.web.controllers.dto.CarDto
import com.example.kafka.motoristaService.web.controllers.dto.PositionDto
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

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

    @PostMapping("/car/{id}/position")
    fun createCarPositionByDriver(
        @PathVariable("id") id: String,
        @RequestBody position: PositionDto):ResponseEntity<String>{
        carService.setCarPosition(id, position.latitude, position.longitude)
        return ResponseEntity(HttpStatus.CREATED)
    }

}