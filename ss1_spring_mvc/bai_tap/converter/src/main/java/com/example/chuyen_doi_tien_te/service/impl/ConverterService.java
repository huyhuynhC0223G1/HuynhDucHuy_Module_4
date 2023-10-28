package com.example.chuyen_doi_tien_te.service.impl;

import com.example.chuyen_doi_tien_te.service.IConverterService;
import org.springframework.stereotype.Service;

@Service
public class ConverterService implements IConverterService {

    @Override
    public double converter(double rate, double usd) {
        double result = rate * usd;
        return result;
    }
}
