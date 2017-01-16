package com.nexters.shootingstar.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.nexters.shootingstar.services.jackson.AccessTokenDeserializer;
import com.nexters.shootingstar.services.jackson.AccessTokenSerializer;
import lombok.Data;
import lombok.NonNull;

/**
 * Created by yoon on 2017. 1. 12..
 */
@Data
@JsonSerialize(using = AccessTokenSerializer.class)
@JsonDeserialize(using = AccessTokenDeserializer.class)
public class AccessToken {
    @NonNull
    @JsonProperty
    private String email;

    @NonNull
    @JsonProperty
    private String token;
}
