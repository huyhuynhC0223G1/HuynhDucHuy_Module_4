package com.example.dictionary.service;

import org.springframework.stereotype.Service;

@Service
public interface IDictionaryService {
    String dictionary(String search);
}
