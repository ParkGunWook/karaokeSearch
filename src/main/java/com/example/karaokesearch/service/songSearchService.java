package com.example.karaokesearch.service;

import com.example.karaokesearch.service.dto.SearchRequest;
import org.springframework.stereotype.Service;

import java.net.URI;

@Service
public interface songSearchService {
    public String urlBuilder(SearchRequest searchRequest);
}
