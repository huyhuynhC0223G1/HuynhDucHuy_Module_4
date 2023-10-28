package com.example.sandwich_condiments.controller;

import com.example.sandwich_condiments.service.ICondimentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/condiments")
public class CondimentsController {
    @Autowired
    private ICondimentsService condimentsService;

    @GetMapping()
    public String getCondiment() {
        return "condiments";
    }

    @PostMapping("/create")
    public String createCondiment(@RequestParam(name = "condiment", required = false) String[] condiment, Model model) {
        if (condiment == null) {
            model.addAttribute("result", "don't choose any seasoning");
        } else {
            model.addAttribute("result", Arrays.toString(condimentsService.result(condiment)));
        }
        return "condiments";
    }

}
