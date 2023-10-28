package com.example.dictionary.controller;

import com.example.dictionary.repository.IDictionaryRepository;
import com.example.dictionary.service.IDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/dictionary")
public class DictionaryController {

    @Autowired
    private IDictionaryService dictionaryService;

    @GetMapping()
    public String inputDictionary() {
        return "dictionary";
    }

    @PostMapping("/result")
    public String dictionary(@RequestParam("search") String search, Model model) {
        model.addAttribute("search", search);
        model.addAttribute("result", dictionaryService.dictionary(search));
        return "dictionary";
    }
}
