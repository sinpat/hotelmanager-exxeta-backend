package com.exxeta.hotelmanager

import org.springframework.hateoas.EntityModel
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*
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
            @RequestParam(required = false) isVacant: Boolean?
    ): List<RoomDTO> {
        return roomService.getRooms(RoomFilter(roomType, hasMinibar, isVacant))
    }

    @GetMapping("/{id}")
    fun getRoom(@PathVariable id: Long): EntityModel<RoomDTO> {
        val entity =
                roomService
                        .getRoom(id)
                        .add(linkTo(methodOn(RoomController::class.java).getRoom(id)).withSelfRel())
        // .add(linkTo(methodOn(RoomController::class.java).deleteRoom(id)).withRel("delete"))

        return EntityModel.of(entity)
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
