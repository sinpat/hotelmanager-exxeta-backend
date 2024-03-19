package com.exxeta.hotelmanager

import org.springframework.stereotype.Service

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

    fun getRooms(roomType: RoomType?, hasMinibar: Boolean?): List<RoomDTO> {
        return roomRepository
                .findAll()
                .filter { room ->
                    (roomType == null || room.roomType == roomType) &&
                            (hasMinibar == null || room.hasMinibar == hasMinibar)
                }
                .map { RoomDTO(it) }
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
