package com.example.sandwich_condiments.service.impl;

import com.example.sandwich_condiments.service.ICondimentsService;
import org.springframework.stereotype.Service;


@Service
public class CondimentsService implements ICondimentsService {
    @Override
    public String[] result(String[] condiment) {
        return condiment;
    }
}
