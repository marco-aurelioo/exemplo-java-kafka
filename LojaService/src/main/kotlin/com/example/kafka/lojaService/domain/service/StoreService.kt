package com.example.kafka.lojaService.domain.service

import com.example.kafka.lojaService.domain.entity.StoreEntity
import com.example.kafka.lojaService.resources.repository.StoreRepository
import org.springframework.beans.BeanUtils
import org.springframework.stereotype.Service

@Service
class StoreService(var storeRepository: StoreRepository) {

    fun findStoreById(id: String): StoreEntity {
        return storeRepository.findById(id).get()
    }

    fun createStore(storeEntity: StoreEntity): StoreEntity {
        return storeRepository.save(storeEntity)
    }

    fun updateStore(id: String, storeEntity: StoreEntity): StoreEntity {
        var old = storeRepository.findById(id).get()
        BeanUtils.copyProperties(old,storeEntity)
        return storeRepository.save(old)
    }
}