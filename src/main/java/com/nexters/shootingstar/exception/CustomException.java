package com.nexters.shootingstar.exception;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.nexters.shootingstar.models.Entity;
import com.nexters.shootingstar.services.jackson.CustomExceptionSerializer;
import com.sun.istack.internal.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

/**
 * Created by kwongiho on 2017. 2. 11..
 */
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@JsonSerialize(using = CustomExceptionSerializer.class)
public class CustomException implements Entity{
    @NotNull
    @JsonProperty
    private String type;
    @NotNull
    @JsonProperty
    private int status;
    @NotNull
    @JsonProperty
    private List<ExceptionDescription> errors;

}
