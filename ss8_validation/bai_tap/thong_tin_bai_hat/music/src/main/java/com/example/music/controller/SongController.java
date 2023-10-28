package com.example.music.controller;

import com.example.music.dto.SongDto;
import com.example.music.model.Song;
import com.example.music.service.ISongService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/song")
public class SongController {
    @Autowired
    private ISongService songService;

    @GetMapping("")
    public String getSong(Model model) {
        model.addAttribute("songlist", songService.findAllByFlagDeleteIsFalse());
        return "/home";
    }

    @GetMapping("/create")
    public String showSongForm(Model model) {
        model.addAttribute("songDto", new SongDto());
        return "/create";
    }

    @PostMapping("/save")
    public String saveCraete(@Valid @ModelAttribute SongDto songDto, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "/create";
        }
        Song songEntity = new Song();
        BeanUtils.copyProperties(songDto, songEntity);
        songService.create(songEntity);
        redirectAttributes.addFlashAttribute("message", "Successfully Added New");
        return "redirect:/song";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable int id, Model model, RedirectAttributes redirectAttributes) {
        if (songService.findById(id) == null) {
            redirectAttributes.addFlashAttribute("error", "id not found");
            return "redirect:/song";
        } else {
            model.addAttribute("songDto", songService.findById(id));
            return "/edit";
        }
    }

    @PostMapping("/update")
    public String update(@Valid @ModelAttribute SongDto songDto, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (songService.findById(songDto.getId()) == null) {
            redirectAttributes.addFlashAttribute("error", "id not found");
            return "redirect:/song";
        } else {
            if (bindingResult.hasErrors()) {
                return "/edit";
            }
            Song songEntity = new Song();
            BeanUtils.copyProperties(songDto, songEntity);
            songService.update(songEntity);
            redirectAttributes.addFlashAttribute("message", "Successfully Update");
            return "redirect:/song";
        }
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id, RedirectAttributes redirectAttributes) {
        if (songService.findById(id) == null) {
            redirectAttributes.addFlashAttribute("error", "id not found");
            return "redirect:/song";
        } else {
            songService.remove(id);
            redirectAttributes.addFlashAttribute("message", "Successfully Delete");
            return "redirect:/song";
        }
    }
}

