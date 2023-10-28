package com.example.music.service;

import com.example.music.model.Song;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ISongService {
    List<Song> findAllByFlagDeleteIsFalse();

    void create(Song song);

    Song findById(Integer id);

    void update(Song song);

    void remove(Integer id);
}
