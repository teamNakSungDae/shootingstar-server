package com.nexters.shootingstar.resources;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.dropwizard.jackson.Jackson;
import org.junit.Test;

import static io.dropwizard.testing.FixtureHelpers.fixture;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by kwongiho on 2017. 2. 11..
 */
public class PersonTest {
//    private static final ObjectMapper MAPPER = Jackson.newObjectMapper();
//
//    @Test
//    public void serializesToJSON() throws Exception {
//        final Person person = new Person( "asd@asd.asd","giho");
//
//        final String expected = MAPPER.writeValueAsString(
//                MAPPER.readValue("{\"email\":\"asd@asd.asd\",\"name\":\"giho\"}", Person.class));
//
//        assertThat(MAPPER.writeValueAsString(person)).isEqualTo(expected);
//    }
//    @Test
//    public void deserializesFromJSON() throws Exception {
//        final Person person = new Person( "asd@asd.asd","giho");
//        assertThat(MAPPER.readValue("{\"email\":\"asd@asd.asd\",\"name\":\"giho\"}", Person.class))
//                .isEqualTo(person);
//    }

}
