package com.exxeta.hotelmanager

import com.fasterxml.jackson.annotation.JsonBackReference
import jakarta.persistence.CascadeType
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.FetchType
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.OneToMany
import jakarta.persistence.Temporal
import jakarta.persistence.TemporalType
import java.time.LocalDate
import java.util.UUID

enum class RoomType {
    SINGLE,
    DOUBLE,
    SUITE
}

@Entity
class Room(
        @Id val roomNumber: Long,
        @Enumerated(EnumType.STRING) @Column(nullable = false) val roomType: RoomType,
        val hasMinibar: Boolean,
        @OneToMany(mappedBy = "room", cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
        val bookings: List<Booking> = emptyList()
)

@Entity
class Booking(
        @Id @GeneratedValue(strategy = GenerationType.UUID) val bookingReference: UUID,
        @Column(nullable = false) val guestName: String,
        @Column(nullable = false) @Temporal(TemporalType.DATE) val startDate: LocalDate,
        @Column(nullable = false) @Temporal(TemporalType.DATE) val endDate: LocalDate,
        @ManyToOne @JoinColumn(name = "roomNumber") @JsonBackReference val room: Room,
)
