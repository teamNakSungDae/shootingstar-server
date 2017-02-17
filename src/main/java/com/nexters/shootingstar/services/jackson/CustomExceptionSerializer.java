package com.nexters.shootingstar.services.jackson;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.nexters.shootingstar.exception.CustomException;

import java.io.IOException;

/**
 * Created by kwongiho on 2017. 2. 11..
 */
public class CustomExceptionSerializer extends JsonSerializer<CustomException> {
    @Override
    public void serialize(CustomException customException, JsonGenerator gen, SerializerProvider serializers)
            throws IOException, JsonProcessingException
    {
        gen.writeStartObject();
        gen.writeStringField("type",customException.getType());
        gen.writeNumberField("status",customException.getStatus());
        gen.writeObjectField("errors",customException.getErrors());
        gen.writeEndObject();
    }

}
