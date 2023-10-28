package com.example.caculator.service.impl;

import com.example.caculator.service.ICaculatorService;
import org.springframework.stereotype.Service;

@Service
public class CaculatorService implements ICaculatorService {
    @Override
    public String resultCaculator(double number1, double number2, String calculate) {
        String result = null;
        double result1 = 0;
        if (number1 == 0 || number2 == 0) {
            result = "you must enter the full number";
        } else {
            switch (calculate) {
                case "+":
                    result1 = number1 + number2;
                    result = Double.toString(result1);
                    break;
                case "-":
                    result1 = number1 - number2;
                    result = Double.toString(result1);
                    break;
                case "*":
                    result1 = number1 * number2;
                    result = Double.toString(result1);
                    break;
                case "/":
                    if (number2 == 0) {
                        result = "not divided by 0";
                    } else {
                        result1 = number1 / number2;
                        result = Double.toString(result1);
                    }
                    break;
                default:
                    break;
            }
        }
        return result;
    }
}
