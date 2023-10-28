package com.example.dictionary.service.impl;

import com.example.dictionary.repository.IDictionaryRepository;
import com.example.dictionary.service.IDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class DictionaryService implements IDictionaryService {
    @Autowired
    private IDictionaryRepository dictionaryRepository;

    @Override
    public String dictionary(String search) {
        String word = dictionaryRepository.dictionary().get(search);
        String result = null;
        if (word != null) {
            result = word;
        } else {
            result = "not found";
        }
        return result;
    }
}
