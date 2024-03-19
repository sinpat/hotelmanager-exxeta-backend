package com.exxeta.hotelmanager

import java.time.LocalDate
import java.util.UUID
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get

class RoomDTOTests {
    @Test
    fun `currentBooking is null when there are no bookings`() {
        val room = Room(101, RoomType.SINGLE, false)
        val roomDTO = RoomDTO(room)
        assertEquals(null, roomDTO.currentBooking)
    }

    @Test
    fun `currentBooking is null when all bookings are in the past`() {
        val room =
                Room(
                        101,
                        RoomType.SINGLE,
                        false,
                        listOf(
                                Booking(
                                        UUID.randomUUID(),
                                        "John Doe",
                                        LocalDate.of(2020, 1, 1),
                                        LocalDate.of(2020, 1, 2),
                                )
                        )
                )
        val roomDTO = RoomDTO(room)
        assertEquals(null, roomDTO.currentBooking)
    }
    @Test
    fun `currentBooking is not null when there is a booking right now`() {
        val room =
                Room(
                        101,
                        RoomType.SINGLE,
                        false,
                        listOf(
                                Booking(
                                        UUID.randomUUID(),
                                        "John Doe",
                                        LocalDate.now(),
                                        LocalDate.now().plusDays(7),
                                )
                        )
                )
        val roomDTO = RoomDTO(room)
        assertEquals("John Doe", roomDTO.currentBooking?.guestName)
    }
}
