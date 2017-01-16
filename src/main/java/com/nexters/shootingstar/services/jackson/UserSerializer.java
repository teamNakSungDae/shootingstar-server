package com.nexters.shootingstar.services.jackson;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.nexters.shootingstar.models.User;

import java.io.IOException;

/**
 * Created by yoon on 2017. 1. 16..
 */
public class UserSerializer extends JsonSerializer<User> {
    @Override
    public void serialize(User user, JsonGenerator gen, SerializerProvider serializers) throws IOException, JsonProcessingException {
        gen.writeStartObject();
        gen.writeStringField("email", user.getEmail());
        gen.writeEndObject();
    }
}
