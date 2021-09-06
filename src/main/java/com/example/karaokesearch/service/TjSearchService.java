package com.example.karaokesearch.service;

import com.example.karaokesearch.domain.Karaoke;
import com.example.karaokesearch.domain.Song;
import com.example.karaokesearch.service.dto.SearchRequest;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import javax.swing.text.html.HTML;
import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class TjSearchService implements songSearchService{

    private static final String baseUrl = "https://www.tjmedia.co.kr/tjsong/song_search_list.asp";

    @Override
    public String urlBuilder(SearchRequest searchRequest) {
        StringBuilder stringBuilder = new StringBuilder(baseUrl + "?");
        if (searchRequest.getSearchCategory() != null) {
            stringBuilder.append("strText=" + searchRequest.getKeyword());
        }
        if (searchRequest.getPage() != null) {
            stringBuilder.append("&page=" + searchRequest.getPage());
        }
        if (searchRequest.getSearchCategory() != null) {
            stringBuilder.append("&strType="+ searchRequest.getSearchCategory().getTJVal());
        }
        return stringBuilder.toString();
    }

    public void getSongData(SearchRequest searchRequest) throws IOException {
        String uri = urlBuilder(searchRequest);
        System.out.println(uri);
        Document document = Jsoup.connect(uri).get();
        Elements elements = document.body().select("div#BoardType1").select("tbody").select("tr:has(td)");
        List<Song> songs= new ArrayList<>();
        for (Element element : elements) {
            Elements tdDatas = element.children().select("td");
            Song song = new Song();
            song.setSongNumber(Long.parseLong(tdDatas.get(0).text()));
            song.setTitle(tdDatas.get(1).text());
            song.setSinger(tdDatas.get(2).text());
            song.setKaraoke(Karaoke.TJ);
            songs.add(song);
        }
        songs.forEach(System.out::println);
    }
}
