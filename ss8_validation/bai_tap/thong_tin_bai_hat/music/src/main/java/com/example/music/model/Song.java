package com.example.music.model;

import javax.persistence.*;

@Entity
public class Song {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(columnDefinition = "text")
    private String nameSong;
    @Column(columnDefinition = "text")
    private String nameSinger;
    @Column(columnDefinition = "text")
    private String category;
    private boolean flagDelete;

    public Song() {
    }

    public Song(Integer id, String nameSong, String nameSinger, String category, boolean flagDelete) {
        this.id = id;
        this.nameSong = nameSong;
        this.nameSinger = nameSinger;
        this.category = category;
        this.flagDelete = flagDelete;
    }

    public Song(Integer id, String nameSong, String nameSinger, String category) {
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

    public boolean isFlagDelete() {
        return flagDelete;
    }

    public void setFlagDelete(boolean flagDelete) {
        this.flagDelete = flagDelete;
    }
}
