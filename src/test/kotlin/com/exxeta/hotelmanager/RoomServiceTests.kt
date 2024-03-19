package com.exxeta.hotelmanager

import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class RoomServiceTests {
    val roomRepository = mockk<RoomRepository>()
    val roomService = RoomService(roomRepository)

    @Test
    fun `when filter is empty, then return all rooms`() {
        val room101 = Room(101, RoomType.SINGLE, false)
        val room102 = Room(102, RoomType.DOUBLE, true)
        every { roomRepository.findAll() } returns listOf(room101, room102)
        val rooms = roomService.getRooms(RoomFilter(null, null, null))

        assertEquals(2, rooms.size)
        assertEquals(RoomDTO(room101), rooms[0])
        assertEquals(RoomDTO(room102), rooms[1])
    }

    @Test
    fun `when filter is not empty, then return filtered rooms`() {
        val room101 = Room(101, RoomType.SINGLE, false)
        val room102 = Room(102, RoomType.DOUBLE, true)
        every { roomRepository.findAll() } returns listOf(room101, room102)

        val singleRooms = roomService.getRooms(RoomFilter(RoomType.SINGLE, null, null))
        assertEquals(1, singleRooms.size)
        assertEquals(RoomDTO(room101), singleRooms[0])

        val singleRoomsWithMinibar = roomService.getRooms(RoomFilter(RoomType.SINGLE, true, null))
        assertEquals(0, singleRoomsWithMinibar.size)
    }
}
