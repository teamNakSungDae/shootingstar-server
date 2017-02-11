package com.nexters.shootingstar.services.jackson;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.nexters.shootingstar.exception.CustomException;
import com.nexters.shootingstar.exception.ExceptionDescription;
import com.nexters.shootingstar.models.AccessToken;

import java.io.IOException;
import java.util.*;

/**
 * Created by kwongiho on 2017. 2. 11..
 */
public class CustomExceptionDeserializer extends JsonDeserializer<CustomException> {
    @Override
    public CustomException deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        JsonNode node = p.getCodec().readTree(p);

        List<ExceptionDescription> exceptionDescriptionList = new ArrayList<ExceptionDescription>();

        String type = node.get("type").asText();
        int status = node.get("status").asInt();
        List<JsonNode> lists = node.findValues("errors");

        for(JsonNode jd : lists.get(0))
            exceptionDescriptionList.add(
                    new ExceptionDescription(
                            jd.get("message").asText(),
                            jd.get("field").asText() ,
                            new AccessToken(
                                    jd.get("entity").get("email").asText(),
                                    jd.get("entity").get("token").asText()
                            )
                    )
            );

        return new CustomException(
                type , status , exceptionDescriptionList
        );

    }
}
