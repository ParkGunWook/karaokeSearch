package com.example.karaokesearch.service;

import com.example.karaokesearch.service.dto.SearchCategory;
import com.example.karaokesearch.service.dto.SearchRequest;
import org.jsoup.nodes.Document;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TjSearchServiceTest {

    @Autowired
    public TjSearchService tjSearchService;

    @Test
    void urlBuilder() {
    }

    @Test
    void getSongData() throws IOException {
        SearchRequest searchRequest = SearchRequest.builder().keyword("노래").searchCategory(SearchCategory.TITLE).page(1).build();
        tjSearchService.getSongData(searchRequest);
    }
}