package com.exxeta.hotelmanager

import java.time.LocalDate

data class RoomDTO(
        val roomNumber: Long,
        val roomType: RoomType,
        val hasMinibar: Boolean,
        val bookings: List<Booking>,
        val currentBooking: Booking? =
                bookings.find {
                    !it.startDate.isAfter(LocalDate.now()) && !it.endDate.isBefore(LocalDate.now())
                },
        val vacant: Boolean = currentBooking == null
) {
    constructor(room: Room) : this(room.roomNumber, room.roomType, room.hasMinibar, room.bookings)
}
