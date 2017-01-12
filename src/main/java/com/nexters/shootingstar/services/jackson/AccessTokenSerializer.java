package com.nexters.shootingstar.services.jackson;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.nexters.shootingstar.models.AccessToken;

import java.io.IOException;

/**
 * Created by yoon on 2017. 1. 13..
 */
public class AccessTokenSerializer extends JsonSerializer<AccessToken> {
    @Override
    public void serialize(AccessToken accessToken, JsonGenerator gen, SerializerProvider serializers)
            throws IOException, JsonProcessingException
    {
        gen.writeStartObject();
        gen.writeStringField("email", accessToken.getEmail());
        gen.writeStringField("accessToken", accessToken.getAccessToken());
        gen.writeEndObject();
    }
}
