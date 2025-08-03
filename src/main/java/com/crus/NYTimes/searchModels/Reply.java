package com.crus.NYTimes.searchModels;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class Reply {

    @JsonProperty("docs")
    private List<Documents> docs;
}