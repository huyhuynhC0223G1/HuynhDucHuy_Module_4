package com.example.music.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class SongDto {
    private Integer id;
    @Size(max = 800)
    @Pattern(regexp = "^[\\w ]+$", message = "Does not contain special characters")
    private String nameSong;

    @Size(max = 300)
    @Pattern(regexp = "^[\\w ]+$", message = "Does not contain special characters")
    private String nameSinger;

    @Size(max = 1000)
    @Pattern(regexp = "^[\\w ,]+$", message = "Does not contain special characters")
    private String category;

    public SongDto() {
    }

    public SongDto(Integer id, String nameSong, String nameSinger, String category) {
        this.id = id;
        this.nameSong = nameSong;
        this.nameSinger = nameSinger;
        this.category = category;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public SongDto(String nameSong, String nameSinger, String category) {
        this.nameSong = nameSong;
        this.nameSinger = nameSinger;
        this.category = category;
    }

    public String getNameSong() {
        return nameSong;
    }

    public void setNameSong(String nameSong) {
        this.nameSong = nameSong;
    }

    public String getNameSinger() {
        return nameSinger;
    }

    public void setNameSinger(String nameSinger) {
        this.nameSinger = nameSinger;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
