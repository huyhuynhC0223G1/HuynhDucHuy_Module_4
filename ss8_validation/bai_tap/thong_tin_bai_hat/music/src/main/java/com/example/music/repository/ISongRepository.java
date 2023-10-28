package com.example.music.repository;

import com.example.music.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ISongRepository extends JpaRepository<Song, Integer> {
    List<Song> findAllByFlagDeleteIsFalse();
    Song getSongByIdAndFlagDeleteIsFalse(Integer id);
}
