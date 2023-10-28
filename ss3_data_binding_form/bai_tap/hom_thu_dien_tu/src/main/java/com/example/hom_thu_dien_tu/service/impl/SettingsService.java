package com.example.hom_thu_dien_tu.service.impl;

import com.example.hom_thu_dien_tu.model.Settings;
import com.example.hom_thu_dien_tu.repository.ISettingsRepository;
import com.example.hom_thu_dien_tu.service.ISettingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SettingsService implements ISettingsService {
    @Autowired
    private ISettingsRepository settingsRepository;

    @Override
    public Settings showAll() {
        return settingsRepository.showAll();
    }

    @Override
    public List<Integer> showPageSize() {
        return settingsRepository.showPageSize();
    }

    @Override
    public List<String> showLanguages() {
        return settingsRepository.showLanguages();
    }

    @Override
    public void update(Settings settings) {
        settingsRepository.update(settings);
    }
}
