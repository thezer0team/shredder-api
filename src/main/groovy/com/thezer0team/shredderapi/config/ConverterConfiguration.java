package com.thezer0team.shredderapi.config;

import org.springframework.cloud.gcp.data.datastore.core.convert.DatastoreCustomConversions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

import static com.thezer0team.shredderapi.model.converter.CalendarConverters.*;

@Configuration
public class ConverterConfiguration {

    @Bean
    public DatastoreCustomConversions datastoreCustomConversions() {
        return new DatastoreCustomConversions(
                Arrays.asList(
                        LIST_IMMUTABLE_SET_CONVERTER,
                        APPLICATION_CALENDAR_ENTITY_STRING_CONVERTER,
                        STRING_APPLICATION_CALENDAR_ENTITY_CONVERTER,
                        PLATFORM_CALENDAR_ENTITY_STRING_CONVERTER,
                        STRING_PLATFORM_CALENDAR_ENTITY_CONVERTER));
    }
}
