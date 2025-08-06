package com.crus.NYTimes.services;

import com.crus.NYTimes.models.Article;
import com.crus.NYTimes.models.NytResponse;
import com.crus.NYTimes.searchModels.Documents;
import com.crus.NYTimes.searchModels.Multimedia;
import com.crus.NYTimes.searchModels.NytSearchResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
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

    @Value("${searchUrl}")
    private String searchUrl;

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

    public List<Documents> getSearchResults(String searchText) {
        try {
            String url = searchUrl + "q=" + searchText + "&api-key=" + apikey;

            ResponseEntity<NytSearchResponse> searchResponse = restTemplate.getForEntity(url, NytSearchResponse.class);

            if (!searchResponse.getStatusCode().is2xxSuccessful() ||
                    searchResponse.getBody() == null ||
                    searchResponse.getBody().getResponse() == null) {
                return new ArrayList<>();
            }

            List<Documents> docs = searchResponse.getBody().getResponse().getDocs();

            if (docs != null) {
            for (Documents doc : docs) {
                if (doc.getMultimedia() != null &&
                        doc.getMultimedia().getThumbnail() != null &&
                        doc.getMultimedia().getThumbnail().getUrl() != null) {
                            doc.setImageUrl(doc.getMultimedia().getThumbnail().getUrl());
                    }
                }
            }
            return docs != null ? docs : new ArrayList<>();
        } catch (Exception e) {
            System.out.println("Exception occurred: " + e.getMessage());
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}
