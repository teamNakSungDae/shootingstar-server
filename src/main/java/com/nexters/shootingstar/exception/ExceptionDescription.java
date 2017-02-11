package com.nexters.shootingstar.exception;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nexters.shootingstar.models.Entity;
import com.sun.istack.internal.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

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
    @NotNull
    private String message;
    @JsonProperty
    @NotNull
    private String field;
    @JsonProperty
    @NotNull
    private Entity entity;
}
