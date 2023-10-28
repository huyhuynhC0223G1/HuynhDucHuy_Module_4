package com.example.chuyen_doi_tien_te.controller;

import com.example.chuyen_doi_tien_te.service.IConverterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/converter")
public class ConverterController {

    @Autowired
    private IConverterService converterService;

    @GetMapping()
    public String inputConverter() {
        return "converter";
    }

    @PostMapping("/result")
    public String converter(@RequestParam("rate") double rate, @RequestParam("usd") double usd, Model model) {
        model.addAttribute("result", converterService.converter(rate, usd));
        return "converter";
    }
}
