package com.example.dictionary.repository.impl;

import com.example.dictionary.repository.IDictionaryRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class DictionaryRepository implements IDictionaryRepository {
    private static Map<String, String> dictionarymap = new HashMap<>();
    static {
        dictionarymap.put("hello", "xin chào");
        dictionarymap.put("goodbye", "chào tạm biệt");
        dictionarymap.put("book", "quyển sách");
        dictionarymap.put("pen", "cái bút");
    }
    public Map<String, String> dictionary() {
        return dictionarymap;
    }
}
