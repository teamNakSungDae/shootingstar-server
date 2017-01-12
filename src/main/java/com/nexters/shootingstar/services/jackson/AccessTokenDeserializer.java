package com.nexters.shootingstar.services.jackson;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.Deserializers;
import com.nexters.shootingstar.models.AccessToken;

import java.io.IOException;

/**
 * Created by yoon on 2017. 1. 12..
 */
public class AccessTokenDeserializer extends JsonDeserializer<AccessToken> {
    @Override
    public AccessToken deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        JsonNode node = p.getCodec().readTree(p);

        String email = node.get("email").asText();
        String token = node.get("accessToken").asText();

        AccessToken accessToken = new AccessToken(email, token);
        return accessToken;
    }
}
