package com.example.kafka.MotoristaService.resources.repository

import com.example.kafka.MotoristaService.domain.entity.DriverEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface DriverRepository: JpaRepository<DriverEntity,String> {
}