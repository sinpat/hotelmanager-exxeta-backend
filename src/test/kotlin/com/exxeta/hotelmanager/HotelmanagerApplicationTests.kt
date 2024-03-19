package com.exxeta.hotelmanager

import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get

@SpringBootTest
class HotelmanagerApplicationTests {
    @Test fun contextLoads() {}
}

//
// @WebMvcTest
// cla s RoomControllerTest(@Autowired val mockMvc: MockMvc) {
//     @MockkBean lateinit var roomRepository: RoomRepository
//
//     @Test
//     fun `List rooms`() {
        // val room101 = Room(101, RoomType.SINGLE, false)
        // val room102 = Room(102, RoomType.DOUBLE, true)
        // every { roomRepository.findAll() } returns listOf(room101, room102)
        // mockMvc.perform(get("/room/all").accept(MediaType.APPLICATION_JSON))
        //         .andExpect(status().isOk)
        // .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        // .andExpect(jsonPath("\$.[0].roomNumber").value(room101.roomNumber))
        // .andExpect(jsonPath("\$.[0].roomType").value(room101.roomType))
        // .andExpect(jsonPath("\$.[0].hasMinibar").value(room101.hasMinibar))
        // .andExpect(jsonPath("\$.[0].bookings").value(emptyList<Booking>()))
        // .andExpect(jsonPath("\$.[0].currentBooking").doesNotExist())
        // .andExpect(jsonPath("\$.[0].isVacant").value(true))
//      // .andExpect(jsonPath("\$.[1].roomNumber").value(room102.roomNumber))
//     }
// }
