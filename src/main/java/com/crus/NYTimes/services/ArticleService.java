package com.crus.NYTimes.services;

import com.crus.NYTimes.models.Article;
import com.crus.NYTimes.models.NytResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class ArticleService {

    @Value("${api_key}")
    private String apikey;

    @Value("${mostPopularUrl}")
    private String mostPopularUrl;

    @Autowired
    RestTemplate restTemplate;

    /**
     * The restTemplate.getForObject() method submits a GET request to the URL constructed
     * from your mostPopularUrl property and your api_key, and the response is mapped to
     * your new NytResponse class. The response is then checked to be OK, and if so,
     * the List results are returned.
     **/
    public List<Article> getMostPopular() {
        NytResponse response = restTemplate.getForObject(
                mostPopularUrl + "api-key=" + apikey, NytResponse.class);

        List<Article> results = new ArrayList<>();
        if (response != null && response.getStatus().equals("OK")) {
            return response.getResults();
        } else {
            return results;
        }
    }
}
