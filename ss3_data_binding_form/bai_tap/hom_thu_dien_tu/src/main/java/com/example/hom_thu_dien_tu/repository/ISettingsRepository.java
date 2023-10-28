package com.example.hom_thu_dien_tu.repository;

import com.example.hom_thu_dien_tu.model.Settings;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ISettingsRepository {
    Settings showAll();

    List<Integer> showPageSize();

    List<String> showLanguages();

    void update(Settings settings);
}
