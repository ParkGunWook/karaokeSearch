package com.example.karaokesearch.controller;

import com.example.karaokesearch.domain.Karaoke;
import com.example.karaokesearch.domain.Song;
import com.example.karaokesearch.service.KySearchService;
import com.example.karaokesearch.service.TjSearchService;
import com.example.karaokesearch.service.dto.SearchCategory;
import com.example.karaokesearch.service.dto.SearchRequest;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/search")
@Api(tags = "통합 검색수행하는 api입니다.")
public class KaraokeSearchController {

    private final TjSearchService tjSearchService;
    private final KySearchService kySearchService;

    public KaraokeSearchController(TjSearchService tjSearchService, KySearchService kySearchService) {
        this.tjSearchService = tjSearchService;
        this.kySearchService = kySearchService;
    }

    @GetMapping()
    public List<Song> getSongs(@RequestParam String keyWord,
                               @RequestParam Karaoke karaoke,
                               @RequestParam(required = false) Integer page,
                               @RequestParam(name = "searchBy") SearchCategory searchCategory
                               ) throws IOException {
        SearchRequest searchRequest = SearchRequest.builder().
                keyword(keyWord).
                searchCategory(searchCategory).
                page(page).
                karaoke(karaoke).
                build();
        if (searchRequest.getKaraoke().equals(Karaoke.TJ)) {
            return tjSearchService.getSongData(searchRequest);
        } else {
            return kySearchService.getSongData(searchRequest);
        }
    }
}
