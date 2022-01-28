package com.example.kafka.motoristaService.resources.repository

import com.example.kafka.motoristaService.domain.entity.DriverEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface DriverRepository : JpaRepository<DriverEntity, String> {
}