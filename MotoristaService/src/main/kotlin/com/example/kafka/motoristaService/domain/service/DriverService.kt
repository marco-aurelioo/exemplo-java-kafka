package com.example.kafka.motoristaService.domain.service

import com.example.kafka.motoristaService.domain.entity.DriverEntity
import com.example.kafka.motoristaService.resources.repository.DriverRepository
import org.springframework.beans.BeanUtils
import org.springframework.stereotype.Service

@Service
class DriverService(var driverRepository: DriverRepository) {

    fun findDriverById(id: String): DriverEntity {
        return driverRepository.findById(id).get()
    }

    fun createDriver(driver: DriverEntity): DriverEntity {
        return driverRepository.save(driver)
    }

    fun updateDriver(id: String, driver: DriverEntity): DriverEntity {
        var old = driverRepository.findById(id).get()
        BeanUtils.copyProperties(driver, old)
        old = driverRepository.save(old);
        return old;
    }

}