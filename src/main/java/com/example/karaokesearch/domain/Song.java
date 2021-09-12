package com.example.karaokesearch.domain;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private Long songNumber;

    @Enumerated(value = EnumType.STRING)
    private Karaoke karaoke;

    private String singer;

    private String youtubeLink;

    public Long getId() {
        return this.id;
    }

    public String getTitle() {
        return this.title;
    }

    public Long getSongNumber() {
        return this.songNumber;
    }

    public Karaoke getKaraoke() {
        return this.karaoke;
    }

    public String getSinger() {
        return this.singer;
    }

    public String getYoutubeLink() {
        return youtubeLink;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setSongNumber(Long songNumber) {
        this.songNumber = songNumber;
    }

    public void setKaraoke(Karaoke karaoke) {
        this.karaoke = karaoke;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public void setYoutubeLink(String youtubeLink) {
        this.youtubeLink = youtubeLink;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Song)) return false;
        final Song other = (Song) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        final Object this$title = this.getTitle();
        final Object other$title = other.getTitle();
        if (this$title == null ? other$title != null : !this$title.equals(other$title)) return false;
        final Object this$songNumber = this.getSongNumber();
        final Object other$songNumber = other.getSongNumber();
        if (this$songNumber == null ? other$songNumber != null : !this$songNumber.equals(other$songNumber))
            return false;
        final Object this$karaoke = this.getKaraoke();
        final Object other$karaoke = other.getKaraoke();
        if (this$karaoke == null ? other$karaoke != null : !this$karaoke.equals(other$karaoke)) return false;
        final Object this$singer = this.getSinger();
        final Object other$singer = other.getSinger();
        if (this$singer == null ? other$singer != null : !this$singer.equals(other$singer)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Song;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $title = this.getTitle();
        result = result * PRIME + ($title == null ? 43 : $title.hashCode());
        final Object $songNumber = this.getSongNumber();
        result = result * PRIME + ($songNumber == null ? 43 : $songNumber.hashCode());
        final Object $karaoke = this.getKaraoke();
        result = result * PRIME + ($karaoke == null ? 43 : $karaoke.hashCode());
        final Object $singer = this.getSinger();
        result = result * PRIME + ($singer == null ? 43 : $singer.hashCode());
        return result;
    }

    public String toString() {
        return "Song(id=" + this.getId() +
                ", title=" + this.getTitle() +
                ", songNumber=" + this.getSongNumber() +
                ", karaoke=" + this.getKaraoke() +
                ", singer=" + this.getSinger() +
                ", link=" + this.getYoutubeLink() + ")";
    }
}
