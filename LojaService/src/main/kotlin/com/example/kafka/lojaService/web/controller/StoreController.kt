package com.example.kafka.lojaService.web.controller

import com.example.kafka.lojaService.domain.service.StoreService
import com.example.kafka.lojaService.web.controller.assembler.convertToDto
import com.example.kafka.lojaService.web.controller.assembler.convertToEntity
import com.example.kafka.lojaService.web.controller.dto.StoreDto
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
class StoreController(var storeService: StoreService) {

    @GetMapping("/store/{id}")
    fun findStoreById(@PathVariable("id") id: String): ResponseEntity<StoreDto> {
        try {
            return ResponseEntity.ok(storeService.findStoreById(id).convertToDto())
        } catch (ex: NoSuchElementException) {
            return ResponseEntity.notFound().build()
        }
    }

    @PostMapping("/store")
    fun createStore(@RequestBody store: StoreDto): ResponseEntity<StoreDto>{
        return ResponseEntity.ok(storeService.createStore(store.convertToEntity()).convertToDto())
    }

    @PutMapping("/store/{id}")
    fun createStore(@PathVariable("id") id: String,
        @RequestBody store: StoreDto): ResponseEntity<StoreDto>{
        return ResponseEntity.ok(storeService.updateStore(id,store.convertToEntity()).convertToDto())
    }
}