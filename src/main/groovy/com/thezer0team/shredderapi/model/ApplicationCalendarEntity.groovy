package com.thezer0team.shredderapi.model

import javax.persistence.*

@Entity
@Table(name = "application_calendar")
class ApplicationCalendarEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = 'calendar_id')
    BigInteger calendarId

    @OneToOne
    @MapsId
    UserEntity user

    @Column(name = 'application_calendar_id')
    BigInteger applicationCalendarId

    @Column(name = 'name')
    String name

    @ManyToMany
    @JoinTable(
            name = "calendar_events",
            joinColumns = @JoinColumn(name = "calendar_id"),
            inverseJoinColumns = @JoinColumn(name = "event_id"))
    Set<ApplicationCalendarEventEntity> events
}
