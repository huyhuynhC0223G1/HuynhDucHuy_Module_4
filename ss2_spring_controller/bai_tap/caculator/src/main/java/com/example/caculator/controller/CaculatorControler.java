package com.example.caculator.controller;

import com.example.caculator.service.ICaculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/caculator")
public class CaculatorControler {

    @Autowired
    private ICaculatorService caculatorService;

    @GetMapping()
    public String getCaculator() {
        return "caculator";
    }

    @PostMapping("/calculate")
    public String calculate(@RequestParam(name = "number1", defaultValue = "0") double number1,
                            @RequestParam(name = "number2", defaultValue = "0") double number2,
                            @RequestParam(name = "calculate") String calculate, Model model) {
        model.addAttribute("number1", number1);
        model.addAttribute("number2", number2);
        model.addAttribute("result", caculatorService.resultCaculator(number1, number2, calculate));
        return "caculator";
    }
}
