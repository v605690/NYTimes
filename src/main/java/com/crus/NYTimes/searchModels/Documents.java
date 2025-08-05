package com.crus.NYTimes.searchModels;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class Documents {

    @JsonProperty("abstract")
    private String abstractText;

    @JsonProperty("web_url")
    private String webUrl;

    private String snippet;
    private Headline headline;
    private Byline byline;
    private Multimedia multimedia;
    private String imageUrl;
}
