package com.nexters.shootingstar.exception;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.nexters.shootingstar.models.Entity;
import com.nexters.shootingstar.services.jackson.CustomExceptionSerializer;
import lombok.*;

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
    @NonNull
    @JsonProperty
    private String type;
    @NonNull
    @JsonProperty
    private int status;
    @NonNull
    @JsonProperty
    private List<ExceptionDescription> errors;

}
