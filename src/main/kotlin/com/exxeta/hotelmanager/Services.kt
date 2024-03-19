package com.exxeta.hotelmanager

import org.springframework.stereotype.Service

data class RoomFilter(val roomType: RoomType?, val hasMinibar: Boolean?, val isVacant: Boolean?) {
    fun matches(room: RoomDTO): Boolean {
        return (roomType == null || room.roomType == roomType) &&
                (hasMinibar == null || room.hasMinibar == hasMinibar) &&
                (isVacant == null || room.isVacant == isVacant)
    }
}

class RoomNotFoundException : RuntimeException {
    constructor(id: Long)
}

// @ControllerAdvice
// class RoomNotFoundAdvice {
//     @ResponseBody
//     @ExceptionHandler(RoomNotFoundException::class)
//     @ResponseStatus(HttpStatus.NOT_FOUND)
//     fun roomNotFoundHandler(ex: RoomNotFoundException): String {
//         return ex.message!!
//     }
// }

@Service
class RoomService(private val roomRepository: RoomRepository) {

    fun getRooms(filter: RoomFilter): List<RoomDTO> {
        return roomRepository.findAll().map { RoomDTO(it) }.filter { filter.matches(it) }
    }

    fun getRoom(id: Long): RoomDTO {
        val room = roomRepository.findById(id).orElseThrow { throw RoomNotFoundException(id) }
        return RoomDTO(room)
    }

    fun addRoom(room: Room): Room {
        return roomRepository.save(room)
    }

    fun updateRoom(id: Long, room: Room): Room {
        if (roomRepository.existsById(id)) {
            return roomRepository.save(room)
        }
        throw RoomNotFoundException(id)
    }

    fun deleteRoom(id: Long) {
        if (roomRepository.existsById(id)) {
            roomRepository.deleteById(id)
        } else {
            throw RoomNotFoundException(id)
        }
    }
}
