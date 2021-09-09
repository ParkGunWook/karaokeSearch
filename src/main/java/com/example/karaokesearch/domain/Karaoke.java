package com.example.karaokesearch.domain;

public enum Karaoke {
    TJ("intPage", "strText", "strType"),
    KY("s_page", "keyword", "category");

    private final String keyWord;
    private final String category;
    private final String searchPage;

    public String getKeyWord() {
        return keyWord;
    }

    public String getCategory() {
        return category;
    }

    public String getSearchPage() {
        return searchPage;
    }

    Karaoke(String searchPage, String keyWord, String category) {
        this.searchPage = searchPage;
        this.keyWord = keyWord;
        this.category = category;
    }
}
