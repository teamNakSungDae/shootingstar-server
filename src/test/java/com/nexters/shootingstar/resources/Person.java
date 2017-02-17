package com.nexters.shootingstar.resources;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.internal.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Created by kwongiho on 2017. 2. 11..
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Person {
    @NotNull
    @JsonProperty
    private String email;

    @NotNull
    @JsonProperty
    private String name;

}
