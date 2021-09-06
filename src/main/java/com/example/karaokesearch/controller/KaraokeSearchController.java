package com.example.karaokesearch.controller;

import com.example.karaokesearch.domain.Song;
import com.example.karaokesearch.service.dto.SearchRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/search")
public class KaraokeSearchController {
    @GetMapping()
    public List<Song> getSongs(@RequestBody SearchRequest searchRequest) {
        return new ArrayList<>();
    }
}
