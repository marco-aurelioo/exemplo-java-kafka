package com.example.kafka.MotoristaService.domain.service

import com.example.kafka.MotoristaService.domain.entity.DriverEntity
import com.example.kafka.MotoristaService.resources.repository.DriverRepository
import org.springframework.beans.BeanUtils
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional(readOnly = true)
class DriverService(var driverRepository: DriverRepository) {

    fun findDriverById( id: String): DriverEntity {
        return driverRepository.findById(id).get()
    }

    @Transactional
    fun createDriver(driver: DriverEntity): DriverEntity? {
        return driverRepository.save(driver)
    }

    @Transactional
    fun updateDriver(id: String, driver: DriverEntity): DriverEntity? {
        var old = driverRepository.findById(id).get()
        BeanUtils.copyProperties(driver,old)
        old = driverRepository.save(old);
        return old;
    }

}