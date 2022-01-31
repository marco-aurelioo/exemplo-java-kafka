package com.example.kafka.motoristaService.web.controllers

import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler
import org.springframework.http.ResponseEntity

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.WebRequest
import java.lang.Exception


@ControllerAdvice
class HandlerController: ResponseEntityExceptionHandler() {

    @ExceptionHandler(value = [(NoSuchElementException::class)])
    fun handleUserAlreadyExists(ex: NoSuchElementException,request: WebRequest): ResponseEntity<String> {
        return ResponseEntity.notFound().build()
    }

}