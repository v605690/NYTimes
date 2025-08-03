package com.crus.NYTimes.searchModels;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Headline {

    @JsonProperty("main")
    private String main;
}
