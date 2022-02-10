package com.example.kafka.motoristaService.resources.repository

import com.example.kafka.motoristaService.domain.entity.CarEntity
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository


@Repository
interface CarRepository : JpaRepository<CarEntity, String> {

    @Query("select car from CarEntity car where " +
            " car.latitude < (:latitude + :distance) AND car.latitude > (:latitude - :distance) AND " +
            " car.longitude < (:longitude + :distance) AND car.longitude > (:longitude - :distance) ")
    fun findCarPositionReferencePosition(
        @Param("latitude") latitude: Double,
        @Param("longitude") longitude: Double,
        @Param("distance") distance: Double) : List<CarEntity>

}