package com.example.kafka.motoristaService.resources.repository

import com.example.kafka.motoristaService.domain.entity.CarEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CarRepository : JpaRepository<CarEntity, String> {

}