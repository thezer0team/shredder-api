package com.thezer0team.shredderapi.dto.converter

import com.google.common.collect.ImmutableSet
import com.thezer0team.shredderapi.model.ApplicationCalendarEntity
import com.thezer0team.shredderapi.model.PlatformCalendarEntity
import groovy.json.JsonOutput
import groovy.json.JsonSlurper
import org.springframework.core.convert.converter.Converter

class CalendarConverters {
    public static final Converter<List<?>, ImmutableSet<?>> LIST_IMMUTABLE_SET_CONVERTER =
            new Converter<List<?>, ImmutableSet<?>>() {
                @Override
                ImmutableSet<?> convert(List<?> source) {
                    return ImmutableSet.copyOf(source)
                }
            }

    public static final Converter<PlatformCalendarEntity, String> PLATFORM_CALENDAR_ENTITY_STRING_CONVERTER =
            new Converter<PlatformCalendarEntity, String>() {
                @Override
                String convert(PlatformCalendarEntity platformCalendarEntity) {
                    return JsonOutput.toJson(platformCalendarEntity)
                }
            }

    public static final Converter<String, PlatformCalendarEntity> STRING_PLATFORM_CALENDAR_ENTITY_CONVERTER =
            new Converter<String, PlatformCalendarEntity>() {
                @Override
                PlatformCalendarEntity convert(String string) {
                    return new JsonSlurper().parseText(string) as PlatformCalendarEntity
                }
            }

    public static final Converter<ApplicationCalendarEntity, String> APPLICATION_CALENDAR_ENTITY_STRING_CONVERTER =
            new Converter<ApplicationCalendarEntity, String>() {
                @Override
                String convert(ApplicationCalendarEntity applicationCalendarEntity) {
                    return JsonOutput.toJson(applicationCalendarEntity)
                }
            }

    public static final Converter<String, ApplicationCalendarEntity> STRING_APPLICATION_CALENDAR_ENTITY_CONVERTER =
            new Converter<String, ApplicationCalendarEntity>() {
                @Override
                ApplicationCalendarEntity convert(String string) {
                    return new JsonSlurper().parseText(string) as ApplicationCalendarEntity
                }
            }

}
