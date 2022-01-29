package com.example.kafka.motoristaService.web.controllers

import com.example.kafka.motoristaService.domain.service.DriverService
import com.example.kafka.motoristaService.web.controllers.assembler.convertToDto
import com.example.kafka.motoristaService.web.controllers.assembler.convertToEntity
import com.example.kafka.motoristaService.web.controllers.dto.DriverDto
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
class DriverController(var driverService: DriverService) {

    @GetMapping("/driver/{id}")
    fun findDriverById(@PathVariable("id") id: String): ResponseEntity<DriverDto> {
        return ResponseEntity.ok(driverService.findDriverById(id).convertToDto())
    }

    @PostMapping("/driver")
    fun createDriver(@RequestBody driver: DriverDto): ResponseEntity<DriverDto> {
        return ResponseEntity.ok(driverService.createDriver(driver.convertToEntity()).convertToDto())
    }

    @PutMapping("/driver/{id}")
    fun updateDriver(
        @PathVariable("id") id: String,
        @RequestBody driver: DriverDto
    ): ResponseEntity<DriverDto> {
        return ResponseEntity.ok(driverService.updateDriver(id, driver.convertToEntity()).convertToDto())
    }

}