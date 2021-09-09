package com.example.karaokesearch.service;

import com.example.karaokesearch.domain.Song;
import com.example.karaokesearch.service.dto.SearchRequest;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.util.List;

@Service
public interface songSearchService {
    List<Song> getSongData(SearchRequest searchRequest) throws IOException;
}
