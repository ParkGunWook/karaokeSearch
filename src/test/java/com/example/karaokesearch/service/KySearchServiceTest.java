package com.example.karaokesearch.service;

import com.example.karaokesearch.domain.Karaoke;
import com.example.karaokesearch.service.dto.SearchCategory;
import com.example.karaokesearch.service.dto.SearchRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class KySearchServiceTest {

    @Autowired
    private KySearchService kySearchService;

    @Test
    void urlBuilder() {
    }

    @Test
    void getSongData() throws IOException {
        SearchRequest searchRequest = SearchRequest.builder().keyword("누구ㅏ두리마두리ㅏㅁㄷ").searchCategory(SearchCategory.SINGER).page(1).karaoke(Karaoke.KY).build();
        Assertions.assertEquals(kySearchService.getSongData(searchRequest).size(), 0);
        searchRequest = SearchRequest.builder().keyword("잔소리").searchCategory(SearchCategory.TITLE).page(1).karaoke(Karaoke.KY).build();
        Assertions.assertNotEquals(kySearchService.getSongData(searchRequest).size(), 0);
        searchRequest = SearchRequest.builder().keyword("22973").searchCategory(SearchCategory.NUMBER).page(1).karaoke(Karaoke.KY).build();
        Assertions.assertEquals(kySearchService.getSongData(searchRequest).size(), 1);
    }
}