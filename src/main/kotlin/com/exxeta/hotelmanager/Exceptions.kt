package com.exxeta.hotelmanager

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice

class RoomNotFoundException(val id: Long) : RuntimeException("Room with id $id not found")

@RestControllerAdvice
class RoomNotFoundAdvice {
    @ExceptionHandler(RoomNotFoundException::class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    fun roomNotFoundHandler(ex: RoomNotFoundException): String {
        return ex.message!!
    }
}
