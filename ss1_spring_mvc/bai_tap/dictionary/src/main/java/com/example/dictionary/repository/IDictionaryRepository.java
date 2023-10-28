package com.example.dictionary.repository;

import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public interface IDictionaryRepository {
Map<String, String> dictionary();
}
