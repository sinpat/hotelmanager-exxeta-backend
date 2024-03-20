package com.exxeta.hotelmanager

import java.time.LocalDate
import org.springframework.hateoas.RepresentationModel

data class RoomDTO(
        val roomNumber: Long,
        val roomType: RoomType,
        val hasMinibar: Boolean,
        val bookings: List<Booking>,
        val currentBooking: Booking? =
                bookings.find {
                    !it.startDate.isAfter(LocalDate.now()) && !it.endDate.isBefore(LocalDate.now())
                },
        val isVacant: Boolean = currentBooking == null
) : RepresentationModel<RoomDTO>() {
    constructor(room: Room) : this(room.roomNumber, room.roomType, room.hasMinibar, room.bookings)
}
