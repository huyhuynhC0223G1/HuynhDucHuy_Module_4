package com.example.hom_thu_dien_tu.repository.impl;

import com.example.hom_thu_dien_tu.model.Settings;
import com.example.hom_thu_dien_tu.repository.ISettingsRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class SettingsRepository implements ISettingsRepository {
    private static Settings settingsList = new Settings("English", 5, false, "abc");
    private static List<String> languagesList = new ArrayList<>();
    private static List<Integer> pageSizeList = new ArrayList<>();

    static {
        languagesList.add("English");
        languagesList.add("Vietnamese");
        languagesList.add("Japanese");
        languagesList.add("Chinese");
        pageSizeList.add(5);
        pageSizeList.add(10);
        pageSizeList.add(15);
        pageSizeList.add(25);
        pageSizeList.add(50);
        pageSizeList.add(100);
    }

    @Override
    public Settings showAll() {
        return settingsList;
    }

    @Override
    public List<Integer> showPageSize() {
        return pageSizeList;
    }

    @Override
    public List<String> showLanguages() {
        return languagesList;
    }

    @Override
    public void update(Settings settings) {
        settings.setLanguages(settings.getLanguages());
        settings.setPageSize(settings.getPageSize());
        settings.setSpamsFilter(settings.isSpamsFilter());
        settings.setSignature(settings.getSignature());
    }
}
