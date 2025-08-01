package com.crus.NYTimes.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class Media {

    @JsonProperty("type")
    private String type;
    private String subtype;

    @JsonProperty("caption")
    private String caption;
    // I don't see url in API
    private String url;

    @JsonProperty("media-metadata")
    private List<Thumbnail> mediaMetadata;
}
