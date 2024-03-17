package com.exxeta.hotelmanager

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.Id

enum class RoomType {
    SINGLE,
    DOUBLE,
    SUITE
}

@Entity
class Room(
        @Id val roomNumber: Long,
        @Enumerated(EnumType.STRING) @Column(nullable = false) val roomType: RoomType,
        val hasMinibar: Boolean
)
