package com.example.hom_thu_dien_tu.controller;

import com.example.hom_thu_dien_tu.model.Settings;
import com.example.hom_thu_dien_tu.service.ISettingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class SettingsController {
    @Autowired
    private ISettingsService settingsService;

    @GetMapping("")
    public String showSettings(Model model) {
        model.addAttribute("settings", settingsService.showAll());
        return "display";
    }

    @GetMapping("/update-settings")
    public String showUpdateSettings(Model model) {
        model.addAttribute("settings", settingsService.showAll());
        model.addAttribute("languagesList", settingsService.showLanguages());
        model.addAttribute("pageSizeList", settingsService.showPageSize());
        return "update";
    }

    @PostMapping("/update-settings")
    public String updateSettings(@ModelAttribute("settings") Settings settings) {
        settingsService.update(settings);
        return "display";
    }
}
