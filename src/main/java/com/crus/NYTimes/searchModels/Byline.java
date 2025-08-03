package com.crus.NYTimes.searchModels;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Byline {

    @JsonProperty("author")
    private String original;
}
