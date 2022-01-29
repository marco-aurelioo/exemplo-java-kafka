package com.example.kafka.lojaService.resources.repository

import com.example.kafka.lojaService.domain.entity.AddressEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface AddressRepository: JpaRepository<AddressEntity,String> {
}