package com.example.karaokesearch.service;

import com.example.karaokesearch.domain.Karaoke;
import com.example.karaokesearch.domain.Song;
import com.example.karaokesearch.service.dto.SearchRequest;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class KySearchService implements songSearchService{

    private static final String baseUrl = "https://kysing.kr/search/";

    @Override
    public String urlBuilder(SearchRequest searchRequest) {
        StringBuilder stringBuilder = new StringBuilder(baseUrl + "?");
        if (searchRequest.getKeyword() != null) {
            stringBuilder.append("keyword=" + searchRequest.getKeyword());
        }
        if (searchRequest.getPage() != null) {
            stringBuilder.append("&s_page=" + searchRequest.getPage());
        }
        if (searchRequest.getSearchCategory() != null) {
            stringBuilder.append("&category="+ searchRequest.getSearchCategory().getKYVal());
        }
        return stringBuilder.toString();
    }

    public void getSongData(SearchRequest searchRequest) throws IOException {
        String uri = urlBuilder(searchRequest);
        System.out.println(uri);
        Document document = Jsoup.connect(uri).get();
        Elements elements = document.body().select("div.search_tab").select("ul.search_chart_list");
        List<Song> songs= new ArrayList<>();
        int i = 0;
        for(Element element : elements) {
            Elements liDatas = element.children().select("li");
            Song song = new Song();
            if (liDatas.select("li.search_chart_num").text().equals("곡번호")) {
                continue;
            }
            song.setSongNumber(Long.parseLong(liDatas.select(".search_chart_num").text()));
            song.setTitle(liDatas.select(".search_chart_tit").select(".tit:first-child").text());
            song.setSinger(liDatas.select(".search_chart_sng").text());
            song.setKaraoke(Karaoke.KY);
            songs.add(song);
        }
        songs.forEach(System.out::println);
    }
}
