package com.example.music.service.impl;

import com.example.music.model.Song;
import com.example.music.repository.ISongRepository;
import com.example.music.service.ISongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongService implements ISongService {
    @Autowired
    private ISongRepository songRepository;

    @Override
    public List<Song> findAllByFlagDeleteIsFalse() {
        return songRepository.findAllByFlagDeleteIsFalse();
    }

    @Override
    public void create(Song song) {
        songRepository.save(song);
    }

    @Override
    public Song findById(Integer id) {
        return songRepository.findById(id).orElse(null);
    }

    @Override
    public void update(Song song) {
        songRepository.save(song);
    }

    @Override
    public void remove(Integer id) {
        Song song = songRepository.getSongByIdAndFlagDeleteIsFalse(id);
        song.setFlagDelete(true);
        songRepository.save(song);
    }
}
