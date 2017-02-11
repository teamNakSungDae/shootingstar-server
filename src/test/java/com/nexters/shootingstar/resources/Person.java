package com.nexters.shootingstar.resources;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

/**
 * Created by kwongiho on 2017. 2. 11..
 */
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Person {
    @NonNull
    @JsonProperty
    private String email;

    @NonNull
    @JsonProperty
    private String name;

}
