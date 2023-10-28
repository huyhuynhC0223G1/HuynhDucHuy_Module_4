package com.example.chuyen_doi_tien_te.service;

import org.springframework.stereotype.Service;

@Service
public interface IConverterService {
    double converter(double rate, double usd);
}
