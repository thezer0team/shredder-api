package com.thezer0team.shredderapi.model


import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.Table
import java.time.Instant

@Entity
@Table(name = "platform_event")
class PlatformEventEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = 'platform_event_id')
    BigInteger platformCalendarId

    @ManyToOne
    @JoinColumn(name = 'platform_calendar_id', nullable = false)
    PlatformCalendarEntity platformCalendar

    @Column(name = 'name')
    String name

    @Column(name = 'description')
    String description

    @Column(name = 'start_time')
    Instant startTime

    @Column(name = 'end_time')
    Instant endTime

    @Column(name = 'location')//TODO research location objects
    String location
}
