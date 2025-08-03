package com.crus.NYTimes.searchModels;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class Documents {

    private Headline headline;
    private Byline byline;
    private List<Multimedia> multimedia;
    private String imageUrl;
}
