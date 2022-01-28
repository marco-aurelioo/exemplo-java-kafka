package com.example.kafka.MotoristaService.web.controllers

import com.example.kafka.MotoristaService.domain.entity.DriverEntity
import com.example.kafka.MotoristaService.domain.service.DriverService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.websocket.server.PathParam

@RestController
class DriverController(var driverService: DriverService) {

    @GetMapping("/driver/{id}")
    fun findDriverById(@PathParam("id") id: String): ResponseEntity<DriverEntity> {
        return ResponseEntity.ok(driverService.findDriverById(id))
    }

    @PostMapping("/driver")
    fun createDriver(@RequestBody driver: DriverEntity): ResponseEntity<DriverEntity> {
        return ResponseEntity.ok(driverService.createDriver(driver))
    }

    @PutMapping("/driver/{id}")
    fun updateDriver(
        @PathParam("id") id: String,
        @RequestBody driver: DriverEntity): ResponseEntity<DriverEntity> {
        return ResponseEntity.ok(driverService.updateDriver(id,driver))
    }
}