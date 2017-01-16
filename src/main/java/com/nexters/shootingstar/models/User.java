package com.nexters.shootingstar.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.nexters.shootingstar.services.jackson.UserDeserializer;
import com.nexters.shootingstar.services.jackson.UserSerializer;
import lombok.Data;
import lombok.NonNull;

import java.security.Principal;

/**
 * Created by yoon on 2017. 1. 15..
 */
@Data
@JsonSerialize(using = UserSerializer.class)
@JsonDeserialize(using = UserDeserializer.class)
public class User implements Principal {
    @NonNull
    @JsonProperty
    private String email;


    @Override
    public String getName() {
        return null;
    }
}
