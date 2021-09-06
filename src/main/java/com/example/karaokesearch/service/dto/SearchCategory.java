package com.example.karaokesearch.service.dto;

public enum SearchCategory {
    NUMBER(16, 1),
    TITLE(1, 2),
    SINGER(2, 7);

    private final int TJVal;
    private final int KYVal;

    SearchCategory(int tj, int ky) {
        this.TJVal = tj;
        this.KYVal = ky;
    }

    public int getKYVal() {
        return KYVal;
    }

    public int getTJVal() {
        return TJVal;
    }
}
