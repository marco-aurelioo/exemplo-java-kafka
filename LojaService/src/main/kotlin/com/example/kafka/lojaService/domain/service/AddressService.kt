package com.example.kafka.lojaService.domain.service

import com.example.kafka.lojaService.domain.entity.AddressEntity
import com.example.kafka.lojaService.resources.repository.AddressRepository
import com.example.kafka.lojaService.resources.repository.StoreRepository
import org.springframework.stereotype.Service

@Service
class AddressService(
    var storeRepository: StoreRepository,
    var addressRepository: AddressRepository) {

    fun findDistributionCenterByStore(id: String): Array<AddressEntity> {
        var storeEntity = storeRepository.findById(id).get()
        return storeEntity.distributionCenter.toTypedArray()
    }

    fun createDistributionCenterByStore(id: String, address: AddressEntity): AddressEntity {
        var storeEntity = storeRepository.findById(id).get()
        if(!storeEntity.distributionCenter.contains(address))
            storeEntity.distributionCenter.add(address)
        storeRepository.save(storeEntity)
        return address
    }

}