package com.example.hom_thu_dien_tu.service;

import com.example.hom_thu_dien_tu.model.Settings;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ISettingsService {
    Settings showAll();

    List<Integer> showPageSize();

    List<String> showLanguages();

    void update(Settings settings);
}
