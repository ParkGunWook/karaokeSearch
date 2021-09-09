package com.example.karaokesearch.service.dto;

import com.example.karaokesearch.domain.Karaoke;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.HashMap;
import java.util.Map;

public class SearchRequest {
    private String keyword;
    private Integer page;
    private SearchCategory searchCategory;
    private Karaoke karaoke;

    SearchRequest(String keyword, Integer page, SearchCategory searchCategory, Karaoke karaoke) {
        this.keyword = keyword;
        this.page = page;
        this.searchCategory = searchCategory;
        this.karaoke = karaoke;
    }

    public static Map<String, String> toMap(SearchRequest searchRequest) {
        Map<String, String> mp = new HashMap<>();
        mp.put(searchRequest.getKaraoke().getKeyWord(), searchRequest.getKeyword());
        if (searchRequest.getKaraoke().equals(Karaoke.TJ)) {
            mp.put(searchRequest.getKaraoke().getCategory(), String.valueOf(searchRequest.getSearchCategory().getTJVal()));
        } else {
            mp.put(searchRequest.getKaraoke().getCategory(), String.valueOf(searchRequest.getSearchCategory().getKYVal()));
        }
        if (searchRequest.getPage() != null)
            mp.put(searchRequest.getKaraoke().getSearchPage(), String.valueOf(searchRequest.getPage()));
        return mp;
    }

    public static SearchParameterBuilder builder() {
        return new SearchParameterBuilder();
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public void setSearchCategory(SearchCategory searchCategory) {
        this.searchCategory = searchCategory;
    }

    public void setKaraoke(Karaoke karaoke) {
        this.karaoke = karaoke;
    }

    public Integer getPage() {
        return page;
    }

    public String getKeyword() {
        return keyword;
    }

    public SearchCategory getSearchCategory() {
        return searchCategory;
    }

    public Karaoke getKaraoke() {
        return karaoke;
    }

    public static class SearchParameterBuilder {
        private String keyword;
        private Integer page;
        private SearchCategory searchCategory;
        private Karaoke karaoke;

        SearchParameterBuilder() {
        }

        public SearchParameterBuilder keyword(String keyword) {
            this.keyword = keyword;
            return this;
        }

        public SearchParameterBuilder page(Integer page) {
            this.page = page;
            return this;
        }

        public SearchParameterBuilder searchCategory(SearchCategory searchCategory) {
            this.searchCategory = searchCategory;
            return this;
        }

        public SearchParameterBuilder karaoke(Karaoke karaoke) {
            this.karaoke = karaoke;
            return this;
        }

        public SearchRequest build() {
            return new SearchRequest(keyword, page, searchCategory, karaoke);
        }

        public String toString() {
            return "SearchParameter.SearchParameterBuilder(keyword=" + this.keyword + ", page=" + this.page + ", searchCategory=" + this.searchCategory + ")";
        }
    }
}
