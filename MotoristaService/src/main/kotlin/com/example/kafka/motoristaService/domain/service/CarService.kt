package com.example.kafka.motoristaService.domain.service

import com.example.kafka.motoristaService.domain.entity.CarEntity
import com.example.kafka.motoristaService.resources.producers.SendCarPositionProducer
import com.example.kafka.motoristaService.resources.repository.CarRepository
import com.example.kafka.motoristaService.resources.repository.DriverRepository
import com.example.kafka.motoristaService.web.controllers.dto.PositionDto
import org.springframework.stereotype.Service

@Service
class CarService(
    var carRepository: CarRepository,
    var driverRepository: DriverRepository
) {

    fun findCarPositionByCarId(id: String): CarEntity {
        return carRepository.findById(id).get()
    }

    fun findCarPositionByDriver(driver: String): CarEntity {
        return driverRepository.findById(driver).get().car
    }
    
    fun setCarPosition(id: String, latitude: Double, longitude: Double){
        val carEntity =  carRepository.findById(id).get
        carEntity.longitude = longitude
        carEntity.latitude = latitude
        carRepository.save(carEntity)
    }

}