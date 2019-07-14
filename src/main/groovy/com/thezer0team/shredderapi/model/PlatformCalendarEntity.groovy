package com.thezer0team.shredderapi.model

import javax.persistence.*

@Entity
@Table(name = "platform_calendar")
class PlatformCalendarEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = 'platform_calendar_id')
    BigInteger platformCalendarId

    @Column(name = 'source_type')
    String sourceType

    @Column(name = 'application_calendar_id')
    BigInteger applicationCalendarId

    @Column(name = 'name')
    String name
}
