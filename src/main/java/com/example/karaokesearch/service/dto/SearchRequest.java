package com.example.karaokesearch.service.dto;

import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

public class SearchRequest {
    private String keyword;
    private Integer page;
    private SearchCategory searchCategory;

    SearchRequest(String keyword, Integer page, SearchCategory searchCategory) {
        this.keyword = keyword;
        this.page = page;
        this.searchCategory = searchCategory;
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

    public Integer getPage() {
        return page;
    }

    public String getKeyword() {
        return keyword;
    }

    public SearchCategory getSearchCategory() {
        return searchCategory;
    }



    public static class SearchParameterBuilder {
        private String keyword;
        private Integer page;
        private SearchCategory searchCategory;

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

        public SearchRequest build() {
            return new SearchRequest(keyword, page, searchCategory);
        }

        public String toString() {
            return "SearchParameter.SearchParameterBuilder(keyword=" + this.keyword + ", page=" + this.page + ", searchCategory=" + this.searchCategory + ")";
        }
    }
}
