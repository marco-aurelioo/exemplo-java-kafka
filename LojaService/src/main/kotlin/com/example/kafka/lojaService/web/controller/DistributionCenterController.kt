package com.example.kafka.lojaService.web.controller

import com.example.kafka.lojaService.domain.entity.AddressEntity
import com.example.kafka.lojaService.domain.service.AddressService
import com.example.kafka.lojaService.web.controller.assembler.convertToDto
import com.example.kafka.lojaService.web.controller.assembler.convertToEntity
import com.example.kafka.lojaService.web.controller.dto.AddressDto
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
class DistributionCenterController(var addressService: AddressService) {


    @GetMapping("/store/{id}/distribution-center")
    fun findDistributionCenterByStore(@PathVariable("id") id: String): ResponseEntity<Array<AddressDto>> {
        return ResponseEntity.ok(addressService.findDistributionCenterByStore(id).convertToDto())
    }


    @PostMapping("/store/{id}/distribution-center")
    fun createDistributionCenterByStore(@PathVariable("id") id: String,@RequestBody address: AddressDto): ResponseEntity<AddressDto> {
        return ResponseEntity.ok(addressService.createDistributionCenterByStore(id,address.convertToEntity()).convertToDto())
    }

}