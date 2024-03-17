package com.exxeta.hotelmanager

import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/room")
class RoomController(private val roomService: RoomService) {

    @GetMapping("/all")
    fun getRooms(
            @RequestParam(required = false) roomType: RoomType?,
            @RequestParam(required = false) hasMinibar: Boolean?,
    ): List<Room> {
        return roomService.getRooms(roomType, hasMinibar)
    }

    @GetMapping("/{id}")
    fun getRoom(@PathVariable id: Long): Room {
        return roomService.getRoom(id)
    }

    @PostMapping("")
    fun addRoom(@RequestBody room: Room): Room {
        return roomService.addRoom(room)
    }

    @PutMapping("/{id}")
    fun updateRoom(@PathVariable id: Long, @RequestBody room: Room): Room {
        return roomService.updateRoom(id, room)
    }

    @DeleteMapping("/{id}")
    fun deleteRoom(@PathVariable id: Long) {
        roomService.deleteRoom(id)
    }
}
