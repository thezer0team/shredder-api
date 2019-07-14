package com.thezer0team.shredderapi.model

import javax.persistence.*

@Entity
@Table(name = "calendar_event")
class ApplicationCalendarEventEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = 'event_id')
    BigInteger eventId

    @Column(name = 'native_event_id')
    String nativeEventId

    @ManyToMany
    @JoinTable(
            name = "calendar_events",
            joinColumns = @JoinColumn(name = "event_id"),
            inverseJoinColumns = @JoinColumn(name = "calendar_id"))
    Set<ApplicationCalendarEntity> calendars
}
