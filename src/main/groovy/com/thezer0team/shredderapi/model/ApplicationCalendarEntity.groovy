package com.thezer0team.shredderapi.model

import com.amazonaws.services.dynamodbv2.datamodeling.*

@DynamoDBTable(tableName = "applicationCalendar")
class ApplicationCalendarEntity {

    @DynamoDBHashKey
    @DynamoDBAutoGeneratedKey
    String calendarId

    @DynamoDBAttribute
    BigInteger applicationCalendarId

    @DynamoDBAttribute
    String name

    List<ApplicationCalendarEventEntity> events
}
