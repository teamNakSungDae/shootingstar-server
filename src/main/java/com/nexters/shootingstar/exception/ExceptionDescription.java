package com.nexters.shootingstar.exception;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nexters.shootingstar.models.Entity;
import lombok.*;

import java.io.Serializable;

/**
 * Created by kwongiho on 2017. 2. 11..
 */
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ExceptionDescription implements Serializable {
    @JsonProperty
    @NonNull
    private String message;

    @JsonProperty
    @NonNull
    private String field;

    @JsonProperty
    @NonNull
    private Entity entity;
}
