package com.thezer0team.shredderapi.model

import javax.persistence.*

@Entity
@Table(name = "user")
class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = 'user_id')
    BigInteger userId

    @Column(name = 'user_name')
    String userName

    @Column(name = 'user_email')
    String userEmail

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    ApplicationCalendarEntity applicationCalendar
}
